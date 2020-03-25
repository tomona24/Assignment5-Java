package ca.ciccc;

import java.util.PriorityQueue;

public class TestALPriorityQueue {
    public static void main(String[] args) {
        ALPriorityQueue testALP = new ALPriorityQueue();

        System.out.println(testALP.isEmpty());
        System.out.println(testALP.size());
        System.out.println("add");
        testALP.enqueue(10, "Japan");
        testALP.enqueue(50, "Korea");
        testALP.enqueue(70, "Brazil");
        testALP.enqueue(60, "Australia");
        testALP.enqueue(50, "Canada");
        System.out.println(testALP);
        System.out.println("size Again");
        System.out.println(testALP.size());
        System.out.println("size end");


        System.out.println(testALP.peek().getValue().toString());

        System.out.println("dequeue");
        System.out.println(testALP.dequeueMin().getValue().toString());
        System.out.println(testALP);
        System.out.println(testALP.size());

        while(!testALP.isEmpty()){
            System.out.println(testALP.dequeueMin().getValue().toString());
            System.out.println(testALP);
        }
        System.out.println(testALP.dequeueMin());
        System.out.println(testALP.size());

        testALP.enqueue(10, "Japan");
        testALP.enqueue(50, "Korea");
        testALP.enqueue(70, "Brazil");
        testALP.enqueue(60, "Australia");
        testALP.enqueue(50, "Canada");

        ALPriorityQueue testALP2 = new ALPriorityQueue();

        testALP2.enqueue(3, "China");
        testALP2.enqueue(10, "the U.S");
        testALP2.enqueue(40, "Italy");

        System.out.println(testALP.merge(testALP2));

    }
}
