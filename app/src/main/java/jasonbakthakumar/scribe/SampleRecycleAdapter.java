package jasonbakthakumar.scribe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jasonbakthakumar.scribe.Util.SampleData;

/**
 * Created by jasonbakthakumar on 20/08/17.
 */

public class SampleRecycleAdapter extends
        RecyclerView.Adapter<SampleRecycleAdapter.ViewHolder> {

    private List<SampleData> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public SampleRecycleAdapter(Context context, List<SampleData> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    @Override
    public SampleRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.sample_card_view, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(SampleRecycleAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        SampleData contact = mContacts.get(position);
        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getTopic());
        TextView button = viewHolder.messageButton;
        button.setText(contact.getContent());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.textView);
            messageButton = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
