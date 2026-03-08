
public interface ILinkedList {

    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index the index you want the new element to be at
     * @param element the element you want to insert
     */
    public void add(int index, Object element);

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element the element to add to the end of the list
     */
    public void add(Object element);

    /**
     * @param index the position of the element to return
     * @return the element at the specified position in this list.
     */
    public Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index the index you want to change the element at
     * @param element the new element
     */
    public void set(int index, Object element);

    /**
     * Removes all of the elements from this list.
     */
    public void clear();

    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the Node you want to remove.
     */
    public void remove(int index);

    /**
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (inclusive) of the subList
     * @return a view of the portion of this list between the specified
     * fromIndex and toIndex, inclusively.
     */
    public ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * @param element the object you want to check if it's in the list.
     * @return true if this list contains an element with the same value as the
     * specified element.
     */
    public boolean contains(Object element);
}
