package visitor;

import child.Baby;
import child.Child;
import child.Kid;
import child.Teen;
import common.Constants;

public final class ScoreCalculator implements Visitor {
    @Override
    public void visit(Child child) {
    }

    @Override
    public void visit(Baby baby) {
        baby.setAverageScore(Constants.MAX_SCORE);
    }

    @Override
    public void visit(Kid kid) {
        double sum = 0.0;
        for (Double score: kid.getNiceScoreHistory()) {
            sum += score;
        }
        kid.setAverageScore(sum / kid.getNiceScoreHistory().size());
    }

    @Override
    public void visit(Teen teen) {
        double sum = 0.0;
        int weight = 0;
        for (int i = 1; i <= teen.getNiceScoreHistory().size(); i++) {
            sum += i * teen.getNiceScoreHistory().get(i - 1);
            weight += i;
        }
        teen.setAverageScore(sum / weight);
    }
}
