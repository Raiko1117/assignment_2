import org.w3c.dom.Node;

public abstract class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.data == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    @Override
    public void add(T item, int index) {
        if (index > size) {
            return;
        }
        Node<T> node = new Node<>(item);
        if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            Node<T> current = head;
        }
    }

}
