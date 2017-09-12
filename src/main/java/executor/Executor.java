package executor;

import node.Node;
import utils.Utils;

import java.util.ArrayList;

import static utils.Utils.safe;

public class Executor {
    private ArrayList<Node> nodes;
    private final int waitTime = 1000;

    public void execute() throws InterruptedException {
        while (true) {
            for (Node currentNode : safe(nodes)) {
                if (currentNode.conditionIsTrue()) {
                    currentNode.on();
                } else {
                    currentNode.off();
                }
            }

            Thread.sleep(waitTime);
        }
    }

    public ArrayList<Node> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<Node>();
        }
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}
