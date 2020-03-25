package ca.ciccc;

import java.util.LinkedList;

public class DLPriorityQueue implements VCPriorityQueue {
    private Node head, tail;
    private int size;

    private static class Node<E> {
        Entry data;
        Node next;
        Node prev;

        Node(Entry data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private boolean checkBigger(Comparable bigger, Comparable smaller) {
        if(bigger.compareTo(smaller) >= 0) {
            return true;
        }  else {
            return false;
        }
    }

    @Override
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("The key is required.");
        }
        Entry newEntry = new Entry(key, value);
        Node newNode = new Node(newEntry, null, null);
        Node tempHead = head;
        Node tempTail = tail;
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (size == 1) {
            if (checkBigger(key, head.data.getKey())) {
                tempHead.next = newNode;
                newNode.prev = tempHead;
                tail = newNode;
            } else {
                newNode.next = tempHead;
                tempHead.prev = newNode;
                head = newNode;
                tail = tempHead;
            }
        } else if (checkBigger(key, tail.data.getKey())) {
            tempTail.next = newNode;
            newNode.prev = tempTail;
            tail = newNode;
        } else if (checkBigger(head.data.getKey(), key)) {
            tempHead.prev = newNode;
            newNode.next = tempHead;
            head = newNode;
        } else {
            while (checkBigger(key, tempHead.data.getKey())) {
                tempHead = tempHead.next;
            }
            tempHead.prev.next = newNode;
            tempHead.prev = newNode;
            newNode.prev = tempHead.prev;
            newNode.next = tempHead;
        }
        size++;
        return newEntry;
    }

    @Override
    public Entry peek() {
        return head.data;
    }

    @Override
    public Entry dequeueMin() {
        if (!isEmpty()) {
            Entry min = head.data;
            if (size == 1) {
                head = null;
                tail = null;
            } else if (size > 1) {
                head.next.prev = null;
                head = head.next;
            }
            size--;
            return min;
        }
        return null;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        while (!other.isEmpty()) {
            Entry temp = other.dequeueMin();
            System.out.println(temp.getValue());
            enqueue(temp.getKey(), temp.getValue());
            System.out.println(this);
        }
        return this;
    }

    @Override
    public String toString() {
        // TODO
        // ex) "Obj0"=="Obj1"==null
        Node node = head;
        String s = "";
        while (node != null) {
            s += node.data.getValue().toString() + "=";
            node = node.next;
        }
        s += "null";
        return s;
    }
}
