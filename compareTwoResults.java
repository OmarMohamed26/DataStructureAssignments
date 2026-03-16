
import java.io.*;
import java.util.*;

interface ILinkedList {

    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index the index you want the new element to be at
     * @param element the element you want to insert
     */
    public void add(int index, Object element);

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element the element to add to the end of the list
     */
    public void add(Object element);

    /**
     * @param index the position of the element to return
     * @return the element at the specified position in this list.
     */
    public Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index the index you want to change the element at
     * @param element the new element
     */
    public void set(int index, Object element);

    /**
     * Removes all of the elements from this list.
     */
    public void clear();

    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the Node you want to remove.
     */
    public void remove(int index);

    /**
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (inclusive) of the subList
     * @return a view of the portion of this list between the specified
     * fromIndex and toIndex, inclusively.
     */
    public ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * @param element the object you want to check if it's in the list.
     * @return true if this list contains an element with the same value as the
     * specified element.
     */
    public boolean contains(Object element);
}

/**
 * A basic singly linked list implementation using inner classes.
 *
 * @author Omar Mohamed
 *
 ********** @version 1.0
 */
class SingleLinkedList implements ILinkedList {

    /**
     * An inner class that represents a Node for a Singly linked list.
     */
    private static class Node {

        // this is pre generic Java code
        private Object obj;

        // this is a reference to the next node
        private Node next;

        /**
         * this constructor will make the next Node to be null
         *
         * @param obj the object you want to be a part of the linked list
         */
        public Node(Object obj) {
            this.obj = obj;
            this.next = null;
        }

        public Object getObj() {

            return obj;
        }

        public Node getNext() {
            return next;

        }

        public void setNext(Node next) {

            this.next = next;

        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

    }

    private Node head = null;

    private Node tail = null;

    private int size = 0;

    /**
     * Main method used for testing the functionomarty of SingleLinkedList.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

    }

    public static SingleLinkedList readFromStdin(Scanner scanner) {
        String line = scanner.nextLine().replaceAll("\\[|\\]", "").trim();
        SingleLinkedList list = new SingleLinkedList();

        if (!line.isEmpty()) {
            String[] tokens = line.split(",\\s*");
            for (String tok : tokens) {
                list.add(Integer.valueOf(tok.trim()));
            }
        }

        return list;
    }

    private void test() {
        SingleLinkedList list = new SingleLinkedList();

        // Test normal adds
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("After adding 1, 2, 3: " + list);

        // Test add at index
        list.add(1, 10);
        System.out.println("After inserting 10 at index 1: " + list);

        // Test array constructor
        SingleLinkedList omar = new SingleLinkedList(new Object[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Array constructor list: " + omar);

        // Test get
        System.out.println("Element at index 2 in first list: " + list.get(2));

        // Test set
        list.set(0, 99);
        System.out.println("After setting index 0 to 99: " + list);

        // Test remove
        list.remove(list.size() - 1);
        System.out.println("After removing the last element: " + list);

        // Test contains
        System.out.println("Contains 10? : " + list.contains(10));
        System.out.println("Contains 500? : " + list.contains(500));

        // Test null handling
        list.add(null);
        System.out.println("After adding null: " + list);
        System.out.println("Contains null? : " + list.contains(null));

        // Test sublist
        ILinkedList sub = omar.sublist(2, 5);
        System.out.println("Sublist of second list from index 2 to 5: " + sub);

        // Test clear
        list.clear();
        System.out.println("After clear() - isEmpty: " + list.isEmpty() + ", list: " + list);
    }

    // this is necessary because we have another constructor
    /**
     * Create an empty linked list.
     */
    public SingleLinkedList() {
    }

    /**
     * Make an empty list from an array.
     *
     * @param arr the array of objects you want to initiomarze the Linked list
     * with.
     */
    @SuppressWarnings({""})
    public SingleLinkedList(Object[] arr) {
        for (Object obj : arr) {
            this.add(obj);

        }
    }

