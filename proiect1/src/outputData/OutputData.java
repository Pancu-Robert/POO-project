package outputData;

import java.util.ArrayList;

public class OutputData {
    private ArrayList<RoundOutput> annualChildren;

    public OutputData() {
    }

    public OutputData(ArrayList<RoundOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public ArrayList<RoundOutput> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(ArrayList<RoundOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
