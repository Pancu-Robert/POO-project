package child;

import Visitor.Visitable;
import Visitor.Visitor;
import enums.Category;
import enums.Cities;
import inputData.ChildData;

import java.util.ArrayList;

public abstract class Child implements Visitable {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private ArrayList<Category> categories;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Child() {
    }

    public Child (ChildData childData) {
        this.id = childData.getId();
        this.lastName = childData.getLastName();
        this.firstName = childData.getFirstName();
        this.city = childData.getCity();
        this.age = childData.getAge();
        this.categories = new ArrayList<>(childData.getGiftsPreferences());
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        niceScoreHistory.add(childData.getNiceScore());
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(Cities city) {
        this.city = city;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public final ArrayList<Category> getCategories() {
        return categories;
    }

    public final void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public final ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }
}
