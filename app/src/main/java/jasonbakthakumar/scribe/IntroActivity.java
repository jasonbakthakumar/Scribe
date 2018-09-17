package jasonbakthakumar.scribe;

import android.*;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import jasonbakthakumar.scribe.CameraView.CameraView;

public class IntroActivity extends AppCompatActivity implements
        ActivityCompat.OnRequestPermissionsResultCallback{


    private static final String PICTURE_FILE = "profilePicture.jpg";
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 2;
    private static final int REQUEST_READ_SMS = 3;
    private static final String FRAGMENT_DIALOG = "dialog";
    public final static int PICK_PHOTO_CODE = 1046;
    private CameraView mCameraView;
    private ImageButton cameraSwitch;
    public ImageButton takePictureButton;
    public ImageButton galleryButton;
    public ImageView mainProfilePicture;
    public ImageButton retryButton;
    public ImageButton cancelButton;
    public TextInputLayout nameEditTextLayout;
    public EditText nameEditText;
    public FloatingActionButton fab;
    public ConstraintLayout constraintLayout;
    private ProgressDialog progress;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mCameraView = (CameraView) findViewById(R.id.surfaceView2);
        cameraSwitch = (ImageButton) findViewById(R.id.imageButton3);
        takePictureButton = (ImageButton) findViewById(R.id.imageButton);
        galleryButton = (ImageButton) findViewById(R.id.imageButton4);
        mainProfilePicture = (ImageView) findViewById(R.id.imageView3);
        retryButton = (ImageButton) findViewById(R.id.imageButton5);
        cancelButton = (ImageButton) findViewById(R.id.imageButton2);
        nameEditTextLayout = (TextInputLayout) findViewById(R.id.nameEditTextLayout);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        if (user != null) {
            storageRef = storage.getReferenceFromUrl("gs://scribe-75cc7.appspot.com").child("users").child(user.getUid()).child("profilePicture.png");

        } else {
            storageRef = storage.getReferenceFromUrl("gs://scribe-75cc7.appspot.com").child("AnonymousUsers").child(UUID.randomUUID().toString()).child("profilePicture.png");
        }
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        constraintLayout = (ConstraintLayout) findViewById(R.id.activity_intro);

        if (mCameraView != null) {
            mCameraView.addCallback(new CameraView.Callback() {
                @Override
                public void onPictureTaken(CameraView cameraView, final byte[] data) {

                            File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                                    PICTURE_FILE);
                            OutputStream os = null;
                            try {
                                os = new FileOutputStream(file);
                                os.write(data);
                                os.close();
                                loadBitmapFromFile(file.getAbsolutePath());
                            } catch (IOException e) {
                                Toast.makeText(IntroActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            } finally {
                                if (os != null) {
                                    try {
                                        os.close();
                                    } catch (IOException e) {
                                        // Ignore
                                    }
                                }
                            }


                }
            });
        }

    }

    private void loadBitmapFromFile(String absolutePath) {
        mainProfilePicture.setVisibility(View.VISIBLE);
        nameEditTextLayout.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        retryButton.setVisibility(View.VISIBLE);
        cancelButton.setVisibility(View.GONE);
        DecodeBitmapAsyncTask decodeBitmapAsyncTask = new DecodeBitmapAsyncTask(mainProfilePicture);
        decodeBitmapAsyncTask.execute(absolutePath);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION:
                if (permissions.length != 1 || grantResults.length != 1) {
                    Toast.makeText(this, "Error Requesting Camera Permission", Toast.LENGTH_SHORT).show();
                }
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, R.string.content_text,
                            Toast.LENGTH_SHORT).show();
                }
                // No need to start camera here; it is handled by onResume
                break;

            case REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, PICK_PHOTO_CODE);
                    }
                }
                else{
                    Snackbar.make(constraintLayout, R.string.access_denied_to_storage, Snackbar.LENGTH_LONG)
                            .setAction(R.string.try_again, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (ActivityCompat.shouldShowRequestPermissionRationale(IntroActivity.this,
                                            android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                                        ConfirmationDialogFragment
                                                .newInstance(R.string.read_permission_not_granted,
                                                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                                        REQUEST_READ_EXTERNAL_STORAGE,
                                                        R.string.read_permission_confirmation)
                                                .show(getSupportFragmentManager(), FRAGMENT_DIALOG);
                                    }
                                    else{
                                        ActivityCompat.requestPermissions(IntroActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                                REQUEST_READ_EXTERNAL_STORAGE);
                                    }
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                            .show();
                }
                break;

            case REQUEST_READ_SMS:
                if(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startActivity(new Intent(IntroActivity.this,PhoneNumber.class));
                }
                else{
                    startActivity(new Intent(IntroActivity.this,PhoneNumber.class));
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;

        }
    }



    @Override
    public void onBackPressed() {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            mCameraView.start();
            if(mCameraView != null){
                int facing = mCameraView.getFacing();
                cameraSwitch.setImageResource(facing == CameraView.FACING_FRONT ?
                        R.drawable.ic_camera_rear_white_36dp : R.drawable.ic_camera_front_white_36dp);
            }

        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CAMERA)) {
                ConfirmationDialogFragment
                        .newInstance(R.string.camera_permission_not_granted,
                                new String[]{android.Manifest.permission.CAMERA},
                                REQUEST_CAMERA_PERMISSION,
                                R.string.camera_permission_confirmation)
                        .show(getSupportFragmentManager(), FRAGMENT_DIALOG);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},
                        REQUEST_CAMERA_PERMISSION);
            }
        }

        cameraSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCameraView != null && getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)){
                        int facing = mCameraView.getFacing();
                        mCameraView.setFacing(facing == CameraView.FACING_FRONT ?
                                CameraView.FACING_BACK : CameraView.FACING_FRONT);
                        cameraSwitch.setImageResource(facing == CameraView.FACING_FRONT ?
                                R.drawable.ic_camera_front_white_36dp : R.drawable.ic_camera_rear_white_36dp);
                }
            }
        });

        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCameraView != null && ContextCompat.checkSelfPermission(IntroActivity.this, android.Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                   mCameraView.takePicture();
                }
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionAndDoAccordingly();
            }
        });


        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainProfilePicture.setVisibility(View.GONE);
                nameEditTextLayout.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                retryButton.setVisibility(View.GONE);
                cancelButton.setVisibility(View.VISIBLE);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainProfilePicture.setVisibility(View.VISIBLE);
                nameEditTextLayout.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                retryButton.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.GONE);
                mainProfilePicture.setImageResource(R.drawable.pic_place_holder);

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameEditText.getText().toString().isEmpty()) {
                    nameEditTextLayout.setErrorEnabled(false);
                    mainProfilePicture.setDrawingCacheEnabled(true);
                    mainProfilePicture.buildDrawingCache();
                    Bitmap bitmap = mainProfilePicture.getDrawingCache();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    mainProfilePicture.setDrawingCacheEnabled(false);
                    fab.setEnabled(false);
                    byte[] data = baos.toByteArray();
                    UploadTask task = storageRef.putBytes(data);
                    uploadTheGivenFile(task);


                }
                else{
                    nameEditTextLayout.setErrorEnabled(true);
                    nameEditTextLayout.setError("Please enter your name");
                }

            }
        });

    }

    private void uploadTheGivenFile(final UploadTask task) {
        progress=new ProgressDialog(IntroActivity.this);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setMessage("Uploading your Pic. Hang On.");
        progress.setCancelable(false);
        progress.show();
        task.addOnFailureListener(IntroActivity.this,new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                fab.setEnabled(true);
                progress.dismiss();
                Snackbar.make(constraintLayout, R.string.could_not_upload_image, Snackbar.LENGTH_LONG)
                        .setAction(R.string.try_again, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                uploadTheGivenFile(task);
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();
            }
        }).addOnSuccessListener(IntroActivity.this,new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                progress.dismiss();
                updateTheUserInformation(downloadUrl);
            }
        });
    }

    private void updateTheUserInformation(final Uri downloadUrl) {
        progress=new ProgressDialog(IntroActivity.this);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setMessage("Uploading your Pic. Hang On.");
        progress.setCancelable(false);
        progress.show();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(nameEditText.getText().toString())
                .setPhotoUri(downloadUrl)
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            SharedPreferences sharedpreferences = getSharedPreferences("REG", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("name",nameEditText.getText().toString());
                            editor.putString("profilePicture",downloadUrl.toString());
                            editor.apply();
                            if(progress.isShowing()){
                                progress.dismiss();
                            }
                            fab.setEnabled(true);
                            startSMSVerificationFlow();
                        }
                        else{
                            if(progress.isShowing()){
                                progress.dismiss();
                            }
                            fab.setEnabled(true);
                            Snackbar.make(constraintLayout, R.string.could_not_upload_image, Snackbar.LENGTH_LONG)
                                    .show();
                        }
                    }
                });
    }

    private void startSMSVerificationFlow() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS)
                == PackageManager.PERMISSION_GRANTED) {

            startActivity(new Intent(IntroActivity.this, PhoneNumber.class));

        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.RECEIVE_SMS)) {
                ConfirmationDialogFragment
                        .newInstance(R.string.sms_permission_not_granted,
                                new String[]{Manifest.permission.RECEIVE_SMS},
                                REQUEST_READ_SMS,
                                R.string.sms_permission_confirmation)
                        .show(getSupportFragmentManager(), FRAGMENT_DIALOG);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},
                        REQUEST_READ_SMS);
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_PHOTO_CODE) {
            if(resultCode == RESULT_OK && data != null ){
            Uri photoUri = data.getData();
            mainProfilePicture.setVisibility(View.VISIBLE);
            nameEditTextLayout.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
            retryButton.setVisibility(View.VISIBLE);
            cancelButton.setVisibility(View.GONE);
            try {
                Bitmap selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
                mainProfilePicture.setImageBitmap(Bitmap.createScaledBitmap(selectedImage, 300, 300, true));
            } catch (IOException e) {
                Toast.makeText(this, R.string.could_not_load_image, Toast.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(constraintLayout, R.string.no_pic_chosen, Snackbar.LENGTH_LONG)
                    .setAction(R.string.try_again, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(intent, PICK_PHOTO_CODE);
                            }
                        }
                    })
                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                    .show();
        }
    }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // If there's an upload in progress, save the reference so you can query it later
        if (storageRef != null) {
            outState.putString("reference", storageRef.toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final String stringRef = savedInstanceState.getString("reference");
        if (stringRef == null) {
            return;
        }
        storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(stringRef);
        List tasks = storageRef.getActiveUploadTasks();
        if (tasks.size() > 0) {
            UploadTask task = (UploadTask) tasks.get(0);
            uploadTheGivenFile(task);

        }

    }

    private void checkPermissionAndDoAccordingly() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, PICK_PHOTO_CODE);
            }

        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ConfirmationDialogFragment
                        .newInstance(R.string.read_permission_not_granted,
                                new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_READ_EXTERNAL_STORAGE,
                                R.string.read_permission_confirmation)
                        .show(getSupportFragmentManager(), FRAGMENT_DIALOG);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_READ_EXTERNAL_STORAGE);
            }
        }
    }




    @Override
    protected void onPause() {
        mCameraView.stop();
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
