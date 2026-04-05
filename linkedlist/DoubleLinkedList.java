package linkedlist;

/**
 * A basic doubly linked list implementation.
 */
public class DoubleLinkedList implements ILinkedList {

    private static class Node {
        Object data;
        Node next;
        Node prev;

        Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        void setNext(Node node) {
            this.next = node;
        }

        void setPrev(Node node) {
            this.prev = node;
        }
    }

    Node header;
    Node trailer;
    int size;

    /**
     * Creates an empty doubly linked list.
     */
    public DoubleLinkedList() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }

        Node inserted = new Node(element);
        Node current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        inserted.next = current;
        inserted.setPrev(current.prev);
        current.setPrev(inserted);
        inserted.prev.setNext(inserted);
        size++;
    }

    @Override
    public void add(Object element) {
        Node inserted = new Node(element);
        inserted.setNext(trailer);
        inserted.setPrev(trailer.prev);
        inserted.prev.setNext(inserted);
        trailer.setPrev(inserted);
        size++;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }

        Node current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }

        Node current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }

        Node current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = null;
        current.prev.setNext(current.next);
        current.next.setPrev(current.prev);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        ILinkedList subList = new DoubleLinkedList();
        if (fromIndex >= size || fromIndex < 0) {
            throw new IndexOutOfBoundsException("Index " + fromIndex + "is out of bounds");
        }
        if (toIndex >= size || toIndex < 0) {
            throw new IndexOutOfBoundsException("Index " + toIndex + "is out of bounds");
        }
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex is bigger than toIndex");
        }
        Node current1 = header.next;
        for (int i = 0; i < fromIndex; i++) {
            current1 = current1.next;
        }

        subList.add(current1.data);
        for (int i = fromIndex; i < toIndex; i++) {
            current1 = current1.next;
            subList.add(current1.data);
        }
        return subList;
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        Node current = header.next;
        for (int i = 0; i < size; i++) {
            if (o != null && current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns a bracketed string representation of this list.
     *
     * @return the list representation.
     */
    public String listMaker() {
        StringBuilder sb = new StringBuilder();
        Node current = header.next;
        sb.append("[");
        while (current != trailer) {
            sb.append(current.data);
            if (current.next != trailer) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Parses a bracketed list string into a new doubly linked list.
     *
     * @param list the input list string.
     * @return the parsed doubly linked list.
     */
    public DoubleLinkedList listParser(String list) {
        String noBracketsList = list.substring(1, list.length() - 1).replaceAll("\\s", "");
        if (noBracketsList.isEmpty()) {
            return new DoubleLinkedList();
        }
        String[] elements = noBracketsList.split(",");
        int len = elements.length;
        DoubleLinkedList dll = new DoubleLinkedList();
        for (int i = 0; i < len; i++) {
            dll.add(elements[i]);
        }
        return dll;
    }
}
