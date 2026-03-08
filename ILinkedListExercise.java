
public interface ILinkedListExercise {

    /**
     * @param list a linked list that you are supposed to reverse
     * @return reverse the linked list without using extra memory
     */
    public ILinkedList reverse(ILinkedList list);

    /**
     * @param list1 First linked list
     * @param list2 Second linked list
     * @return true if the two lists are identical and false otherwise
     */
    public boolean compare(ILinkedList list1, ILinkedList list2);

    /**
     * @param list1 First sorted linked list
     * @param list2 Second sorted linked list
     * @return merges the two lists into one sorted list in-place (without using
     * extra memory)
     */
    public ILinkedList merge(ILinkedList list1, ILinkedList list2);
}
