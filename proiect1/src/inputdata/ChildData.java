package inputdata;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public class ChildData {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public ChildData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
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
