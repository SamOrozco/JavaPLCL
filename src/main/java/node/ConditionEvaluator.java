package node;

import java.util.ArrayList;
import java.util.List;

public class ConditionEvaluator {
    private List<Condition> conditions;

    public ConditionEvaluator(List<Condition> conditionList) {
        setConditions(conditionList);
    }

    public boolean isTrue() {
        for (Condition nodeCondition : getConditions()) {
            if (!nodeCondition.evaluate()) return false;
        }
        return true;
    }

    public List<Condition> getConditions() {
        if (conditions == null) {
            conditions = new ArrayList<>();
        }
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
