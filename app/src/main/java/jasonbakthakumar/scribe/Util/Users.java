package jasonbakthakumar.scribe.Util;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by jasonbakthakumar on 09/01/17.
 */

@IgnoreExtraProperties
public class Users {

    public String email;
    public String name;
    public String phoneNumber;
    public String photoUrl;
    public String uid;
    public String vibe;

    public Users() {
        //mandatory constructor

    }

    public Users(String email, String name, String phoneNumber, String photoUrl, String uid, String vibe) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.uid = uid;
        this.vibe = vibe;
    }

    @Exclude
    public String getEmail() {
        return email;
    }

    @Exclude
    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getName() {
        return name;
    }

    @Exclude
    public void setName(String name) {
        this.name = name;
    }

    @Exclude
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Exclude
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Exclude
    public String getPhotoUrl() {
        return photoUrl;
    }

    @Exclude
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Exclude
    public String getUid() {
        return uid;
    }

    @Exclude
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Exclude
    public String getVibe() {
        return vibe;
    }

    @Exclude
    public void setVibe(String vibe) {
        this.vibe = vibe;
    }
}
