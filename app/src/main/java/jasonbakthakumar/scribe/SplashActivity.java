package jasonbakthakumar.scribe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(currentUser != null){
            Intent intent = new Intent(this, MIActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
            finish();
        }

    }

}
