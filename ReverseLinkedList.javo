/*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
// the code is cut like this from hackerrank

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if(llist == null || llist.next == null)
            return llist;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode before = null;
        SinglyLinkedListNode after = null;
            while(current.next != null)
            {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }
            current.next = before;
            return current;
        }
