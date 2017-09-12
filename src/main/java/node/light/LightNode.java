package node.light;

import node.*;

public class LightNode extends NodeConditionBuilder {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = this.name;
    }

    public boolean conditionIsTrue() {
        return evaluate();
    }

    @Override
    public void onAction() {
        System.out.println("On");
    }

    @Override
    public void offAction() {
        System.out.println("off");
    }
}
