package node;

public class ConditionStatement extends StatementEvaluator implements Condition {
    private NodeOperator nodeOperator;
    private Condition[] conditions;


    public ConditionStatement() {

    }

    public ConditionStatement(NodeOperator operator, Condition... conditions) {
        setNodeOperator(operator);
        setConditions(conditions);
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
                return OR(getConditions());
            case AND:
                return AND(getConditions());
            default:
                return false;
        }
    }

}
