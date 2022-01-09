package visitor;

public interface Visitable {
    /**
     * Metoda de accept specifica Visitor pattern.
     * @param v
     */
    void accept(Visitor v);
}
