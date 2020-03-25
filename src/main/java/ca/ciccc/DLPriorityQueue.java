package ca.ciccc;

import java.util.LinkedList;
import java.util.List;

public class DLPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {
    private List<Entry<K, V>> queue;

    public DLPriorityQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    private boolean checkBigger(Comparable bigger, Comparable smaller) {
        if(bigger.compareTo(smaller) > 0) {
            return true;
        }  else {
            return false;
        }
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("The key is required.");
        }
        Entry newEntry = new Entry(key, value);
        int index = 0;
        for (int i = 0; i < queue.size() ; i++) {
            if(checkBigger(key, queue.get(i).getKey())) {
                index = i + 1;
            }
        }
        queue.add(index, newEntry);
        return newEntry;
    }

    @Override
    public Entry peek() {
        return queue.get(0);
    }

    @Override
    public Entry dequeueMin() {
        if (!isEmpty()) {
            Entry min = queue.remove(0);
            return min;
        }
        return null;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        while (!other.isEmpty()) {
            Entry temp = other.dequeueMin();
            enqueue((K)temp.getKey(), (V)temp.getValue());
        }
        return this;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < queue.size(); i++) {
            s += "key=" + queue.get(i).getKey().toString() +" value=" +  queue.get(i).getValue().toString() +"\n";
        }
        return s;
    }

}
