package database;

import child.Baby;
import child.Child;
import child.Kid;
import child.Teen;
import common.Constants;
import inputData.AnnualChangeData;
import inputData.ChildData;
import inputData.GiftData;
import inputData.InitialData;
import fileio.Input;

import java.util.ArrayList;

public final class Database {
    private static Database database = new Database();
    private static int numberOfYears;
    private static double santaBudget;
    private static InitialData initialData;
    private static ArrayList<AnnualChangeData> annualChanges;
    private static ArrayList<Child> childList;
    private static ArrayList<GiftData> giftList;
    private static int roundCounter = 0;

    private Database() {
    }

    public static Database getDatabase() {
        return database;
    }

    public static int getNumberOfYears() {
        return numberOfYears;
    }

    public static double getSantaBudget() {
        return santaBudget;
    }

    public static InitialData getInitialData() {
        return initialData;
    }

    public static ArrayList<AnnualChangeData> getAnnualChanges() {
        return annualChanges;
    }

    public static ArrayList<Child> getChildList() {
        return childList;
    }

    public static ArrayList<GiftData> getGiftList() {
        return giftList;
    }

    public static void initDatabase(final Input input) {
        numberOfYears = input.getNumberOfYears();
        santaBudget = input.getSantaBudget();
        initialData = input.getInitialData();
        annualChanges = input.getAnnualChanges();
        childList = new ArrayList<>();
        for (ChildData childData : input.getInitialData().getChildren()) {
            if (childData.getAge() < Constants.MAX_BABY_AGE) {
                childList.add(new Baby(childData));
            } else if (childData.getAge() < Constants.MAX_KID_AGE) {
                childList.add(new Kid(childData));
            } else if (childData.getAge() <= Constants.MAX_TEEN_AGE) {
                childList.add(new Teen(childData));
            }
        }
        giftList = new ArrayList<>(input.getInitialData().getSantaGiftsList());
    }

    public static int getRoundCounter() {
        return roundCounter;
    }

    public static void incrementRoundCounter() {
        roundCounter++;
    }
}
