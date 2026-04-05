package linkedlist;

/**
 * A minimal linked-list interface for storing {@link Object} values.
 */
public interface ILinkedList {

    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index the target index.
     * @param element the element to insert.
     */
    void add(int index, Object element);

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element the element to add to the end of the list.
     */
    void add(Object element);

    /**
     * Returns the element at the given index.
     *
     * @param index the position of the element to return.
     * @return the element at the specified position in this list.
     */
    Object get(int index);

    /**
     * Replaces the element at the specified position in this list.
     *
     * @param index the index to update.
     * @param element the new element.
     */
    void set(int index, Object element);

    /**
     * Removes all elements from this list.
     */
    void clear();

    /**
     * Checks whether the list is empty.
     *
     * @return {@code true} if this list contains no elements.
     */
    boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the node to remove.
     */
    void remove(int index);

    /**
     * Returns the size of the list.
     *
     * @return the number of elements in this list.
     */
    int size();

    /**
     * Copies a slice of the list.
     *
     * @param fromIndex low endpoint (inclusive) of the sublist.
     * @param toIndex high endpoint (inclusive) of the sublist.
     * @return a new {@code ILinkedList} with elements between {@code fromIndex}
     *         and {@code toIndex}, inclusively.
     */
    ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * Checks whether an element exists in the list.
     *
     * @param element the object to check.
     * @return {@code true} if this list contains the specified element value.
     */
    boolean contains(Object element);
}
