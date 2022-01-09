package outputdata;

import java.util.ArrayList;

public final class RoundOutput {
    private ArrayList<ChildOutput> children;

    public RoundOutput() {
    }

    public RoundOutput(final ArrayList<ChildOutput> children) {
        this.children = children;
    }

    public ArrayList<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildOutput> children) {
        this.children = children;
    }
}