    /**
     * Inserts a specified element at the specified position in the list.
     *
     * @param index the index you want the new element to be at
     * @param element the element you want to insert
     */
    @Override
    public void add(int index, Object element) {

        // I use the size function not the member to apply OOP concepts
        if (index > this.size() || index < 0) /* Illegal case */ {
            throw new IndexOutOfBoundsException("Index out of bound");

        }

        if (this.size() == index) /*Insert at the tail of the list*/ {

            this.add(element);

            return;
        }

        if (index == 0) { // insert at head

            Node node = new Node(element);
            node.setNext(head);
            head = node;

            if (tail == null) {

                tail = node;
            }

        } else /* Inserting at the strict middle of the list */ {
            Node prev = this.head;
            for (int i = 1; i < index; i++) { // pointer hopping until we reach the node before we want to insert
                prev = prev.getNext();
            }
            Node node = new Node(element);
            node.setNext(prev.getNext());
            prev.setNext(node);

        }

        size++; // this should be run for the two cases above
    }

    /**
     * Inserts a specified element at beginning in the list.
     *
     * @param element the element you want to insert
     */
    public void addHead(Object element) {
        this.add(0, element);
    }

    /**
     * Inserts the specified element at the end of the list.
     *
     * @param element
     */
    @Override
    public void add(Object element) { // add tail
        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;

        size++;
    }

    @Override
    public Object get(int index) {

        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");

        }

        Node node = this.head;
        for (int i = 0; i < index; i++) { // pointer hopping until we reach the node before we want to insert
            node = node.getNext();
        }

        return node.getObj();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index the index you want to change the element at
     * @param element the new element
     */
    @Override
    public void set(int index, Object element) {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");

        }

        Node node = this.head;
        for (int i = 0; i < index; i++) { // pointer hopping until we reach the node before we want to insert
            node = node.getNext();
        }

        node.setObj(element);
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        // GC makes things really easy here
    }

    /**
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the Node you want to remove.
     */
    @Override
    public void remove(int index) {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if (index == 0) { // remove the head (He is dead :)
            head = head.getNext();
            if (head == null) {
                tail = null; // this is an important edge case
            }
        } else {
            Node prev = this.head;
            for (int i = 0; i < index - 1; i++) { // pointer hopping to the node before target
                prev = prev.getNext();
            }

            // Bypass the node to be removed
            prev.setNext(prev.getNext().getNext()); // --> -->

            // If the removed node was the tail, update tail correctly
            if (index == size() - 1) {
                tail = prev;
            }
        }

        size--;
    }

    /**
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (inclusive) of the subList
     * @return a view of the portion of this list between the specified
     * fromIndex and toIndex, inclusively.
     */
    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex < 0 || toIndex >= this.size()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        ILinkedList newLinkedList = new SingleLinkedList();

        Node current = this.head;
        // Advance to the fromIndex
        for (int i = 0; i < fromIndex; i++) {
            current = current.getNext();
        }

        // Add elements inclusively from fromIndex to toIndex
        for (int i = fromIndex; i <= toIndex; i++) {
            newLinkedList.add(current.getObj());
            current = current.getNext();
        }

        return newLinkedList;
    }

    /**
     * @param element the object you want to check if it's in the list.
     * @return true if this list contains an element with the same value as the
     * specified element.
     */
    @Override
    public boolean contains(Object element) {
        if (this.isEmpty()) {
            return false;
        }

        Node node = this.head;
        while (node != null) {
            // Null-safe comparison
            if (element == null ? node.getObj() == null : element.equals(node.getObj())) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    /**
     * Returns a string representation of the list in the form "[elem1, elem2,
     * ...]". If the list is empty, returns "[]".
     *
     * @return a string representation of this linked list
     */
    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[]";
        }

        StringBuilder str = new StringBuilder();
        str.append('[');

        Node node = this.head;
        while (node != null) {
            Object obj = node.getObj();
            str.append(obj == null ? "null" : obj.toString());
            if (node.getNext() != null) {
                str.append(", ");
            }
            node = node.getNext();
        }

        str.append(']');
        return str.toString();
    }
}

public class Solution {

    public static void main(String[] args) {
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

            if (compare(firstList, secondList)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }

    }

    public static boolean compare(ILinkedList list1, ILinkedList list2) {
        return list1.toString().equals(list2.toString());

    }
}
