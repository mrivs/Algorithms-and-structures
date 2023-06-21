package homework03;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node findNodebyValue(int value) {
        Node node = head;
        while (node.getNextNode() != null) {
            node = node.getNextNode();
            if (node.getValue() == value)
                return node;
        }
        return null;
    }

    public Node findNodebyIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
            if (node == null)
                return null;
        }
        return node;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            size = 1;
        } else {
            tail.setNextNode(node);
            node.setPreviousNode(tail);
            tail = node;
            size++;
        }
    }

    public void print() {
        Node node = this.head;
        System.out.print("[");
        while (node != null) {
            System.out.print(node.getAllstr());
            node = node.getNextNode();
        }
        System.out.println("]");
    }

    public void revert() {
        Node node = head;
        head = tail;
        tail = node;
        head.reverse();
        node = head;

        while (node.getNextNode() != null) {

            node = node.getNextNode();
            node.reverse();
        }
    }
}
