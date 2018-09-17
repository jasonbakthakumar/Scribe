package jasonbakthakumar.scribe.Util;

import android.app.DownloadManager;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by jasonbakthakumar on 19/12/16.
 */

public class SortCollectionsAsyncTask extends AsyncTask<ArrayList<Contact>,Void,ArrayList<Contact>> {


    @Override
    protected ArrayList<Contact> doInBackground(ArrayList<Contact>... params) {

        ArrayList<Contact> ct = params[0];

        Collections.sort(ct, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Collections.sort(ct, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return (o2.isOnScribe() == o1.isOnScribe()) ? 0 : (o2.isOnScribe() ? 1 : -1);
            }
        });


        return ct;
    }


}
