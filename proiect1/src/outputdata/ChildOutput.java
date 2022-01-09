package outputdata;

import child.Child;
import enums.Category;
import enums.Cities;
import inputdata.GiftData;

import java.util.ArrayList;

public final class ChildOutput {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<Category> giftsPreferences;
    private double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private double assignedBudget;
    private ArrayList<GiftData> receivedGifts;

    public ChildOutput() {
    }

    public ChildOutput(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = new ArrayList<>(child.getCategories());
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<GiftData> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<GiftData> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}