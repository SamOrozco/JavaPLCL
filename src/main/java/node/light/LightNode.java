package node.light;

import javafx.scene.control.Button;
import node.*;

public class LightNode extends NodeConditionBuilder {
    Button button;

    public LightNode(){

    }

    public LightNode(Button button) {
        this.button = button;
    }

    public boolean conditionIsTrue() {
        return evaluate();
    }

    @Override
    public void onAction() {
        button.setStyle("-fx-background-color: #f4e842");
    }

    @Override
    public void offAction() {
        button.setStyle("-fx-background-color: #72726b");
    }
}
