package jasonbakthakumar.scribe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

import jasonbakthakumar.scribe.DotsAnimation.DotLoader;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    public TextInputLayout emailLayout;
    public TextInputLayout passwordLayout;
    public EditText emailEditText;
    public EditText passwordEditText;
    public Button signInButton;
    public Button signUpButton;
    public Button loginWithFacebookButton;
    public Button loginInWithGoogleButton;
    private FirebaseAuth mAuth;
    public ConstraintLayout layout;
    public DotLoader dotLoader;
    public CallbackManager callbackManager;
    public LoginManager loginManager;
    public GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        passwordLayout = (TextInputLayout) findViewById(R.id.textInputLayout2);
        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);
        signInButton = (Button) findViewById(R.id.sign_in_button);
        signUpButton = (Button) findViewById(R.id.sign_up_button);
        loginWithFacebookButton = (Button) findViewById(R.id.button5);
        loginInWithGoogleButton = (Button) findViewById(R.id.button4);
        dotLoader = (DotLoader) findViewById(R.id.text_dot_loader);
        layout = (ConstraintLayout) findViewById(R.id.activity_login);
        mAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        //google sign in setup
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                dotLoader.setVisibility(View.VISIBLE);
                handleFacebookAccessToken(loginResult.getAccessToken());


            }

            @Override
            public void onCancel() {
                dotLoader.setVisibility(View.INVISIBLE);
                Snackbar.make(layout, R.string.com_facebook_loginview_cancel_action, Snackbar.LENGTH_LONG)
                        .setAction(R.string.try_again, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dotLoader.setVisibility(View.VISIBLE);
                                facebookButtonClickedAction();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();

            }

            @Override
            public void onError(FacebookException error) {
                dotLoader.setVisibility(View.INVISIBLE);
                String exceptionMessage = error.getMessage();
                Snackbar.make(layout, exceptionMessage, Snackbar.LENGTH_LONG)
                        .setAction(R.string.try_again, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dotLoader.setVisibility(View.VISIBLE);
                                facebookButtonClickedAction();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();

            }
        });





    }

    private void handleFacebookAccessToken(AccessToken accessToken) {

        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        final AccessToken acs = accessToken;
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //its signed up
                            dotLoader.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, "Welcome !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,IntroActivity.class));

                        }
                        else{
                            //its not signed up
                            dotLoader.setVisibility(View.INVISIBLE);
                            String exceptionMessage = task.getException().getMessage();
                            Snackbar.make(layout, exceptionMessage, Snackbar.LENGTH_LONG)
                                    .setAction(R.string.try_again, new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dotLoader.setVisibility(View.VISIBLE);
                                            handleFacebookAccessToken(acs);
                                        }
                                    })
                                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                                    .show();
                        }


                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();

        //when sign up is clicked
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean credentialsCheck = checkIfTheCredsAreValid();
                if(credentialsCheck){
                    dotLoader.setVisibility(View.VISIBLE);
                    signUpLogic(emailEditText.getText().toString(),passwordEditText.getText().toString());
                }
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean credentialsCheck = checkIfTheCredsAreValid();
                if(credentialsCheck){
                    dotLoader.setVisibility(View.VISIBLE);
                    signInLogic(emailEditText.getText().toString(),passwordEditText.getText().toString());
                }
            }
        });

        //when facebook button is Clicked
        loginWithFacebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailLayout.setErrorEnabled(false);
                passwordLayout.setErrorEnabled(false);
                facebookButtonClickedAction();
            }
        });

        //when google button is Clicked
        loginInWithGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailLayout.setErrorEnabled(false);
                passwordLayout.setErrorEnabled(false);
                signInWithGoogle();
            }
        });
    }

    private void signInWithGoogle() {
        dotLoader.setVisibility(View.VISIBLE);
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void facebookButtonClickedAction() {
        dotLoader.setVisibility(View.VISIBLE);
        loginManager.logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile","email"));
    }

    private void signUpLogic(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //its signed up
                    dotLoader.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Welcome !", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,IntroActivity.class));

                }
                else{
                    //its not signed up
                    dotLoader.setVisibility(View.INVISIBLE);
                    Snackbar.make(layout, R.string.sign_up_fail, Snackbar.LENGTH_LONG)
                            .setAction(R.string.try_again, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dotLoader.setVisibility(View.VISIBLE);
                                    signUpLogic(emailEditText.getText().toString(),passwordEditText.getText().toString());
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                            .show();
                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                dotLoader.setVisibility(View.INVISIBLE);
                Snackbar.make(layout, R.string.google_sign_in_fail, Snackbar.LENGTH_LONG)
                        .setAction(R.string.try_again, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                signInWithGoogle();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();
            }

        }
        else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        final GoogleSignInAccount acc = account;
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            dotLoader.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, "Welcome !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,IntroActivity.class));


                        }

                        else{
                            dotLoader.setVisibility(View.INVISIBLE);
                            String exceptionMessage = task.getException().getMessage();
                            Snackbar.make(layout, exceptionMessage, Snackbar.LENGTH_LONG)
                                    .setAction(R.string.try_again, new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dotLoader.setVisibility(View.VISIBLE);
                                            firebaseAuthWithGoogle(acc);
                                        }
                                    })
                                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                                    .show();
                        }

                        // [END_EXCLUDE]
                    }
                });

    }


    @Override
    public void onBackPressed() {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }


    private void signInLogic(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //its signed up
                    dotLoader.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Welcome !", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,IntroActivity.class));

                }
                else{
                    //its not signed up
                    String exceptionMessage = task.getException().getMessage();
                    dotLoader.setVisibility(View.INVISIBLE);
                    Snackbar.make(layout, exceptionMessage, Snackbar.LENGTH_LONG)
                            .setAction(R.string.try_again, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dotLoader.setVisibility(View.VISIBLE);
                                    signInLogic(emailEditText.getText().toString(),passwordEditText.getText().toString());
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                            .show();
                }

            }
        });
    }


    private boolean checkIfTheCredsAreValid() {
        if(isValidEmail(emailEditText.getText().toString()) && isValidPassword(passwordEditText.getText().toString())){
            emailLayout.setErrorEnabled(false);
            passwordLayout.setErrorEnabled(false);
            return true;
        }
        else if(!isValidEmail(emailEditText.getText().toString())){
            emailLayout.setErrorEnabled(true);
            emailLayout.setError("Please enter a valid email");
            passwordLayout.setErrorEnabled(false);
            return false;
        }
        else if(!isValidPassword(passwordEditText.getText().toString())){
            emailLayout.setErrorEnabled(false);
            passwordLayout.setErrorEnabled(true);
            passwordLayout.setError("Please enter minimum 6 characers");
            return false;
        }
        else{
            emailLayout.setErrorEnabled(true);
            emailLayout.setError("Please enter valid credentials");
            passwordLayout.setErrorEnabled(false);
            return false;
        }

    }

    private static boolean isValidPassword(String s) {
        return s.length() >= 6;
    }


    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        dotLoader.setVisibility(View.INVISIBLE);
        String exceptionMessage = connectionResult.getErrorMessage();
        Snackbar.make(layout, exceptionMessage, Snackbar.LENGTH_LONG)
                .setAction(R.string.try_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signInWithGoogle();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                .show();
    }
}
