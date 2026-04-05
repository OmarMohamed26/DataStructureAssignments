package linkedlist;

/**
 * Utility node type used by {@link Solution}.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Solves the intersection-of-two-linked-lists problem.
 */
public class Solution {

    private static final int CONST = 20000;

    /**
     * Creates a solution helper.
     */
    public Solution() {
    }

    /**
     * Finds the intersection node between two singly linked lists.
     *
     * @param headA the head of the first list.
     * @param headB the head of the second list.
     * @return the first intersection node, or {@code null} if there is none.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectionNode = null;

        ListNode currentA = headA;
        while (currentA != null) {
            currentA.val += CONST;
            currentA = currentA.next;
        }

        ListNode currentB = headB;
        while (currentB != null) {
            if (currentB.val >= CONST) {
                intersectionNode = currentB;
                break;
            }
            currentB = currentB.next;
        }

        currentA = headA;
        while (currentA != null) {
            currentA.val -= CONST;
            currentA = currentA.next;
        }

        return intersectionNode;
    }
}
