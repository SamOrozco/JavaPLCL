package node;

public class ConditionStatement extends StatementEvaluator implements Condition {
    private NodeOperator nodeOperator;
    private Condition[] conditions;
    private boolean desiredResult;


    public ConditionStatement() {

    }


    public ConditionStatement(NodeOperator operator, Condition... conditions) {
        setNodeOperator(operator);
        setConditions(conditions);
        this.setDesiredResult(true);
    }

    public ConditionStatement(NodeOperator operator, boolean desiredResult, Condition... conditions) {
        setNodeOperator(operator);
        setConditions(conditions);
        this.setDesiredResult(desiredResult);
    }

    public NodeOperator getNodeOperator() {
        return nodeOperator;
    }

    public void setNodeOperator(NodeOperator nodeOperator) {
        this.nodeOperator = nodeOperator;
    }

    public Condition[] getConditions() {
        return conditions;
    }

    public void setConditions(Condition[] conditions) {
        this.conditions = conditions;
    }


    @Override
    public boolean evaluate() {
        switch (getNodeOperator()) {
            case OR:
                return OR(getConditions()) == desiredResult;
            case AND:
                return AND(getConditions()) == desiredResult;
            default:
                return false;
        }
    }

    public boolean isDesiredResult() {
        return desiredResult;
    }

    public void setDesiredResult(boolean desiredResult) {
        this.desiredResult = desiredResult;
    }
}
