package node.light;

import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import node.NodeConditionBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConveyorNode extends NodeConditionBuilder {
    Button button = new Button();
    double maxX;
    double minX;

    public ConveyorNode(Button button) {
        button.setText("    ");
        button.setStyle("-fx-background-color: #000000");
        this.button = button;
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
        if (xCord >= 500) {
            this.button.setLayoutX(minX);
            return;
        }
        this.button.setLayoutX(xCord + .5);
    }

    @Override
    public void offAction() {
    }
}
