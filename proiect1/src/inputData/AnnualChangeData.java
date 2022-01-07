package inputData;

import java.util.ArrayList;

public class AnnualChangeData {
    private double newSantaBudget;
    private ArrayList<GiftData> newGifts;
    private ArrayList<ChildData> newChildren;
    private ArrayList<ChildUpdateData> childrenUpdates;

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<GiftData> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(ArrayList<GiftData> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<ChildData> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(ArrayList<ChildData> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdateData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(ArrayList<ChildUpdateData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
