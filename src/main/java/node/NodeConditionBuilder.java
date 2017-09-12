package node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class NodeConditionBuilder implements Node {
    protected boolean state;
    private ConditionEvaluator conditionEvaluator;
    private Consumer<Void> onAction;
    private Supplier<Void> offAction;

    abstract public String getName();

    abstract public void setName(String name);

    abstract public boolean conditionIsTrue();


    public boolean getState() {
        return state;
    }

    public void on() {
        onAction();
        state = true;
    }

    public void off() {
        offAction();
        state = false;
    }

    public boolean evaluate() {
        if (conditionEvaluator == null) return state;
        return conditionEvaluator.isTrue();
    }

    public Builder builder() {
        return new Builder();
    }

    public class Builder {

        private List<Condition> conditionList;

        public Builder ifTrue(Supplier<Boolean> condition) {
            NodeCondition nodeCondition = new NodeCondition();
            nodeCondition.setMethodReference(condition);
            nodeCondition.setDesireResult(true);
            getConditionList().add(nodeCondition);
            return this;
        }

        public Builder ifFalse(Supplier<Boolean> condition) {
            NodeCondition nodeCondition = new NodeCondition();
            nodeCondition.setMethodReference(condition);
            nodeCondition.setDesireResult(false);
            getConditionList().add(nodeCondition);
            return this;
        }

        public Builder withCondition(Condition condition) {
            getConditionList().add(condition);
            return this;
        }

        public void build() {
            conditionEvaluator = new ConditionEvaluator(getConditionList());
        }

        public List<Condition> getConditionList() {
            if (conditionList == null) {
                conditionList = new ArrayList<>();
            }
            return conditionList;
        }

        public void setConditionList(List<Condition> conditionList) {
            this.conditionList = conditionList;
        }
    }


    public void setOnAction(Consumer<Void> action) {
        this.onAction = action;
    }

    public void setOffAction(Supplier<Void> action) {
        this.offAction = action;
    }

    public void onAction() {
        if (onAction == null) {
            throw new RuntimeException("Trying to execute a null action");
        }
        this.onAction.accept(null);
    }

    public void offAction() {
        if (offAction == null) {
            throw new RuntimeException("Trying to execute a null action");
        }
        this.offAction.get();
    }

}
