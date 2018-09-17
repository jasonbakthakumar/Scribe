package jasonbakthakumar.scribe;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


import java.util.ArrayList;
import java.util.List;

import jasonbakthakumar.scribe.Onboarder.OnboarderActivity;
import jasonbakthakumar.scribe.Onboarder.OnboarderPage;

public class WelcomeScreen extends OnboarderActivity {

    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onboarderPages = new ArrayList<OnboarderPage>();

        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage(R.string.onboard_one_title, R.string.onboard_one_desc,R.drawable.first_onboard);
        OnboarderPage onboarderPage2 = new OnboarderPage(R.string.onboard_two_title, R.string.onboard_two_desc, R.drawable.second_onboard);
        OnboarderPage onboarderPage3 = new OnboarderPage(R.string.onboard_three_title,R.string.onboard_three_desc,R.drawable.third_onboard);
        OnboarderPage onboarderPage4 = new OnboarderPage(R.string.onboard_four_title,R.string.onboard_four_desc,R.drawable.fourth_onboard);
        OnboarderPage onboarderPage5 = new OnboarderPage(R.string.onboard_five_title,R.string.onboard_five_desc,R.drawable.fifth_onboard);
        OnboarderPage onboarderPage6 = new OnboarderPage(R.string.onboard_six_title,R.string.onboard_six_desc,R.drawable.sixth_onboard);

        // You can define title and description colors (by default white)

        // Don't forget to set background color for your page
        onboarderPage1.setBackgroundColor(R.color.onboard_one);
        onboarderPage2.setBackgroundColor(R.color.onboard_two);
        onboarderPage3.setBackgroundColor(R.color.onboard_three);
        onboarderPage4.setBackgroundColor(R.color.onboard_four_back);
        onboarderPage4.setDescriptionColor(R.color.onboard_four);
        onboarderPage4.setTitleColor(R.color.onboard_four);
        onboarderPage5.setBackgroundColor(R.color.white);
        onboarderPage5.setTitleColor(R.color.black);
        onboarderPage5.setDescriptionColor(R.color.black);
        onboarderPage6.setBackgroundColor(R.color.white);
        onboarderPage6.setTitleColor(R.color.onboard_sixth_content_color);
        onboarderPage6.setDescriptionColor(R.color.onboard_sixth_content_color);
        // Add your pages to the list
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);
        onboarderPages.add(onboarderPage4);
        onboarderPages.add(onboarderPage5);
        onboarderPages.add(onboarderPage6);
        shouldUseFloatingActionButton(true);


        // And pass your pages to 'setOnboardPagesReady' method
        setOnboardPagesReady(onboarderPages);


    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        if(position >= 3){
            setActiveIndicatorColor(R.color.colorPrimaryDark);
            setInactiveIndicatorColor(R.color.onboard_sixth_content_color);
        }
        else{
            setActiveIndicatorColor(android.R.color.white);
            setInactiveIndicatorColor(android.R.color.darker_gray);
        }


    }

    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(WelcomeScreen.this,LoginActivity.class));
    }


    @Override
    public void onSkipButtonPressed() {
        // Optional: by default it skips onboarder to the end
        super.onSkipButtonPressed();
        // Define your actions when the user press 'Skip' button
    }


    @Override
    public void onBackPressed() {

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }



}
