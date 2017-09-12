package node;

public interface Node {
    void on();

    void off();

    String getName();

    void setName(String name);

    boolean conditionIsTrue();

    void onAction();

    void offAction();
}
