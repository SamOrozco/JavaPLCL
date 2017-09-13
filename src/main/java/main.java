import executor.Executor;
import input.UserInput;
import node.nodes.LDNode;
import node.nodes.LightNode;

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
