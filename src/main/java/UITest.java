import node.light.ButtonNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITest {

    public static void main(String[] args) {


        JFrame jFrame = new JFrame();
        jFrame.setBounds(new Rectangle(300, 300));

        JButton button = new JButton();
        ButtonNode buttonNode = new ButtonNode(button);
        buttonNode.setOnAction(buttonNode::updateColor);
        JLabel label = new JLabel("Tests");
        button.addActionListener(e -> buttonNode.on());

        jFrame.add(button);
        jFrame.setVisible(true);

    }
}
