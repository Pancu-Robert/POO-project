package outputData;

import java.util.ArrayList;

public class RoundOutput {
    private ArrayList<ChildOutput> children;

    public RoundOutput() {
    }

    public RoundOutput(ArrayList<ChildOutput> children) {
        this.children = children;
    }

    public ArrayList<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildOutput> children) {
        this.children = children;
    }
}
