import executor.Executor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import node.nodes.BounceNode;
import node.nodes.ButtonNode;
import node.nodes.ConveyorNode;
import node.nodes.LightNode;

public class UITest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Executor executor = new Executor(1);
        primaryStage.setTitle("Test PLCL");


        Button masterButton = new Button("Master");
        ButtonNode masterNode = new ButtonNode(masterButton);
        masterNode.on(); // default on
        masterButton.setOnAction(e -> {
            masterNode.toggle();
        });

        Button button0 = new Button();
        ButtonNode buttonNode0 = new ButtonNode(button0);
        button0.setText("0");
        button0.setOnAction(e -> {
            buttonNode0.toggle();
        });
        buttonNode0.builder()
                .ifTrue(masterNode::conditionIsTrue)
                .ifTrue(buttonNode0::isClicked)
                .build();

        Button button1 = new Button();
        ButtonNode buttonNode1 = new ButtonNode(button1);
        button1.setText("1");
        button1.setOnAction(e -> {
            buttonNode1.toggle();
        });
        buttonNode1.builder()
                .ifTrue(masterNode::conditionIsTrue)
                .ifTrue(buttonNode1::isClicked)
                .build();


        //conveyor one
        Button conveyorButton0 = new Button();
        ConveyorNode conveyorNode0 = new ConveyorNode(conveyorButton0, 2);
        conveyorNode0.setBounds(800, 0);
        conveyorNode0.builder()
                .ifTrue(buttonNode0::conditionIsTrue)
                .build();


        //conveyor two
        Button conveyorButton1 = new Button();
        ConveyorNode conveyorNode1 = new ConveyorNode(conveyorButton1, 3);
        conveyorNode1.setBounds(800, 0);
        conveyorNode1.builder()
                .ifTrue(buttonNode1::conditionIsTrue)
                .build();

        Button bounceButton = new Button();
        BounceNode bounceNode = new BounceNode(bounceButton, 6);
        bounceNode.setBounds(800, 0);
        bounceNode.builder()
                .ifTrue(buttonNode1::conditionIsTrue)
                .build();


        Button lightButton = new Button();
        LightNode lightNode = new LightNode(lightButton);
        lightButton.setText("Light");
        lightNode.builder()
                .ifTrue(buttonNode0::conditionIsTrue)
                .build();


        //executor
        executor.getNodes().add(buttonNode0);
        executor.getNodes().add(buttonNode1);
        executor.getNodes().add(lightNode);
        executor.getNodes().add(conveyorNode0);
        executor.getNodes().add(conveyorNode1);
        executor.getNodes().add(bounceNode);
        executor.getNodes().add(masterNode);
        executor.execute();

        //ui
        Pane pane = new Pane();

        button0.setPrefHeight(40);
        button0.setPrefWidth(40);
        button0.setLayoutX(0.0);
        button0.setLayoutY(0.0);

        button1.setPrefHeight(40);
        button1.setPrefWidth(40);
        button1.setLayoutX(45.0);
        button1.setLayoutY(0.0);

        conveyorButton0.setPrefHeight(40);
        conveyorButton0.setPrefWidth(400);
        conveyorButton0.setLayoutY(45.0);
        conveyorButton0.setLayoutX(0.0);

        conveyorButton1.setPrefHeight(40);
        conveyorButton1.setPrefWidth(400);
        conveyorButton1.setLayoutY(90.0);
        conveyorButton1.setLayoutX(0.0);

        bounceButton.setPrefHeight(40);
        bounceButton.setPrefWidth(40);
        bounceButton.setLayoutY(200.0);
        bounceButton.setLayoutX(0.0);

        lightButton.setPrefHeight(40);
        lightButton.setPrefWidth(100);
        lightButton.setLayoutY(0.0);
        lightButton.setLayoutX(125.0);


        masterButton.setPrefHeight(40);
        masterButton.setPrefWidth(100);
        masterButton.setLayoutY(0.0);
        masterButton.setLayoutX(250.0);


        pane.getChildren().add(button0);
        pane.getChildren().add(conveyorButton0);
        pane.getChildren().add(conveyorButton1);
        pane.getChildren().add(bounceButton);
        pane.getChildren().add(lightButton);
        pane.getChildren().add(button1);
        pane.getChildren().add(masterButton);

        primaryStage.setScene(new Scene(pane, 800, 800));
        primaryStage.setOnCloseRequest(event -> {
            executor.kill();
        });
        primaryStage.show();

    }
}
