package node.nodes;

import javafx.scene.control.Button;
import node.NodeConditionBuilder;

public class BounceNode extends ConveyorNode {


    public BounceNode(Button button, int operator) {
        super(button, operator);
    }

    @Override
    public void onAction() {
        double xCord = this.button.getLayoutX();
        if (xCord == maxX) {
            state = false;
            return;
        }
        this.button.setLayoutX(xCord + (.5 * operator));

    }

    @Override
    public void offAction() {
        double xCord = this.button.getLayoutX();
        if (xCord == minX) {
            state = true;
            return;
        }
        this.button.setLayoutX(xCord - (.5 * operator));
    }
}
