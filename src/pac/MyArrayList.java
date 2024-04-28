package pac;

/**
 * Implementation of the MyList interface using an array.
 *
 * @param <T> the type of elements in the list
 */
public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    /**
     * Default constructor. Initializes the array with a capacity of 5 elements.
     */
    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to be added
     */
    @Override
    public void addElement(T data) {
        add(data);
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    /**
     * Sets the value of the element at the specified index.
     *
     * @param index the index of the element to be set
     * @param item  the new value of the element
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * Inserts an element at the specified index.
     *
     * @param index the index at which the element is to be inserted
     * @param item  the element to be inserted
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size >= arr.length) {
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param item the element to be added
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param item the element to be added
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    @Override
    public T getElement(int index) {
        checkIndex(index);
        return arr[index];
    }
// Continued from previous code...

    /**
     * Retrieves the first element in the list.
     *
     * @return the first element in the list
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public T getFirst() {
        checkIndex(0);
        return arr[0];
    }

    /**
     * Retrieves the last element in the list.
     *
     * @return the last element in the list
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public T getLast() {
        checkIndex(size - 1);
        return arr[size - 1];
    }

    /**
     * Removes the first element from the list.
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last element from the list.
     */
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Sorts the elements in the list in non-decreasing order.
     * Uses bubble sort algorithm.
     */
    @Override
    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (((Comparable<T>) arr[i]).compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
// Continued from previous code...

    /**
     * Searches for the first occurrence of the specified object in the list.
     *
     * @param object the object to be searched for in the list
     * @return the index of the first occurrence of the specified object, or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for the last occurrence of the specified object in the list.
     *
     * @param object the object to be searched for in the list
     * @return the index of the last occurrence of the specified object, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the specified object exists in the list.
     *
     * @param object the object to check for existence in the list
     * @return true if the object exists in the list, false otherwise
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     *
     * @return an array containing all elements in the list
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(arr, 0, newArray, 0, size);
        return newArray;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the list, removing all elements.
     */
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Removes the element at the specified index from the list.
     *
     * @param index the index of the element to be removed
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    /**
     * Increases the buffer size of the array when needed.
     */
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    /**
     * Checks if the specified index is valid.
     *
     * @param index the index to be checked
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
