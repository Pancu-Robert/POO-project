package inputData;

import java.util.ArrayList;

public class InitialData {
    private ArrayList<ChildData> children;
    private ArrayList<GiftData> santaGiftsList;

    public ArrayList<ChildData> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildData> children) {
        this.children = children;
    }

    public ArrayList<GiftData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(ArrayList<GiftData> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
