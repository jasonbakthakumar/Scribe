package jasonbakthakumar.scribe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jasonbakthakumar.scribe.FabMenu.FabSpeedDial;
import jasonbakthakumar.scribe.FabMenu.SimpleMenuListenerAdapter;
import jasonbakthakumar.scribe.Util.CircularImageView;
import jasonbakthakumar.scribe.Util.UserVisits;

public class MIActivity extends AppCompatActivity {


    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private TabLayout tabLayout;
    private TextView emailHeaderText;
    private TextView nameHeaderText;
    private CircularImageView navDisplayPicture;
    private FabSpeedDial fabSpeedDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        fabSpeedDial = (FabSpeedDial) findViewById(R.id.fab_menu);
        View headerLayout = nvDrawer.inflateHeaderView(R.layout.nav_header);
        drawerToggle = setupDrawerToggle();
        setupDrawerContent(nvDrawer);
        mDrawer.addDrawerListener(drawerToggle);
        if(savedInstanceState == null){
            HandlerFragment cg = new HandlerFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, cg).commit();
        }

        if(currentUser != null){
            emailHeaderText = (TextView) headerLayout.findViewById(R.id.textView5);
            nameHeaderText = (TextView) headerLayout.findViewById(R.id.textView6);
            navDisplayPicture = (CircularImageView) headerLayout.findViewById(R.id.imageView2);
        }

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home_fragment:
                fragmentClass = HandlerFragment.class;
                Toast.makeText(this, "First Fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_notes_fragment:
                fragmentClass = ContactsFragment.class;
                tabLayout.setVisibility(View.GONE);
                Toast.makeText(this, "Second Fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_todo_fragment:
                fragmentClass = ContactsFragment.class;
                tabLayout.setVisibility(View.GONE);
                Toast.makeText(this, "Third Fragment", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragmentClass = HandlerFragment.class;
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("REG", MODE_PRIVATE);
        if(!prefs.getBoolean("done",false)){
            Bundle params = new Bundle();
            params.putBoolean("bad_experience", true);
            FirebaseAnalytics.getInstance(MIActivity.this).logEvent("bad_verification", params);
            startActivity(new Intent(MIActivity.this,PhoneNumber.class));
        }
        if(prefs.getBoolean("firstRun",true) && prefs.getBoolean("done",false)){
            //do what you wanna do
            if(currentUser != null){
                String name = prefs.getString("name","New User");
                String email = currentUser.getEmail();
                String photoUrl = prefs.getString("profilePicture",null);
                String uid = currentUser.getUid();
                String phone = prefs.getString("phoneNumber","3108");
                Map<String, Object> moreDetails = new HashMap<String, Object>();
                moreDetails.put("name",name);
                moreDetails.put("email",email);
                moreDetails.put("photoUrl",photoUrl);
                moreDetails.put("uid",uid);
                moreDetails.put("phoneNumber",phone);
                moreDetails.put("vibe","Feeling Good");
                DatabaseReference childRef = mDatabase.child("users").child(uid);
                childRef.updateChildren(moreDetails);
            }
            prefs.edit().putBoolean("firstRun", false).apply();
        }



        //fabSpeedDial click Logic
        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                //TODO: Start some activity
                switch (menuItem.getItemId()){
                    case R.id.action_note:
                        startActivity(new Intent(MIActivity.this,NoteActivity.class));
                        break;

                    case R.id.action_todo:


                        break;
                    case R.id.action_notebooks:


                        break;


                    case R.id.action_live_session:



                        break;
                    default:
                        return false;

                }

                return false;
            }
        });

        if(currentUser != null){
            nameHeaderText.setText(prefs.getString("name",null) == null ? "New User" : prefs.getString("name",""));
            emailHeaderText.setText(currentUser.getEmail());
            if(prefs.getString("profilePicture",null) != null){
                 FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(prefs.getString("profilePicture",null));
                Glide.with(this).using(new FirebaseImageLoader()).load(storageReference).error(R.drawable.pic_place_holder).override(80,80).centerCrop().into(navDisplayPicture);
            }
        }


        DatabaseReference userVisitCountRef = mDatabase.child("userVisits").child(currentUser.getUid());
        userVisitCountRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                UserVisits userVisits = mutableData.getValue(UserVisits.class);
                if(userVisits == null){
                    return Transaction.success(mutableData);
                }
                else{
                    userVisits.setNumberOfTimesVisited(userVisits.getNumberOfTimesVisited() + 1);
                    userVisits.setLastUpdated(new Date().toString());
                }

                mutableData.setValue(userVisits);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                //do something when it's over...:)

            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed() {
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawers();
        }
        else{
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
        }

    }


}
