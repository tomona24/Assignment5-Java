package ca.ciccc;

import org.junit.*;

import static org.junit.Assert.*;

public class TestExampleALPriorityQueueTest {
//    private static ALPriorityQueue<Integer, String> alpg = new ALPriorityQueue<>();
    private static ALPriorityQueue alpg = new ALPriorityQueue();


    // @Before = implement each method
    // @BeforeClass = before all = implement before all

    @BeforeClass  // = before all
    public static void setup() {
        // prepare (object initialization)
        System.out.println("setup");

    }

    @Test  // @Test = anatation
    public void size() {
        System.out.println("size");

    }

    @Test
    public void isEmpty() {
        System.out.println("isEmpty");

    }

    @Test
    public void enqueue() {
        assertEquals("wrong!", "hello", "hello");
    }

    @Test
    public void peek() {
    }

    @Test
    public void dequeueMin() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void testToString() {
    }

    @AfterClass  // = after all
    public static void teardown() {
        // clean up your test object
        System.out.println("teardown");

    }
}