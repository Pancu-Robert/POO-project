package inputdata;

import java.util.ArrayList;

public final class InitialData {
    private ArrayList<ChildData> children;
    private ArrayList<GiftData> santaGiftsList;

    public ArrayList<ChildData> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildData> children) {
        this.children = children;
    }

    public ArrayList<GiftData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<GiftData> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
