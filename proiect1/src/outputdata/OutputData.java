package outputdata;

import java.util.ArrayList;

public final class OutputData {
    private ArrayList<RoundOutput> annualChildren;

    public OutputData() {
    }

    public OutputData(final ArrayList<RoundOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public ArrayList<RoundOutput> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final ArrayList<RoundOutput> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
