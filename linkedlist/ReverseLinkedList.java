package linkedlist;

/**
 * HackerRank-style reverse linked list helper.
 */
public final class ReverseLinkedList {

    /**
     * Simple singly linked list node used by this helper.
     */
    public static final class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        /**
         * Creates a node with the provided data value.
         *
         * @param data the stored integer value.
         */
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    private ReverseLinkedList() {
    }

    /**
     * Reverses a singly linked list.
     *
     * @param llist the list head.
     * @return the new head after reversing.
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if (llist == null || llist.next == null) {
            return llist;
        }
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode before = null;
        SinglyLinkedListNode after = null;
        while (current.next != null) {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        current.next = before;
        return current;
    }
}
