package ca.ciccc;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DLPriorityQueueTest {
    private static DLPriorityQueue testDLP0 = new DLPriorityQueue<>();
    private static DLPriorityQueue testDLP1 = new DLPriorityQueue<>();
    private static DLPriorityQueue testDLP2 = new DLPriorityQueue<>();
    private static DLPriorityQueue testDLP3 = new DLPriorityQueue<>();


    @BeforeClass
    public static void setup(){
        testDLP1.enqueue(10, "Japan");
        testDLP1.enqueue(50, "Korea");
        testDLP1.enqueue(70, "Brazil");
        testDLP1.enqueue(60, "Australia");
        testDLP1.enqueue(50, "Canada");

        testDLP2.enqueue(30, "China");
        testDLP2.enqueue(10, "the U.S");
        testDLP2.enqueue(40, "Italy");


        testDLP3.enqueue(10, "the U.S");
        testDLP3.enqueue(30, "China");
        testDLP3.enqueue(40, "Italy");
        testDLP3.enqueue(50, "Korea");
        testDLP3.enqueue(50, "Canada");
        testDLP3.enqueue(60, "Australia");
        testDLP3.enqueue(70, "Brazil");

}

    @Test
    public void size() {
        Assert.assertEquals(0, testDLP0.size());
        Assert.assertEquals(3, testDLP2.size());

    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(true, testDLP0.isEmpty());
        Assert.assertEquals(false, testDLP2.isEmpty());
    }

    @Test
    public void enqueue() {
        DLPriorityQueue testDLP = new DLPriorityQueue<>();
        Assert.assertEquals("Japan", testDLP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Korea", testDLP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testDLP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testDLP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Canada", testDLP.enqueue(50, "Canada").getValue());
    }

    @Test
    public void peek() {
        DLPriorityQueue testDLP = new DLPriorityQueue<>();

        Assert.assertEquals("Korea", testDLP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testDLP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testDLP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Japan", testDLP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Canada", testDLP.enqueue(50, "Canada").getValue());

        Assert.assertEquals("Japan", testDLP.peek().getValue());
        Assert.assertEquals("the U.S", testDLP2.peek().getValue());

    }

    @Test
    public void dequeueMin() {
        Assert.assertEquals("Japan", testDLP1.dequeueMin().getValue());
    }


    @Test
    public void merge() {
        DLPriorityQueue testDLP5 = new DLPriorityQueue<>();
        testDLP5.enqueue(30, "China");
        testDLP5.enqueue(10, "the U.S");
        testDLP5.enqueue(40, "Italy");
        Assert.assertEquals(testDLP3, testDLP1.merge(testDLP5));
    }
}