package executor;

import node.Node;
import utils.Utils;

import java.util.ArrayList;

import static utils.Utils.safe;

public class Executor {
    private ArrayList<Node> nodes;
    private int waitTime;
    private boolean running = true;



    public Executor(int waitTime) {
        this.waitTime = waitTime;
    }

    public void execute() throws InterruptedException {
        Thread executorThread = new Thread(() -> {
            while (running) {
                for (Node currentNode : safe(nodes)) {
                    if (currentNode.conditionIsTrue()) {
                        currentNode.on();
                    } else {
                        currentNode.off();
                    }
                }
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorThread.start();
    }

    public void kill() {
        running = false;
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
