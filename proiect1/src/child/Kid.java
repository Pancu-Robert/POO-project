package child;

import Visitor.Visitor;
import inputData.ChildData;

public final class Kid extends Child {
    public Kid(ChildData childData) {
        super(childData);
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

    public Kid(Child child) {
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
