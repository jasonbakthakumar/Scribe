package jasonbakthakumar.scribe.Util;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by jasonbakthakumar on 23/02/17.
 */


@IgnoreExtraProperties
public class UserVisits {
    public int numberOfTimesVisited;
    public String lastUpdated;


    public UserVisits() {

    }

    public UserVisits(int numberOfTimesVisited, String lastUpdated) {
        this.numberOfTimesVisited = numberOfTimesVisited;
        this.lastUpdated = lastUpdated;
    }

    @Exclude
    public int getNumberOfTimesVisited() {
        return numberOfTimesVisited;
    }

    @Exclude
    public void setNumberOfTimesVisited(int numberOfTimesVisited) {
        this.numberOfTimesVisited = numberOfTimesVisited;
    }

    @Exclude
    public String getLastUpdated() {
        return lastUpdated;
    }

    @Exclude
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
