package node.light;

import node.NodeConditionBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

public class ButtonNode extends NodeConditionBuilder {
    JButton button;


    public ButtonNode(JButton button) {
        this.button = button;
    }


    @Override
    public String getName() {
        return "button";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean conditionIsTrue() {
        return false;
    }

//    @Override
//    public void onAction() {
//        System.out.println("Button On");
//    }
//
//    @Override
//    public void offAction() {
//        System.out.println("Button On");
//    }

    public void updateColor() {
        button.setBackground(new Color(233,233,233));
    }
}
