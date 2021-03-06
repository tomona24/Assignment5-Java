package ca.ciccc;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.Assert.*;

public class BHPriorityQueueTest {
    private static BHPriorityQueue testBHP0 = new BHPriorityQueue<>();
    private static BHPriorityQueue testBHP2 = new BHPriorityQueue<>();



    @BeforeClass
    public static void setup(){

        testBHP2.enqueue(30, "China");
        testBHP2.enqueue(10, "the U.S");
        testBHP2.enqueue(40, "Italy");
    }

    @Test
    public void size() {
        Assert.assertEquals(0, testBHP0.size());
        Assert.assertEquals(3, testBHP2.size());

    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(true, testBHP0.isEmpty());
        Assert.assertEquals(false, testBHP2.isEmpty());
    }

    @Test
    public void enqueue() {
        BHPriorityQueue testBHP = new BHPriorityQueue<>();
        Assert.assertEquals("Japan", testBHP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Korea", testBHP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testBHP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testBHP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Canada", testBHP.enqueue(50, "Canada").getValue());
    }

    @Test
    public void peek() {
        BHPriorityQueue testBHP = new BHPriorityQueue<>();

        Assert.assertEquals("Korea", testBHP.enqueue(50, "Korea").getValue());
        Assert.assertEquals("Brazil", testBHP.enqueue(70, "Brazil").getValue());
        Assert.assertEquals("Australia", testBHP.enqueue(60, "Australia").getValue());
        Assert.assertEquals("Japan", testBHP.enqueue(10, "Japan").getValue());
        Assert.assertEquals("Canada", testBHP.enqueue(50, "Canada").getValue());

        Assert.assertEquals("Japan", testBHP.peek().getValue());
        Assert.assertEquals("the U.S", testBHP2.peek().getValue());

    }

    @Test
    public void dequeueMin() {
        BHPriorityQueue testBHP1 = new BHPriorityQueue<>();
        testBHP1.enqueue(50, "Korea");
        testBHP1.enqueue(70, "Brazil");
        testBHP1.enqueue(10, "Japan");
        testBHP1.enqueue(60, "Australia");
        testBHP1.enqueue(50, "Canada");
        Assert.assertEquals("Japan", testBHP1.dequeueMin().getValue());
    }


    @Test
    public void merge() {
        BHPriorityQueue testBHP1 = new BHPriorityQueue<>();
        testBHP1.enqueue(50, "Korea");
        testBHP1.enqueue(70, "Brazil");
        testBHP1.enqueue(60, "Australia");
        testBHP1.enqueue(50, "Canada");

        BHPriorityQueue testBHP5 = new BHPriorityQueue<>();
        testBHP5.enqueue(30, "China");
        testBHP5.enqueue(10, "the U.S");
        testBHP5.enqueue(40, "Italy");
        Assert.assertTrue(checkBHPMerge(testBHP1.merge(testBHP5)));
    }

    private boolean checkBHPMerge(VCPriorityQueue queue) {
        for(int i = queue.size() - 1; i > 0 ; i--) {
            Entry child = ((BHPriorityQueue)queue).getElementData()[i];
            Entry parent;
            if (i % 2 == 0) {
                parent = ((BHPriorityQueue)queue).getElementData()[(i - 2) / 2];
            } else {
                parent = ((BHPriorityQueue)queue).getElementData()[(i-1)/ 2];
            }
            if(parent.getKey().compareTo(child.getKey()) > 0) {
                return false;
            }
        }
        return true;
    }
}