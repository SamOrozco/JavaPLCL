package node.nodes;

import node.NodeConditionBuilder;

public class LDNode extends NodeConditionBuilder {

    @Override
    public boolean conditionIsTrue() {
        return true;
    }

    @Override
    public void onAction() {
        System.out.println("on Two");
    }

    @Override
    public void offAction() {
        System.out.println("off Two");
    }
}
