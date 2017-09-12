import executor.Executor;
import input.UserInput;
import node.ConditionStatement;
import node.NodeCondition;
import node.NodeOperator;
import node.light.LDNode;
import node.light.LightNode;

public class main {


    public static void main(String[] args) throws InterruptedException {
        Executor executor = new Executor(500);
        LightNode lightNodeOne = new LightNode();
        LDNode nodeTwo = new LDNode();

        UserInput userInput = new UserInput();



        executor.getNodes().add(0, lightNodeOne);
        executor.execute();
    }

}
