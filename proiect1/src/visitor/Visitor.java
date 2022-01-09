package visitor;

import child.Baby;
import child.Child;
import child.Kid;
import child.Teen;

public interface Visitor {
    /**
     * Metoda de vizitare a unui copil, specifica Visitor pattern.
     * @param child
     */
    void visit(Child child);
    /**
     * Metoda de vizitare a unui bebelus, specifica Visitor pattern.
     * @param baby
     */
    void visit(Baby baby);
    /**
     * Metoda de vizitare a unui pusti, specifica Visitor pattern.
     * @param kid
     */
    void visit(Kid kid);
    /**
     * Metoda de vizitare a unui adolescent, specifica Visitor pattern.
     * @param teen
     */
    void visit(Teen teen);
}
