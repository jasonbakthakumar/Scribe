package jasonbakthakumar.scribe.FabMenu;

import android.support.design.internal.NavigationMenu;
import android.view.MenuItem;

/**
 * Created by jasonbakthakumar on 28/11/16.
 */

public class SimpleMenuListenerAdapter implements FabSpeedDial.MenuListener {

    @Override
    public boolean onPrepareMenu(NavigationMenu navigationMenu) {

        return true;
    }

    @Override
    public boolean onMenuItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override
    public void onMenuClosed() {
    }
}
