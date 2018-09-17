package jasonbakthakumar.scribe;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;
import jasonbakthakumar.scribe.Util.Contact;
import jasonbakthakumar.scribe.Util.ContactDiffCallback;
import jasonbakthakumar.scribe.Util.OthCircleView;
import jasonbakthakumar.scribe.Util.SectionedRecyclerAdapter;

/**
 * Created by jasonbakthakumar on 19/12/16.
 */

public class ContactsAdapter extends
        SectionedRecyclerAdapter<ContactsAdapter.SubheaderViewHolder,ContactsAdapter.ViewHolder> {


    // ... view holder defined above...

    // Store a member variable for the contacts
    private List<Contact> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public ContactsAdapter(Context context, List<Contact> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    public Contact getContact(int position){
        return mContacts.get(position - 2 > 0 ? position - 2 : 0);
    }




    @Override
    public boolean onPlaceSubheaderBetweenItems(int itemPosition, int nextItemPosition) {
        //return true if you want to place subheader between two neighboring items
        final Contact contact1 = mContacts.get(itemPosition);
        final Contact contact2 = mContacts.get(nextItemPosition);
        return !contact1.getName().substring(0, 1).equalsIgnoreCase(contact2.getName().substring(0, 1)) && (contact1.isOnScribe() != contact2.isOnScribe() || !contact1.isOnScribe());

    }

    @Override
    public SubheaderViewHolder onCreateSubheaderViewHolder(ViewGroup parent, int viewType) {
        return new SubheaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rv_header, parent, false));
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.contact_rv_item, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindSubheaderViewHolder(SubheaderViewHolder subheaderViewHolder, int nextItemPosition) {
        //Setup subheader view
        //nextItemPosition - position of item that placed after subheader
        Contact contact = mContacts.get(nextItemPosition);
        if(contact.isOnScribe()){
            subheaderViewHolder.headerTextView.setText(R.string.your_friends_on_scribe);
        }
        else{
            subheaderViewHolder.headerTextView.setText(contact.getName().substring(0,1).toUpperCase());
        }
    }



    @Override
    public void onBindItemViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
        //Setup item view
        Contact contact = mContacts.get(position);
        if(contact.getName() != null)
            viewHolder.nameTextView.setText(contact.getName());
        viewHolder.vibeTextView.setText(contact.getVibe());
        if(contact.isOnScribe()){
            viewHolder.inviteTextView.setVisibility(View.GONE);
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReferenceFromUrl(contact.getProfilePictureUrl());
            Glide.with(mContext).using(new FirebaseImageLoader()).load(storageReference).error(R.drawable.pic_place_holder).override(55,55).centerCrop().into(viewHolder.profilePictureImageView);
        }
        else{
            viewHolder.inviteTextView.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(R.drawable.pic_placeholder_cute).into(viewHolder.profilePictureImageView);

        }

    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    public void swapItems(List<Contact> contacts) {
        // compute diffs
      final ContactDiffCallback diffCallback = new ContactDiffCallback(this.mContacts, contacts);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        // clear contacts and add
        this.mContacts.clear();
        this.mContacts.addAll(contacts);
        diffResult.dispatchUpdatesTo(this); // calls adapter's notify methods after diff is computed
    }

    public boolean hasItemsInIt() {
        return mContacts != null;
    }

    public static class SubheaderViewHolder extends RecyclerView.ViewHolder {

        public TextView headerTextView;

        public SubheaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = (TextView) itemView.findViewById(R.id.textView12);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView vibeTextView;
        public TextView inviteTextView;
        public OthCircleView profilePictureImageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.textView9);
            vibeTextView = (TextView) itemView.findViewById(R.id.textView10);
            inviteTextView = (TextView) itemView.findViewById(R.id.textView11);
            profilePictureImageView = (OthCircleView) itemView.findViewById(R.id.imageView7);
        }
    }
}



