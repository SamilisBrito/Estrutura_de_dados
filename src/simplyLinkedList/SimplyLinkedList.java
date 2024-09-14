package simplyLinkedList;

public class SimplyLinkedList<T> {
    Node head;
    private int size = 0;

    public SimplyLinkedList() {
        this.head = null;
    }

    public T add(T data) {
        Node node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
        } else if (this.head.getNext() == null) {
            this.head.setNext(node);
        } else {
            Node last = getLast();
            last.setNext(node);
        }
        this.size++;
        return data;
    }

    public Node<T> getLast() {
        Node temp = this.head;
        if (temp.getNext() == null) return temp;
        while (temp.next != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    public void print() {
        Node temp = this.head;
        for (int i = 0; i != this.size; i++) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

    }

    public int getSize() {
        return size;
    }

    public void remove(int index) {

        if (index > this.size - 1 || index < 0) {
            throw new IllegalArgumentException("index does not exist");
        }

        if (index == 0) {
            this.head = head.getNext();
            this.size -= 1;
            return;
        }

        Node temp = this.head;
        if (index == getSize() - 1) {
            for (int i = 0; i != getSize() - 2; i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            this.size -= 1;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }

        Node nextNode = temp.getNext();
        temp.setNext(nextNode.getNext());
        this.size -= 1;

    }

    public T getByIndex(int index) {
        Node data = (Node) search(index);
        return (T) data.getData();
    }

    private T search(int index) {
        if (index > this.size - 1 || index < 0) {
            throw new IllegalArgumentException("index does not exist");
        }

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (T) temp;
    }

    public void changeElementByIndex(T value, int index) {
        Node data = (Node) search(index);
        data.setData(value);
    }
}
