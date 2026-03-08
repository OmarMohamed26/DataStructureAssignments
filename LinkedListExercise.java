
import java.util.Scanner;

public class LinkedListExercise implements ILinkedListExercise {

    /**
     * @param list a linked list that you are supposed to reverse
     * @return reverse the linked list without using extra memory
     */
    public ILinkedList reverse(ILinkedList list) {
        return new SingleLinkedList(); // this is just a dummy return to make the file compile
    }

    /**
     * @param list1 First linked list
     * @param list2 Second linked list
     * @return true if the two lists are identical and false otherwise
     */
    public boolean compare(ILinkedList list1, ILinkedList list2) {

        return list1.toString().equals(list2.toString());
    }

    public void runCompareTwoLists() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());

        for (int i = 0; i < t; i++) {

            SingleLinkedList firstList = new SingleLinkedList();
            int n = Integer.parseInt(in.nextLine());

            for (int j = 0; j < n; j++) {
                firstList.add(Integer.parseInt(in.nextLine()));
            }

            int m = Integer.parseInt(in.nextLine());
            SingleLinkedList secondList = new SingleLinkedList();
            for (int j = 0; j < m; j++) {
                secondList.add(Integer.parseInt(in.nextLine()));
            }

            LinkedListExercise sol = new LinkedListExercise();

            if (sol.compare(firstList, secondList)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    /**
     * @param list1 First sorted linked list
     * @param list2 Second sorted linked list
     * @return merges the two lists into one sorted list in-place (without using
     * extra memory)
     */
    public ILinkedList merge(ILinkedList list1, ILinkedList list2) {
        return new SingleLinkedList();
    }
}
