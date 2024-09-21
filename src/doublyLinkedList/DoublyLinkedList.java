package doublyLinkedList;

import simplyLinkedList.Node;

public class DoublyLinkedList<T> {
    Node head;
    Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int getSize(){
        return this.size;
    }

    public void add(T data) {
        Node node = new Node<T>(data);


        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
        this.size++;
    }

    public void print() {
        Node temp = this.head;
        for (int i = 0; i != this.size; i++) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

    }

    public void removeByIndex(int index) {
        Node temp = this.head;

        if (index > this.size - 1 || index < 0) {
            throw new IllegalArgumentException("index does not exist");
        }

        if (this.head == this.tail) {
            //remove quando tem apenas um item
            this.head = null;
            this.tail = null;
        } else if (index == 0) {
            // remove do início
            this.head = this.head.getNext();
            this.head.setPrev(null);
        } else if (index == this.size - 1) {
            //remove no fim
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        } else {
            // remove no meio
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            temp.setNext(nextNode.getNext());
            nextNode.getNext().setPrev(temp);
        }
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
