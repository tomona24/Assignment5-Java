package ca.ciccc;

public class TestBHPriorityQueue {
    public static void main(String[] args) {
        BHPriorityQueue BHPtest = new BHPriorityQueue();
        System.out.println(BHPtest.isEmpty());
        System.out.println("add");
        BHPtest.enqueue(10, "Japan");
        BHPtest.enqueue(50, "Korea");
        BHPtest.enqueue(70, "Brazil");
        BHPtest.enqueue(60, "Australia");
        BHPtest.enqueue(50, "Canada");
        System.out.println(BHPtest);
        System.out.println("size Again");
        System.out.println(BHPtest.isEmpty());
        System.out.println(BHPtest.size());


        System.out.println(BHPtest.peek().getValue().toString());

        System.out.println(BHPtest.dequeueMin().getValue().toString());
        System.out.println(BHPtest);
        System.out.println(BHPtest.size());

        while(!BHPtest.isEmpty()){
            System.out.println(BHPtest.dequeueMin().getValue().toString());
            System.out.println(BHPtest);
        }
        System.out.println(BHPtest.dequeueMin());
        System.out.println(BHPtest.size());

        BHPtest.enqueue(10, "Japan");
        BHPtest.enqueue(50, "Korea");
        BHPtest.enqueue(70, "Brazil");
        BHPtest.enqueue(60, "Australia");
        BHPtest.enqueue(50, "Canada");

        System.out.println(BHPtest);

        BHPriorityQueue BHPtest2 = new BHPriorityQueue();

        BHPtest2.enqueue(1000, "China");
        BHPtest2.enqueue(10, "the U.S");
        BHPtest2.enqueue(40, "Italy");

        System.out.println(BHPtest.merge(BHPtest2));

    }
}
