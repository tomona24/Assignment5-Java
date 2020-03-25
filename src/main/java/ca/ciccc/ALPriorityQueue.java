package ca.ciccc;

import java.util.ArrayList;
import java.util.Arrays;


public class ALPriorityQueue implements VCPriorityQueue {
    private ArrayList<Entry> elementData;
    private int size;

    public ALPriorityQueue() {
        elementData = new ArrayList<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        if(key == null) {
            throw new IllegalArgumentException("The key is required.");
        }
        Entry newEntry = new Entry(key, value);
        elementData.add(newEntry);
        size++;
        return newEntry;
    }

    @Override
    public Entry peek() {
        if(elementData.size() == 0) {
            return null;
        }
        Entry min = elementData.get(0);
        for (int i = 0; i < size; i++) {
            Entry temp = elementData.get(i);
            if(temp.getKey().compareTo(min.getKey()) < 0){
                min = temp;
            }
        }
        return min;
    }

    @Override
    public Entry dequeueMin() {
        if(isEmpty()){
                return null;
        }  else {
        Entry min = this.peek();
        elementData.remove(this.peek());
        size--;
        return min;
        }
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        while(!other.isEmpty()) {
            elementData.add(other.dequeueMin());
            size++;
        }
        return this;
    }

    @Override
    public String toString() {
        Object[] arr = new Object[size];
        int counter = 0;
        for (int i = 0; i < size; i++){
            if (elementData.get(i) != null) {
                arr[counter] =  "key: " + elementData.get(i).getKey().toString() + " value: " + elementData.get(i).getValue().toString() + "\n";
                counter++;
            }
        }
        return Arrays.toString(arr) ;
    }
}
