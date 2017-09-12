import executor.Executor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
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


        Button conveyorButton = new Button();
        ConveyorNode conveyorNode = new ConveyorNode(conveyorButton);
        conveyorNode.setBounds(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getMinX());
        conveyorNode.builder()
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
        executor.getNodes().add(conveyorNode);
        executor.execute();

        //ui
        Pane pane = new Pane();

        button0.setPrefHeight(40);
        button0.setPrefWidth(40);
        button0.setLayoutX(0.0);
        button0.setLayoutY(0.0);

        conveyorButton.setPrefHeight(40);
        conveyorButton.setPrefWidth(40);
        conveyorButton.setLayoutY(45.0);
        conveyorButton.setLayoutX(0.0);

        lightButton.setPrefHeight(40);
        lightButton.setPrefWidth(100);
        lightButton.setLayoutY(129.0);
        lightButton.setLayoutX(125.0);


        pane.getChildren().add(button0);
        pane.getChildren().add(conveyorButton);
        pane.getChildren().add(lightButton);

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.setOnCloseRequest(event -> {
            executor.kill();
        });
        primaryStage.show();

    }
}
