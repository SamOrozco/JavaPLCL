package node.nodes;

import javafx.scene.control.Button;
import node.NodeConditionBuilder;

public class ConveyorNode extends NodeConditionBuilder {
    Button button = new Button();
    double maxX;
    double minX;
    protected int operator;

    public ConveyorNode(Button button, int operator) {
        button.setText("    ");
        button.setStyle("-fx-background-color: #000000");
        this.button = button;
        this.operator = operator;
    }

    public ConveyorNode() {

    }

    public void setBounds(double xMax, double xMin) {
        maxX = xMax;
        minX = xMin;
    }

    @Override
    public boolean conditionIsTrue() {
        return evaluate();
    }

    @Override
    public void onAction() {
        double xCord = this.button.getLayoutX();
        if (xCord >= maxX) {
            this.button.setLayoutX(minX);
            return;
        }
        this.button.setLayoutX(xCord + (.5 * operator));
    }

    @Override
    public void offAction() {
        double xCord = this.button.getLayoutX();
        if (xCord >= 0) {
            this.button.setLayoutX(xCord - (.5));
        }
    }
}
