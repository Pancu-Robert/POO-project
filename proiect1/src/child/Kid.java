package child;

import visitor.Visitor;
import inputdata.ChildData;

public final class Kid extends Child {
    public Kid(final ChildData childData) {
        super(childData);
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

    public Kid(final Child child) {
        this.setId(child.getId());
        this.setLastName(child.getLastName());
        this.setFirstName(child.getFirstName());
        this.setAge(child.getAge());
        this.setCity(child.getCity());
        this.setCategories(child.getCategories());
        this.setAverageScore(0.0);
        this.setNiceScoreHistory(child.getNiceScoreHistory());
    }
}
