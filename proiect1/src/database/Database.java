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
import outputdata.ChildOutput;
import outputdata.OutputData;
import outputdata.RoundOutput;

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

    /**
     * Initializarea bazei de date cu datele de intrare care sunt date de input.
     * Instantele claselor Baby, Kid si teen se creeza si se adauga in lista de copii
     * in functie de varsta lor.
     * @param input datele de intrare
     */
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

    /**
     * mareste numarul de runde pe care se face simularea.
     */
    public static void incrementRoundCounter() {
        roundCounter++;
    }

    /**
     * cauta in lista de copii din baza de date, acel copil cu id ul dat
     * ca parametru.
     * @param id id ul unui copil
     * @return copilul cu id ul specific sau null daca nu exista.
     */
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

        /**
         * Pentru fiecare an pentru care se executa simularea, se adauga datele de iesire
         * pentru fiecare runda dupa care se apeleaza functia care face modificarile pentru
         * fiecare copil din baza de date.
         * @return datele prelucrate
         */
        public static OutputData runSimulation() {
            OutputData outputData = new OutputData(new ArrayList<>());
            for (int i = 0; i <= Database.numberOfYears; i++) {
                outputData.getAnnualChildren().add(simulateRound());
                applyUpdates();
            }
            return outputData;
        }

        /**
         * Pentru a obtine rezultatele unei singure runde aplic Visitor pentru a calcula
         * scorul mediu de cumintenie, si pentru fiecare copil apelez metoda care cumpara
         * un cadou din lista de preferinte ale copilului, daca este posibil. La final
         * se incrementeaza numarul rundei pentru a ajunge la sfarsitul simularii.
         * @return Datele de iesire pentru o singura runda executata
         */
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

        /**
         * se calculeaza suma scorurilor medii de la toti copii din lista de copii, interand
         * prin ea.
         * In functie de numarul rundei se initializeaza si bugetul mosului. Daca este
         * runda 0 bugetul mosului este cel initial, iar pentru celelate runde pentru care
         * se face simularea noul buget al mosului este dat de noile date care se realizeaza
         * in schimbarile anuale.
         * @return budgetUnit
         */
        public static double getBudgetUnit() {
            double scoreSum = 0.0;
            for (Child child : Database.childList) {
                scoreSum += child.getAverageScore();
            }
            double budget = (Database.roundCounter == 0) ? Database.santaBudget
                    : Database.annualChanges.get(Database.roundCounter - 1).getNewSantaBudget();
            return budget / scoreSum;
        }

        /**
         * In functie de categoria de cadou, de lista de preferinte a copiilor si de bugetul
         * alocat fiecarui copil, iterez prin lista de preferinte a copilului si daca gasesc un
         * cadou pe care copilul nu il are, dar se poate achizitona, il adaug in lista de cadouri
         * si scad din bugeul copilului pretul cadoului.
         * @param child copilul caruia i se trimit cadourile
         * @param budgetUnit Unitatea de buget pentru fiecare copil
         * @return On obiect de tipul ChildOutput care reprezinta formatul de output.
         */
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

        /**
         * Pentru a face modificarile de la un an la altul, maresc varsta copiilor si
         * verific daca sunt copii care nu mai pot primi cadouri si astfel ii elimin din
         * baza de date. Apoi, verific si daca sunt copii care trec de la o categorie
         * de varsta la alta, iar cu o lista auxiliara creed noua lista de tipuri de copii
         * si apoi setez in baza de date noua lista.
         */
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
