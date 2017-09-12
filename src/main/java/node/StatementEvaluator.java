package node;

public class StatementEvaluator {


    protected boolean AND(Condition[] conditions) {
        for (Condition condition : conditions) {
            if (!condition.evaluate()) return false;
        }
        return true;
    }

    protected boolean OR(Condition[] conditions) {
        for (Condition condition : conditions) {
            if (condition.evaluate()) return true;
        }
        return false;
    }
}
