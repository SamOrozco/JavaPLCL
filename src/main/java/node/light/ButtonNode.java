package node.light;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import node.NodeConditionBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

public class ButtonNode extends NodeConditionBuilder {
    Button button;

    public ButtonNode() {

    }

    public ButtonNode(Button button) {
        this.button = button;
    }

    @Override
    public boolean conditionIsTrue() {
        return evaluate();
    }

    @Override
    public void onAction() {
        button.setStyle("-fx-background-color: #00ff00");
    }

    @Override
    public void offAction() {
        button.setStyle("-fx-background-color: #ff0000");
    }
}
