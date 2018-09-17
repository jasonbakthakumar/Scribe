package jasonbakthakumar.scribe;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jasonbakthakumar.scribe.FabMenu.FabSpeedDial;
import jasonbakthakumar.scribe.Util.Contact;
import jasonbakthakumar.scribe.Util.DatabaseHelper;
import jasonbakthakumar.scribe.Util.RecyclerItemClickListener;

/**
 * Created by jasonbakthakumar on 27/02/17.
 */

public class ReContactsFragment extends Fragment {


    public static final int REQUEST_CONTACT_PERMISSION = 1;
    private View includedLayout;
    private TextView allowAccess;
    private RecyclerView contactRV;
    private FabSpeedDial fabSpeedDial;
    private TextView promptText;
    private LinearLayout progressBar;
    private ContactsAdapter adapter;
    private DatabaseHelper db;
    private Intent intent;
    private SwipeRefreshLayout swipeContainer;
    SharedPreferences prefs;

    public ReContactsFragment() {
        //Required Empty Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_real_contact, container, false);
        includedLayout = rootView.findViewById(R.id.included_layout);
        contactRV = (RecyclerView) rootView.findViewById(R.id.rvContacts);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
        progressBar = (LinearLayout) rootView.findViewById(R.id.linearLayout);
        fabSpeedDial = (FabSpeedDial) getActivity().findViewById(R.id.fab_menu);
        allowAccess = (TextView) includedLayout.findViewById(R.id.textView8);
        promptText = (TextView) includedLayout.findViewById(R.id.textView7);
        prefs = getActivity().getSharedPreferences("REG", Context.MODE_PRIVATE);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark);
        return rootView;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = new DatabaseHelper(getActivity());
        checkForTheContactsPermission();

    }

    private void checkForTheContactsPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            //PERMISSION HAS BEEN GRANTED
            includedLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            loadTheContactRV();
        }
        else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.READ_CONTACTS)){

                swipeContainer.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                includedLayout.setVisibility(View.VISIBLE);

                //Show the request permission rationale.
            }
            else{
                ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.READ_CONTACTS},
                        REQUEST_CONTACT_PERMISSION);
            }
        }


    }

    private void loadTheContactRV() {

        if(prefs.getBoolean("contactsNotChecked",true)){
            swipeContainer.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            //startTheProcess
            prefs.edit().putBoolean("contactsNotChecked",false).apply();
            intent = new Intent(getActivity(), ReContactService.class);
            intent.putExtra("dataPopulate",true);
            intent.putExtra(ReContactService.RECEIVER, resultReceiver);
            getActivity().startService(intent);
        }
        else {
            if(prefs.getBoolean("contactEmpty",false)){
                //contact is empty
                contactIsEmptyDoStuff();
            }
            else{
                //contactAintEmpty
                doTheActualLoading();
            }

        }
    }

    private void doTheActualLoading() {
        if(db != null){
            List<Contact> contactList = db.getAllContacts();
            adapter = new ContactsAdapter(getActivity(), sortTheContactsList(contactList));
            contactRV.setLayoutManager(new LinearLayoutManager(getContext()));
            contactRV.setAdapter(adapter);
        }

    }


    private final ResultReceiver resultReceiver = new ResultReceiver(new Handler()){
        @SuppressWarnings("unchecked")
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if(resultCode == 10){
                if(prefs.getBoolean("contactEmpty",false)){
                    contactIsEmptyDoStuff();
                }
                else{
                    //contactIsNotEmpty
                    doTheFirstTimeActualThing();
                }
            }
            else{
                if(prefs.getBoolean("contactEmpty",false)){
                    swipeContainer.setRefreshing(false);
                    contactIsEmptyDoStuff();
                }
                else{
                    //contactIsNotEmpty
                    swipeContainer.setRefreshing(false);
                    updateTheExistingRV();


                }

            }
        }
    };

    private void updateTheExistingRV() {
        if(adapter != null){
            List<Contact> contacts = db.getAllContacts();
            adapter.swapItems(sortTheContactsList(contacts));
        }
        else{
            doTheActualLoading();

        }
    }

    private void doTheFirstTimeActualThing() {
        progressBar.setVisibility(View.GONE);
        includedLayout.setVisibility(View.GONE);
        swipeContainer.setVisibility(View.VISIBLE);
        contactRV.setVisibility(View.VISIBLE);
        if(db != null){
            List<Contact> contactList = db.getAllContacts();
            adapter = new ContactsAdapter(getActivity(), sortTheContactsList(contactList));
            contactRV.setAdapter(adapter);
            contactRV.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }

    private List<Contact> sortTheContactsList(List<Contact> contacts) {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return (o2.isOnScribe() == o1.isOnScribe()) ? 0 : (o2.isOnScribe() ? 1 : -1);
            }
        });
        return contacts;
    }


    private void contactIsEmptyDoStuff() {
        swipeContainer.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        includedLayout.setVisibility(View.VISIBLE);
        allowAccess.setText(R.string.retry);
        promptText.setText(R.string.prompt_empty_contacts);
    }


    @Override
    public void onResume() {
        super.onResume();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(contactRV.getVisibility() == View.VISIBLE){
                    //doThisActionOnlyWhenTheThingIsVisible
                    intent = new Intent(getActivity(), ReContactService.class);
                    intent.putExtra("dataPopulate",false);
                    intent.putExtra(ReContactService.RECEIVER, resultReceiver);
                    getActivity().startService(intent);
                }
                else{
                    swipeContainer.setRefreshing(false);
                }
            }
        });

        allowAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS},
                            REQUEST_CONTACT_PERMISSION);
                }
                else{
                    if(allowAccess.getText().toString().equals("Retry")){
                        swipeContainer.setVisibility(View.GONE);
                        includedLayout.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        //stuff to get it started
                        intent = new Intent(getActivity(), ReContactService.class);
                        intent.putExtra("dataPopulate",true);
                        intent.putExtra(ReContactService.RECEIVER, resultReceiver);
                        getActivity().startService(intent);
                    }
                }
            }
        });

        if(contactRV.getVisibility() == View.VISIBLE){
            contactRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE)
                    {
                        fabSpeedDial.show();
                    }
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (dy > 0 || dy<0 && fabSpeedDial.isShown())
                    {
                        fabSpeedDial.hide();
                    }
                    super.onScrolled(recyclerView, dx, dy);
                }
            });

            contactRV.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), contactRV, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {



                }

                @Override
                public void onItemLongClick(View view, int position) {
                    // ...
                }
            }));
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case REQUEST_CONTACT_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    swipeContainer.setVisibility(View.VISIBLE);
                    contactRV.setVisibility(View.VISIBLE);
                    includedLayout.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    loadTheContactRV();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    swipeContainer.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    includedLayout.setVisibility(View.VISIBLE);
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }


                break;


            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;

        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(intent != null){
            getActivity().stopService(intent);
        }


    }


}
