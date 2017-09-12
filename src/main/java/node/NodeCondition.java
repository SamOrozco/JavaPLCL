package node;

import java.util.function.Supplier;

public class NodeCondition implements Condition {
    private Supplier<Boolean> methodReference;
    private boolean desireResult;

    public NodeCondition() {

    }

    public NodeCondition(Supplier<Boolean> methodReference, boolean desireResult) {
        this.methodReference = methodReference;
        this.desireResult = desireResult;
    }

    public Supplier<Boolean> getMethodReference() {
        if (methodReference == null) {
            throw new RuntimeException("Trying to execute a null method reference.");
        }
        return methodReference;
    }

    public void setMethodReference(Supplier<Boolean> methodReferenec) {
        this.methodReference = methodReferenec;
    }

    public boolean evaluate() {
        boolean result = getMethodReference().get();
        return result == isDesireResult();
    }

    public boolean isDesireResult() {
        return desireResult;
    }

    public void setDesireResult(boolean desireResult) {
        this.desireResult = desireResult;
    }
}
