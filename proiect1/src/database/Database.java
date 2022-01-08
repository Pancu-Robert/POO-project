package database;

import visitor.ScoreCalculator;
import visitor.Visitor;
import child.Baby;
import child.Child;
import child.Kid;
import child.Teen;
import common.Constants;
import enums.Category;
import inputdata.AnnualChangeData;
import inputdata.ChildData;
import inputdata.ChildUpdateData;
import inputdata.GiftData;
import inputdata.InitialData;
import fileio.Input;
import outputData.ChildOutput;
import outputData.OutputData;
import outputData.RoundOutput;

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
        roundCounter = 0;
    }

    public static int getRoundCounter() {
        return roundCounter;
    }

    public static void incrementRoundCounter() {
        roundCounter++;
    }

    public static Child findChild(final int id) {
        for (Child child : Database.getChildList()) {
            if (child.getId() == id) {
                return child;
            }
        }
        return null;
    }

    public static final class Executor {
        private Executor() {
        }

        public static OutputData runSimulation() {
            OutputData outputData = new OutputData(new ArrayList<>());
            for (int i = 0; i <= Database.numberOfYears; i++) {
                outputData.getAnnualChildren().add(simulateRound());
                applyUpdates();
            }
            return outputData;
        }

        public static RoundOutput simulateRound() {
            RoundOutput roundOutput = new RoundOutput(new ArrayList<>());
            Visitor calculator = new ScoreCalculator();
            Database.childList.forEach(child -> child.accept(calculator));
            double budgetUnit = getBudgetUnit();
            for (Child child : Database.getChildList()) {
                roundOutput.getChildren().add(sendGifts(child, budgetUnit));
            }
            Database.incrementRoundCounter();
            return roundOutput;
        }

        public static double getBudgetUnit() {
            double scoreSum = 0.0;
            for (Child child : Database.childList) {
                scoreSum += child.getAverageScore();
            }
            double budget = (Database.roundCounter == 0) ? Database.santaBudget
                    : Database.annualChanges.get(Database.roundCounter - 1).getNewSantaBudget();
            return budget / scoreSum;
        }

        public static ChildOutput sendGifts(final Child child, final double budgetUnit) {
            ChildOutput childOutput = new ChildOutput(child);
            double assignedBudget = budgetUnit * child.getAverageScore();
            childOutput.setAssignedBudget(assignedBudget);

            for (Category category : child.getCategories()) {
                GiftData selectedGift = null;
                for (GiftData gift : Database.giftList) {
                    if (gift.getCategory().getValue().equals(category.getValue())
                    && (selectedGift == null || selectedGift.getPrice() > gift.getPrice())) {
                        selectedGift = gift;
                    }
                }
                if (selectedGift != null && selectedGift.getPrice() <= assignedBudget) {
                    assignedBudget -= selectedGift.getPrice();
                    childOutput.getReceivedGifts().add(selectedGift);
                }
            }
            return childOutput;
        }

        public static void applyUpdates() {
            if (Database.roundCounter > Database.numberOfYears) {
                return;
            }
            Database.giftList.addAll(Database.getAnnualChanges()
                    .get(Database.roundCounter - 1).getNewGifts());

            Database.childList.forEach(Child::incrementAge);
            Database.childList.removeIf(child -> child.getAge() > Constants.MAX_TEEN_AGE);

            ArrayList<Child> auxList = new ArrayList<>();

            for (Child child : Database.getChildList()) {
                if (child.getAge() < Constants.MAX_BABY_AGE) {
                    auxList.add(new Baby(child));
                } else if (child.getAge() < Constants.MAX_KID_AGE) {
                    auxList.add(new Kid(child));
                } else if (child.getAge() <= Constants.MAX_TEEN_AGE) {
                    auxList.add(new Teen(child));
                }
            }
            childList.clear();
            childList.addAll(auxList);

            for (ChildUpdateData childUpdateData : Database.getAnnualChanges()
                    .get(Database.roundCounter - 1).getChildrenUpdates()) {
                Child child = findChild(childUpdateData.getId());
                if (child != null) {
                    child.addPreferences(childUpdateData.getGiftsPreferences());
                    if (childUpdateData.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(childUpdateData.getNiceScore());
                    }
                }
            }

            for (ChildData childData : Database.getAnnualChanges()
                    .get(Database.roundCounter - 1).getNewChildren()) {
                if (childData.getAge() < Constants.MAX_BABY_AGE) {
                    childList.add(new Baby(childData));
                } else if (childData.getAge() < Constants.MAX_KID_AGE) {
                    childList.add(new Kid(childData));
                } else if (childData.getAge() <= Constants.MAX_TEEN_AGE) {
                    childList.add(new Teen(childData));
                }
            }
        }
    }
}
