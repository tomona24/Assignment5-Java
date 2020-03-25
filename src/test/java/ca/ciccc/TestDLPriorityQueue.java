package ca.ciccc;

import java.util.PriorityQueue;

public class TestDLPriorityQueue {
    public static void main(String[] args) {
        DLPriorityQueue DLPtest = new DLPriorityQueue();
        System.out.println(DLPtest.isEmpty());
        System.out.println("add");
        DLPtest.enqueue(10, "Japan");
        DLPtest.enqueue(50, "Korea");
        DLPtest.enqueue(70, "Brazil");
        DLPtest.enqueue(60, "Australia");
        DLPtest.enqueue(50, "Canada");

        System.out.println(DLPtest);

        System.out.println(DLPtest.isEmpty());
        System.out.println(DLPtest.size());

        System.out.println("peek: " + DLPtest.peek().getValue().toString());

        while(!DLPtest.isEmpty()){
            System.out.println(DLPtest.dequeueMin().getValue().toString());
            System.out.println(DLPtest);
        }
        System.out.println(DLPtest.dequeueMin());
        System.out.println(DLPtest.size());

        DLPtest.enqueue(20, "Japan");
        DLPtest.enqueue(50, "Korea");
        DLPtest.enqueue(10, "Brazil");


        DLPriorityQueue DLPtest2 = new DLPriorityQueue();
        DLPtest2.enqueue(1000, "China");
        DLPtest2.enqueue(10, "the U.S");
        DLPtest2.enqueue(40, "Italy");

        System.out.println(DLPtest.merge(DLPtest2));
    }
    }
