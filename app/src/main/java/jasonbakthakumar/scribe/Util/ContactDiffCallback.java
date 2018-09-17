package jasonbakthakumar.scribe.Util;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by jasonbakthakumar on 14/01/17.
 */

public class ContactDiffCallback extends DiffUtil.Callback{

    private List<Contact> mOldList;
    private List<Contact> mNewList;

    public ContactDiffCallback(List<Contact> oldList, List<Contact> newList) {
        this.mOldList = oldList;
        this.mNewList = newList;
    }
    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        // add a unique ID property on Contact and expose a getId() method
        return mOldList.get(oldItemPosition).getVibe().equals(mNewList.get(newItemPosition).getVibe()) || mOldList.get(oldItemPosition).getName().equals(mNewList.get(newItemPosition).getName());
        //return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldContact = mOldList.get(oldItemPosition);
        Contact newContact = mNewList.get(newItemPosition);
        return oldContact.getName().equals(newContact.getName()) && oldContact.isOnScribe() ^ newContact.isOnScribe() && oldContact.getVibe().equals(newContact.getVibe());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
