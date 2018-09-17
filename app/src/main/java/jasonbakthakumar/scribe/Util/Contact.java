package jasonbakthakumar.scribe.Util;

/**
 * Created by jasonbakthakumar on 19/12/16.
 */

public class Contact {
    private String name;
    private String vibe;
    private boolean isOnScribe;
    private String profilePictureUrl;
    private String uid;


    public Contact(String name, String vibe, boolean isOnScribe, String profilePictureUrl, String uid) {
        this.name = name;
        this.vibe = vibe;
        this.isOnScribe = isOnScribe;
        this.profilePictureUrl = profilePictureUrl;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public boolean isOnScribe() {
        return isOnScribe;
    }

    public void setOnScribe(boolean onScribe) {
        isOnScribe = onScribe;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
