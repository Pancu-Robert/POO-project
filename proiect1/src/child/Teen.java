package child;

import Visitor.Visitor;
import inputData.ChildData;

public final class Teen extends Child {
    public Teen(ChildData childData) {
        super(childData);
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

    public Teen(Child child) {
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
