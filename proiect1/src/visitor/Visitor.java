package visitor;

import child.Baby;
import child.Child;
import child.Kid;
import child.Teen;

public interface Visitor {
    public void visit(Child child);
    public void visit(Baby baby);
    public void visit(Kid kid);
    public void visit(Teen teen);
}
