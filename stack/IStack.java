package stack;

/**
 * Defines basic stack operations.
 */
public interface IStack {

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the top stack element.
     */
    Object pop();

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the top stack element.
     */
    Object peek();

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element the element to insert.
     */
    void push(Object element);

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack.
     */
    int size();
}
