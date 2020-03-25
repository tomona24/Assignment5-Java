package ca.ciccc;

import java.util.Arrays;

public class BHPriorityQueue_discard implements VCPriorityQueue {
    private Entry[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    public BHPriorityQueue_discard() {
        elementData = new Entry[DEFAULT_CAPACITY];
    }

    public BHPriorityQueue_discard(int initialSize){
        elementData = new Entry[initialSize];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private int parentIndex(int childIndex) {
        if(childIndex % 2 == 0) {
            return (childIndex - 2) / 2;
        } else{
            return (childIndex - 1) / 2;
        }
    }

    @Override
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        if(key == null) {
            throw new IllegalArgumentException("The key is required.");
        }
        Entry newEntry = new Entry(key, value);
        elementData[size] = newEntry;
        if(!isEmpty()) {
            int temp = size;
            while (temp > 0 && elementData[parentIndex(temp)].getKey().compareTo(key) > 0) {
                elementData[temp] = elementData[parentIndex(temp)];
                elementData[parentIndex(temp)] = newEntry;
                temp = parentIndex(temp);
                }
        }
        size++;
        return newEntry;
    }

    @Override
    public Entry peek() {
        return elementData[0];
    }

    private int smallerChildIndex(int parentIndex){
        int childLeft = parentIndex * 2 + 1;
        int childRight = parentIndex * 2 + 2;
        if(elementData[childLeft] == null) {
            return parentIndex;
        } else if (elementData[childRight] == null) {
            return childLeft;
        } else if(elementData[childLeft].getKey().compareTo(elementData[childRight].getKey()) < 0) {
            return childLeft;
        } else {
            return childRight;
        }
    }

    @Override
    public Entry dequeueMin() {
        if(!isEmpty()) {
            Entry min = elementData[0];
            Entry tempEntry = elementData[size - 1];
            elementData[0] = tempEntry;
            elementData[size - 1] = null;
            int temp = 0;
            while (elementData[temp] != null && elementData[smallerChildIndex(temp)].getKey()
                    .compareTo(tempEntry.getKey()) < 0) {
                elementData[temp] = elementData[smallerChildIndex(temp)];
                elementData[smallerChildIndex(temp)] = tempEntry;
                temp = smallerChildIndex(temp);
            }
            size--;
            return min;
        } else {
            return null;
        }
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        while (!other.isEmpty()) {
            Entry temp = other.dequeueMin();
            enqueue(temp.getKey(), temp.getValue());
        }
        return this;
    }


    @Override
    public String toString() {
        Object[] arr = new Object[size];
        int counter = 0;
        for (int i = 0; i < size; i++){
            if (elementData[i] != null) {
                arr[counter] = "key: " + elementData[i].getKey().toString() + " value: " + elementData[i].getValue().toString() + "\n";
                counter++;
            }
        }
        return Arrays.toString(arr) ;
    }
}

