
/**
 * IStack is a simple interface defining stack operations.
 */
public interface IStack {

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object pop();

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object peek();

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element the element to insert
     */
    public void push(Object element);

    /**
     * Tests if this stack is empty
     *
     * @return true if stack empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack i.e. the number of elements in it
     */
    public int size();
}
