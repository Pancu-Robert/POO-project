package child;

import visitor.Visitable;
import visitor.Visitor;
import enums.Category;
import enums.Cities;
import inputdata.ChildData;

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
    public abstract void accept(Visitor v);

    public Child() {
    }

    public Child(final ChildData childData) {
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

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(final int age) {
        this.age = age;
    }

    public final ArrayList<Category> getCategories() {
        return categories;
    }

    public final void setCategories(final ArrayList<Category> categories) {
        this.categories = categories;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public final void incrementAge() {
        this.age++;
    }

    public final void addPreferences(final ArrayList<Category> newPreferences) {
        newPreferences.addAll(this.categories);
        ArrayList<Category> auxList = new ArrayList<>();

//        for (Category category : newPreferences) {
//            if (!auxList.contains(category)) {
//                auxList.add(category);
//            }
//        }

        for (Category category : newPreferences) {
            boolean found = false;
            for (Category category2 : auxList) {
                if (category2.getValue().equals(category.getValue())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                auxList.add(category);
            }
        }

        this.getCategories().clear();
        this.getCategories().addAll(auxList);
    }
}
