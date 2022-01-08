package fileio;

import inputdata.AnnualChangeData;
import inputdata.InitialData;

import java.util.ArrayList;

public final class Input {
    private final int numberOfYears;
    private final double santaBudget;
    private final InitialData initialData;
    private final ArrayList<AnnualChangeData> annualChanges;

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0;
        this.initialData = null;
        this.annualChanges = null;
    }

    public Input(final int numberOfYears, final double santaBudget,
                 final InitialData initialData,
                 final ArrayList<AnnualChangeData> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public ArrayList<AnnualChangeData> getAnnualChanges() {
        return annualChanges;
    }

}
