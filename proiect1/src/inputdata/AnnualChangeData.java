package inputdata;

import java.util.ArrayList;

public final class AnnualChangeData {
    private double newSantaBudget;
    private ArrayList<GiftData> newGifts;
    private ArrayList<ChildData> newChildren;
    private ArrayList<ChildUpdateData> childrenUpdates;

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<GiftData> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<GiftData> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<ChildData> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<ChildData> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdateData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<ChildUpdateData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
