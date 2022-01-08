package inputdata;

import enums.Category;

import java.util.ArrayList;

public class ChildUpdateData {
    private int id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
