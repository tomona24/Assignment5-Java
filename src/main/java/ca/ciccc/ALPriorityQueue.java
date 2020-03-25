package ca.ciccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ALPriorityQueue<K extends Comparable, V> implements  VCPriorityQueue<K, V> {
    private List<Entry> elementData;

    public ALPriorityQueue() {
        elementData = new ArrayList<>();
    }

    @Override
    public int size() {
        return elementData.size();
    }

    @Override
    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    @Override
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        if(key == null) {
            throw new IllegalArgumentException("The key is required.");
        }
        Entry newEntry = new Entry(key, value);
        elementData.add(newEntry);
        return newEntry;
    }

    @Override
    public Entry peek() {
        if(elementData.isEmpty()) {
            return null;
        }
        Entry min = elementData.get(0);
        for (int i = 0; i < elementData.size(); i++) {
            Entry temp = elementData.get(i);
            if(temp.getKey().compareTo(min.getKey()) < 0){
                min = temp;
            }
        }
        return min;
    }

    @Override
    public Entry dequeueMin() {
        if(elementData.isEmpty()) {
            return null;
        }
        Entry min = elementData.get(0);
        for (int i = 0; i < elementData.size(); i++) {
            Entry temp = elementData.get(i);
            if(temp.getKey().compareTo(min.getKey()) < 0){
                min = temp;
            }
        }
        elementData.remove(min);
        return min;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue<K, V> other) {
        elementData.addAll(((ALPriorityQueue<K, V>) other).elementData);
        return this;
    }

    @Override
    public String toString() {
        Object[] arr = new Object[elementData.size()];
        int counter = 0;
        for (int i = 0; i < elementData.size(); i++){
            if (elementData.get(i) != null) {
                arr[counter] =  "key: " + elementData.get(i).getKey().toString() + " value: " + elementData.get(i).getValue().toString() + "\n";
                counter++;
            }
        }
        return Arrays.toString(arr) ;
    }
}
