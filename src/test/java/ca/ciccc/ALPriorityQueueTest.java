package ca.ciccc;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ALPriorityQueueTest {
    private static ALPriorityQueue testALP0 = new ALPriorityQueue<>();
    private static ALPriorityQueue testALP1 = new ALPriorityQueue<>();
    private static ALPriorityQueue testALP2 = new ALPriorityQueue<>();
    private static ALPriorityQueue testALP3 = new ALPriorityQueue<>();


    @BeforeClass
    public static void setup(){


        testALP1.enqueue(10, "Japan");
        testALP1.enqueue(50, "Korea");
        testALP1.enqueue(70, "Brazil");
        testALP1.enqueue(60, "Australia");
        testALP1.enqueue(50, "Canada");

        testALP2.enqueue(30, "China");
        testALP2.enqueue(10, "the U.S");
        testALP2.enqueue(40, "Italy");


        testALP3.enqueue(50, "Korea");
        testALP3.enqueue(70, "Brazil");
        testALP3.enqueue(60, "Australia");
        testALP3.enqueue(50, "Canada");
        testALP3.enqueue(30, "China");
        testALP3.enqueue(10, "the U.S");
        testALP3.enqueue(40, "Italy");

}

    @Test
    public void size() {
        Assert.assertEquals(0, testALP0.size());
        Assert.assertEquals(3, testALP2.size());

    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(true, testALP0.isEmpty());
        Assert.assertEquals(false, testALP2.isEmpty());
    }

    @Test
    public void enqueue() {
        ALPriorityQueue testALP = new ALPriorityQueue<>();
        Assert.assertEquals("Japan", testALP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Korea", testALP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testALP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testALP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Canada", testALP.enqueue(50, "Canada").getValue());
    }

    @Test
    public void peek() {
        ALPriorityQueue testALP = new ALPriorityQueue<>();
        Assert.assertEquals("Korea", testALP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testALP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testALP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Japan", testALP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Canada", testALP.enqueue(50, "Canada").getValue());
        Assert.assertEquals("Japan", testALP.peek().getValue());
        Assert.assertEquals("the U.S", testALP2.peek().getValue());

    }

    @Test
    public void dequeueMin() {
        Assert.assertEquals("Japan", testALP1.dequeueMin().getValue());
    }


    @Test
    public void merge() {
        ALPriorityQueue testALP5 = new ALPriorityQueue<>();
        testALP5.enqueue(30, "China");
        testALP5.enqueue(10, "the U.S");
        testALP5.enqueue(40, "Italy");


        Assert.assertEquals(testALP3, testALP1.merge(testALP5));
    }
}