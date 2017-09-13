import executor.Executor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import node.light.ButtonNode;
import node.light.ConveyorNode;
import node.light.LightNode;

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


        //conveyor one
        Button conveyorButton0 = new Button();
        ConveyorNode conveyorNode0 = new ConveyorNode(conveyorButton0, 1);
        conveyorNode0.setBounds(800, 0);
        conveyorNode0.builder()
                .ifTrue(buttonNode0::conditionIsTrue)
                .build();


        //conveyor two
        Button conveyorButton1 = new Button();
        ConveyorNode conveyorNode1 = new ConveyorNode(conveyorButton1, 2);
        conveyorNode1.setBounds(800, 0);
        conveyorNode1.builder()
                .ifTrue(buttonNode0::conditionIsTrue)
                .build();


        Button lightButton = new Button();
        LightNode lightNode = new LightNode(lightButton);
        lightButton.setText("Light");


        //conditions
        lightNode.builder()
                .ifTrue(buttonNode0::conditionIsTrue)
                .build();


        //executor
        executor.getNodes().add(buttonNode0);
        executor.getNodes().add(lightNode);
        executor.getNodes().add(conveyorNode0);
        executor.getNodes().add(conveyorNode1);
        executor.execute();

        //ui
        Pane pane = new Pane();

        button0.setPrefHeight(40);
        button0.setPrefWidth(40);
        button0.setLayoutX(0.0);
        button0.setLayoutY(0.0);

        conveyorButton0.setPrefHeight(40);
        conveyorButton0.setPrefWidth(400);
        conveyorButton0.setLayoutY(45.0);
        conveyorButton0.setLayoutX(0.0);

        conveyorButton1.setPrefHeight(40);
        conveyorButton1.setPrefWidth(400);
        conveyorButton1.setLayoutY(90.0);
        conveyorButton1.setLayoutX(0.0);

        lightButton.setPrefHeight(40);
        lightButton.setPrefWidth(100);
        lightButton.setLayoutY(200.0);
        lightButton.setLayoutX(125.0);


        pane.getChildren().add(button0);
        pane.getChildren().add(conveyorButton0);
        pane.getChildren().add(conveyorButton1);
        pane.getChildren().add(lightButton);

        primaryStage.setScene(new Scene(pane, 800, 800));
        primaryStage.setOnCloseRequest(event -> {
            executor.kill();
        });
        primaryStage.show();

    }
}
