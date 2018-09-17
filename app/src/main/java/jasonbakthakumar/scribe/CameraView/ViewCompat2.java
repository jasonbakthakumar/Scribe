package jasonbakthakumar.scribe.CameraView;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.View;

/**
 * Created by jasonbakthakumar on 30/10/16.
 */

class ViewCompat2 {


    private ViewCompat2() {
    }

    /**
     * Gets the logical display to which the view's window has been attached.
     *
     * @param view The view.
     * @return The logical display, or null if the view is not currently attached to a window.
     */
    public static Display getDisplay(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        return ViewCompat.isAttachedToWindow(view) ?
                DisplayManagerCompat.getInstance(view.getContext())
                        .getDisplay(Display.DEFAULT_DISPLAY) : null;
    }

}
