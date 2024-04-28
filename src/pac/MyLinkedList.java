package pac;
/**
 * Represents a singly linked list implementation of the MyList interface.
 *
 * @param <T> the type of elements stored in the linked list
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param data the data to be added to the linked list
     */
    @Override
    public void addElement(T data) {

        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }

        size++;
    }

    public T getElement(int index) {
        checkIndex(index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(item);
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            checkIndex(index);
            Node<T> newNode = new Node<>(item);
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.getData();
    }

    @Override
    public T getLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        size--;
    }

    @Override
    public void removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < size - 2; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            Node<T> next = head.getNext();
            while (next != null) {
                if (((Comparable<T>) current.getData()).compareTo(next.getData()) > 0) {
                    T temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                    swapped = true;
                }
                current = next;
                next = next.getNext();
            }
        }
        while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(object)) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node<T> currentNode = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(object)) {
                lastIndex = i;
            }
            currentNode = currentNode.getNext();
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            array[i] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index not correct");
        }
    }
}