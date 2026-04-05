package stack;

import linkedlist.SingleLinkedList;


/**
 * A simple LIFO stack backed by a singly linked list.
 *
 * <p>
 * This implementation delegates storage to {@link SingleLinkedList} and
 * performs push/pop/peek operations at the head of that list, giving O(1)
 * performance for push and pop. Null elements are allowed (behavior follows
 * {@code SingleLinkedList}). Exceptions thrown for empty stack operations are
 * those thrown by {@code SingleLinkedList.getHead()}, i.e. {@link
 * java.util.EmptyStackException}.</p>
 *
 * @author Omar Mohamed
 * @version 1.0
 */
public class Stack implements IStack {

    private SingleLinkedList list;

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        list = new SingleLinkedList();
    }

    /**
     * Pushes an element onto the top of this stack.
     *
     * @param element the element to push onto the stack (may be {@code null})
     */
    @Override
    public void push(Object element) {
        list.addHead(element);
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the size of the stack (non-negative int)
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Tests whether this stack contains no elements.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Removes and returns the element at the top of this stack.
     *
     * <p>
     * This is a LIFO pop: the most recently pushed element is removed and
     * returned.</p>
     *
     * @return the top element of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    @Override
    public Object pop() {
        Object object = list.getHead();
        list.remove(0);
        return object;
    }

    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * @return the top element of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    @Override
    public Object peek() {
        return list.getHead();
    }

    /**
     * @return string representation of the stack
     */
    @Override
    public String toString() {
        return list.toString();
    }

}
