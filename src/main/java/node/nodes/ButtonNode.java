package node.nodes;

import javafx.scene.control.Button;
import node.NodeConditionBuilder;

public class ButtonNode extends NodeConditionBuilder {
    Button button;
    boolean clicked;

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
        clicked = true;
        button.setStyle("-fx-background-color: #00ff00");
    }

    @Override
    public void offAction() {
        clicked = false;
        button.setStyle("-fx-background-color: #ff0000");
    }

    public boolean isClicked() {
        return clicked;
    }
}
