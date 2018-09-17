package jasonbakthakumar.scribe.Util;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import jasonbakthakumar.scribe.Onboarder.OnboarderPage;

/**
 * Created by jasonbakthakumar on 07/03/17.
 */

public class ColorsArrayBuilder {

    public static Integer[] getPageBackgroundColors(Context context, List<OnboarderPage> pages) {
        List<Integer> colorsList = new ArrayList<>();
        for (OnboarderPage page : pages) {
            colorsList.add(ContextCompat.getColor(context, page.getBackgroundColor()));
        }
        return colorsList.toArray(new Integer[pages.size()]);
    }
}
