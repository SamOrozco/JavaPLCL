package node;

import java.util.ArrayList;
import java.util.List;

public class ConditionEvaluator {
    private List<Condition> conditions;
    private boolean desiredResult;

    public ConditionEvaluator(List<Condition> conditionList, boolean desiredResult) {
        setConditions(conditionList);
        setDesiredResult(desiredResult);
    }

    public ConditionEvaluator(List<Condition> conditionList) {
        setConditions(conditionList);
    }

    public boolean evaluateTrue() {
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

    public boolean isDesiredResult() {
        return desiredResult;
    }

    public void setDesiredResult(boolean desiredResult) {
        this.desiredResult = desiredResult;
    }
}
