package node;

public interface Node {
    void on();

    void off();

    void toggle();

    boolean conditionIsTrue();

    void onAction();

    void offAction();
}
