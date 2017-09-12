import executor.Executor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import node.ConditionStatement;
import node.NodeCondition;
import node.NodeOperator;
import node.light.ButtonNode;
import node.light.LightNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Executor executor = new Executor(5);
        primaryStage.setTitle("Test PLCL");

        Button button0 = new Button();
        ButtonNode buttonNode0 = new ButtonNode(button0);
        button0.setText("    ");
        button0.setOnAction(e -> {
            buttonNode0.toggle();
        });

        Button button1 = new Button();
        ButtonNode buttonNode1 = new ButtonNode(button1);
        button1.setText("    ");
        button1.setOnAction(e -> {
            buttonNode1.toggle();
        });

        Button button2 = new Button();
        ButtonNode buttonNode2 = new ButtonNode(button2);
        button2.setText("     ");
        button2.setOnAction(e -> {
            buttonNode2.toggle();
        });


        Button button3 = new Button();
        LightNode lightNode = new LightNode(button3);
        button3.setText("Light");


        //conditions
        buttonNode0
                .builder()
                .ifTrue(buttonNode1::conditionIsTrue)
                .ifTrue(buttonNode2::conditionIsTrue)
                .build();

        //light condition
        lightNode.builder()
                .withCondition(new ConditionStatement(
                        NodeOperator.OR,
                        new NodeCondition(buttonNode0::conditionIsTrue, true),
                        new NodeCondition(buttonNode0::conditionIsTrue, true),
                        new NodeCondition(buttonNode0::conditionIsTrue, true)))
//                .withCondition(new ConditionStatement(
//                        NodeOperator.OR,
//                        new NodeCondition(buttonNode0::conditionIsTrue, false),
//                        new NodeCondition(buttonNode0::conditionIsTrue, false),
//                        new NodeCondition(buttonNode0::conditionIsTrue, true)))
                .build();

        //executor
        executor.getNodes().add(buttonNode0);
        executor.getNodes().add(buttonNode1);
        executor.getNodes().add(buttonNode2);
        executor.getNodes().add(lightNode);
        executor.execute();

        //ui
        StackPane stackPane = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.add(button0, 1, 0);
        gridPane.add(button1, 2, 1);
        gridPane.add(button2, 3, 2);
        gridPane.add(button3, 4, 3);
        stackPane.getChildren().add(gridPane);

        primaryStage.setScene(new Scene(stackPane, 400, 400));
        primaryStage.setOnCloseRequest(event -> {
            executor.kill();
        });
        primaryStage.show();

    }
}
