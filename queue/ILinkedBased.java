package queue;

import java.util.Scanner;
import linkedlist.SingleLinkedList;

/**
 * Linked-based implementation of the IQueue interface. Uses a SingleLinkedList
 * as the underlying storage.
 */
public class ILinkedBased implements IQueue {

    /**
     * Underlying single linked list that stores queue elements.
     */
    private SingleLinkedList list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ILinkedBased queue = new ILinkedBased();
        queue.list = SingleLinkedList.readFromStdin(scanner);

        String operation = scanner.nextLine();

        switch (operation) {
            case "enqueue": {
                Integer num = Integer.parseInt(scanner.nextLine());
                queue.enqueue(num);
                System.out.println(queue);
                break;
            }
            case "dequeue": {
                queue.dequeue();
                System.out.println(queue);
                break;
            }
            case "isEmpty": {
                if (queue.isEmpty()) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
                break;
            }
            case "size": {
                System.out.println(queue.size());
                break;
            }
            default:
                scanner.close();
                throw new AssertionError();
        }

        scanner.close();
    }

    /**
     * Constructs an empty linked-based queue.
     */
    public ILinkedBased() {
        list = new SingleLinkedList();
    }

    /**
     * Adds an item to the end of the queue.
     *
     * @param item the element to be enqueued
     */
    @Override
    public void enqueue(Object item) {
        // queue front is the left side in output
        list.addHead(item);
    }

    /**
     * Removes and returns the element at the front of the queue. If the queue
     * is empty this method delegates to the underlying list behavior (may
     * return null or throw based on that implementation).
     *
     * @return the dequeued element, or null if the queue is empty
     */
    @Override
    public Object dequeue() {
        if (list.isEmpty()) {
            throw new Error("Underflow");
        }

        // remove queue rear (right side in output)
        Object rear = list.getTail();
        list.remove(list.size() - 1); // O(n) in singly linked list
        return rear;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        // prints head -> tail, which now matches required format
        return list.toString();
    }

}
