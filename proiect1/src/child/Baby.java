package child;

import visitor.Visitor;
import inputdata.ChildData;

public final class Baby extends Child {
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

    public Baby(final ChildData childData) {
        super(childData);
    }

    public Baby(final Child child) {
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
