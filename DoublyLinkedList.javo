import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
    /**
     * Inserts a specified element at the specified position in the list.
     * @param index
     * @param element
     */
    public void add(int index, Object element);
    /**
     * Inserts the specified element at the end of the list.
     * @param element
     */
    public void add(Object element);
    /**
     * @param index
     * @return the element at the specified position in this list.
     */
    public Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     * @param element
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
     * @param index
     */
    public void remove(int index);
    /**
     * @return the number of elements in this list.
     */
    public int size();
    /**
     * @param fromIndex
     * @param toIndex
     * @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
     */
    public ILinkedList sublist(int fromIndex, int toIndex);
    /**
     * @param o
     * @return true if this list contains an element with the same value as the specified element.
     */
    public boolean contains(Object o);

    public String listMaker();

    public DoubleLinkedList listParser(String list);
}


public class DoubleLinkedList implements ILinkedList {


    private static class Node {
        Object data;
        Node next;
        Node prev;

        void setNext(Node node)
        {
            this.next = node;
        }
        void setPrev(Node node)

        {
            this.prev = node;
        }

        Node(Object data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
    Node header;
    Node trailer;
    int size;
    public DoubleLinkedList()
    {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    public void add(int index , Object element)
    {
        if(index > size || index < 0)
            throw  new IndexOutOfBoundsException("Index " + index + "is out of bounds");

        Node inserted = new Node(element);


        Node current = header.next;
        for(int i = 0 ; i <index ; i++)
        {

            current = current.next;

        }
        inserted.next = current;
        inserted.setPrev(current.prev);
        current.setPrev(inserted);
        inserted.prev.setNext(inserted);

        size++;
    }

    public void add(Object element)
    {
        Node inserted = new Node(element);
        inserted.setNext(trailer);
        inserted.setPrev(trailer.prev);
        inserted.prev.setNext(inserted);
        trailer.setPrev(inserted);
        size++;
    }
    public Object get(int index)
    {
        if(index >=size || index < 0)
            throw  new IndexOutOfBoundsException("Index " + index + "is out of bounds");

        Node current = header.next;
        for(int i = 0 ; i < index ; i++)
        {
            current = current.next;
        }
        return current.data;

    }

    public void set(int index , Object element)
    {
        if(index >=size || index < 0)
            throw  new IndexOutOfBoundsException("Index " + index + "is out of bounds");

        Node current = header.next;
        for(int i = 0 ; i < index ; i++)
        {
            current = current.next;
        }
        current.data = element;
    }
    public void clear()
    {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }

    public void remove(int index)
    {
        if(index >=size || index < 0)
            throw  new IndexOutOfBoundsException("Index " + index + "is out of bounds");

        Node current = header.next;
        for(int i = 0 ; i < index ; i++)
        {
            current = current.next;
        }
        current.data = null;
        current.prev.setNext(current.next);
        current.next.setPrev(current.prev);
        size--;
    }

    public int size()
    {
        return size;
    }
    public ILinkedList sublist(int fromIndex, int toIndex)
    {
        ILinkedList subList = new DoubleLinkedList();
        if(fromIndex >=size || fromIndex < 0)
            throw  new IndexOutOfBoundsException("Index " + fromIndex + "is out of bounds");
        if(toIndex >=size || toIndex < 0)
            throw  new IndexOutOfBoundsException("Index " + toIndex + "is out of bounds");
        if(fromIndex > toIndex)
            throw new IndexOutOfBoundsException("fromIndex is bigger than toIndex");
        Node current1 = header.next;
        for(int i = 0 ; i < fromIndex ; i++)
        {
            current1 = current1.next;
        }

        subList.add(current1.data);
        for(int i = fromIndex ; i < toIndex ; i++)
        {
            current1 = current1.next;
            subList.add(current1.data);
        }
        return subList;
    }
    public boolean contains(Object o)
    {
        if(size == 0)
            return false;
        Node current = header.next;
        for(int i = 0 ; i < size ; i++)
        {
            if(o != null && current.data.equals(o))
                return true;
            current = current.next;
        }
        return false;
    }
    public String listMaker()
    {
        StringBuilder sb = new StringBuilder();
        Node current = header.next;
        sb.append("[");
        while(current != trailer)
        {
            sb.append(current.data);
            if(current.next != trailer)
                sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public DoubleLinkedList listParser(String list)
    {
        String noBracketsList = list.substring(1 , list.length() - 1).replaceAll("\\s", "");
        if(noBracketsList.isEmpty())
            return new DoubleLinkedList();
        String[] elements = noBracketsList.split(",");
        int len = elements.length;
        DoubleLinkedList Dll = new DoubleLinkedList();
        for(int i = 0 ; i < len ; i++)
        {
            Dll.add(elements[i]);
        }

        return Dll;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        DoubleLinkedList Dll = new DoubleLinkedList();
        Dll = Dll.listParser(list);
        String finalList;
        Object finalObject;
        int index;
        Object element;
        String operation = sc.nextLine();
        switch(operation)
        {
            case "add":
                try {
                    element = sc.nextLine().trim();
                    Dll.add(element);
                    finalList = Dll.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "addToIndex":
                try {
                    index = sc.nextInt();
                    sc.nextLine();
                    element = sc.nextLine().trim();
                    Dll.add(index , element);
                    finalList = Dll.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "get":
                try {
                    index = sc.nextInt();
                    finalObject = Dll.get(index);
                    System.out.println(finalObject);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "set":
                try {
                    index = sc.nextInt();
                    sc.nextLine();
                    element = sc.nextLine().trim();
                    Dll.set(index , element);
                    finalList = Dll.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "clear":
                try {
                    Dll.clear();
                    finalList = Dll.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "isEmpty":
                try {
                    System.out.println(Dll.isEmpty() ? "True" : "False");
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "remove":
                try {
                    index = sc.nextInt();
                    Dll.remove(index);
                    finalList = Dll.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "sublist":
                try {
                    int from = sc.nextInt();
                    int to = sc.nextInt();
                    ILinkedList subList = Dll.sublist(from , to);
                    finalList = subList.listMaker();
                    System.out.println(finalList);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "contains":
                try {
                    element = sc.nextLine().trim();
                    System.out.println(Dll.contains(element) ? "True" : "False");
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            case "size":
                try {
                    int size = Dll.size();
                    System.out.println(size);
                } catch(Exception e) {
                    System.out.println("Error");
                }
                break;

            default:
                break;
        }
    }
}
