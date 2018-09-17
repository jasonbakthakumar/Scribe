package jasonbakthakumar.scribe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import jasonbakthakumar.scribe.Util.RecyclerItemClickListener;
import jasonbakthakumar.scribe.Util.SampleData;

/**
 * Created by jasonbakthakumar on 20/08/17.
 */

public class SampleFragment extends Fragment {

    ArrayList<SampleData> contacts;

    public SampleFragment() {
        //Required Empty Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sample_recycle_fragment, container, false);
        contacts = SampleData.createSampleList(20);
        SampleRecycleAdapter adapter = new SampleRecycleAdapter(getContext(),contacts);

        RecyclerView rvContacts = (RecyclerView) rootView.findViewById(R.id.rvContacts);
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        //rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
// Attach the layout manager to the recycler view
        rvContacts.setLayoutManager(gridLayoutManager);

        rvContacts.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), rvContacts, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), String.valueOf(position) + " Item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));
        return rootView;

    }
}
