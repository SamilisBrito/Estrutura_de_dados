package simplyLinkedList;

public class Node<T> {
    private T data;
    Node prev;
    Node next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
