package homework03;

public class Node {
    private int value;
    private Node nextNode;
    private Node previousNode;

    Node() {
        this.nextNode = null;
        this.previousNode = null;
    }

    Node(int value) {
        this.value = value;
    }

    public void reverse() {
        Node temp = this.nextNode;
        this.nextNode = this.previousNode;
        this.previousNode = temp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    String getprevstr() {
        String str = "";
        if (this.previousNode == null)
            str = "null";
        else
            str = this.previousNode.value + "";
        return str;
    }

    String getnextstr() {
        String str = "";
        if (this.nextNode == null)
            str = "null";
        else
            str = this.nextNode.value + "";
        return str;
    }

    String getAllstr() {
        return " (" + getprevstr() + " [" + value + "] " + getnextstr() + ") ";
    }

}
