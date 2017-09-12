import executor.Executor;
import input.UserInput;
import node.ConditionStatement;
import node.NodeCondition;
import node.NodeOperator;
import node.light.LDNode;
import node.light.LightNode;

public class main {


    public static void main(String[] args) throws InterruptedException {
        Executor executor = new Executor();
        LightNode lightNodeOne = new LightNode();
        LDNode nodeTwo = new LDNode();

        UserInput userInput = new UserInput();


        ConditionStatement statement = new ConditionStatement();

        lightNodeOne
                .builder()
                .withCondition(
                        new ConditionStatement(NodeOperator.AND,
                                new NodeCondition(userInput::userInputEqualsHome, true),
                                new NodeCondition(userInput::valueTrue, true),
                                new ConditionStatement(NodeOperator.OR,
                                        new NodeCondition(userInput::userInputEqualsHome, false),
                                        new NodeCondition(userInput::valueTrue, true)
                                )))
                .build();


        executor.getNodes().add(0, lightNodeOne);
        executor.execute();
    }

}
