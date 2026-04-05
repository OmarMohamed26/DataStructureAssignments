/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    private static final int CONST = 20000;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectionNode = null;

        // --- Phase 1: Mark all nodes in list A by adding CONST to their values ---
        // Use a temporary pointer 'currentA' to traverse and modify list A.
        ListNode currentA = headA;
        while (currentA != null) {
            currentA.val += CONST;
            currentA = currentA.next;
        }

        // --- Phase 2: Traverse list B and detect intersection ---
        // Use a temporary pointer 'currentB' to traverse list B.
        ListNode currentB = headB;
        while (currentB != null) {
            // If currentB.val is >= CONST, it means this node was previously
            // visited and modified when traversing list A. This is our intersection.
            if (currentB.val >= CONST) {
                intersectionNode = currentB; // Store the intersection node
                break; // We found the first intersection, no need to check further in list B
            }
            currentB = currentB.next;
        }

        // --- Phase 3: Clean up list A (restore original values) ---
        // This step MUST happen regardless of whether an intersection was found or not,
        // to restore the original state of list A.
        // Reset 'currentA' back to the beginning of list A.
        currentA = headA;
        while (currentA != null) {
            currentA.val -= CONST; // Subtract CONST to restore the original value
            currentA = currentA.next;
        }

        // --- Phase 4: Return the result ---
        // This will be the intersectionNode if found, or null if no intersection.
        return intersectionNode;
    }
}
