package linkedlist;

/**
 * Declares linked-list exercise operations.
 */
public interface ILinkedListExercise {

    /**
     * Reverses a linked list without extra memory.
     *
     * @param list the linked list to reverse.
     * @return the reversed linked list.
     */
    ILinkedList reverse(ILinkedList list);

    /**
     * Compares two linked lists.
     *
     * @param list1 the first linked list.
     * @param list2 the second linked list.
     * @return {@code true} if both lists are identical; otherwise {@code false}.
     */
    boolean compare(ILinkedList list1, ILinkedList list2);

    /**
     * Merges two sorted linked lists in place.
     *
     * @param list1 the first sorted linked list.
     * @param list2 the second sorted linked list.
     * @return one sorted merged linked list.
     */
    ILinkedList merge(ILinkedList list1, ILinkedList list2);
}
