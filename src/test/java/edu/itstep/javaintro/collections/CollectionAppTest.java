package edu.itstep.javaintro.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


class CollectionAppTest {
    private ArrayList<Integer> testArray;
    private LinkedList<String> testLinkedList;
    private HashMap<Integer, String> testHashMap;
    private LinkedHashMap<Integer, String> testLinkedHashMap;
    private Queue<Tickets> tickets;
    private HashSet<String> cities;
    private Stack<Tickets> ticketOrder;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testArray = new ArrayList<>(20);
        testLinkedList = new LinkedList<>();
        testHashMap = new HashMap<>();
        cities = new HashSet<>();
        tickets = new LinkedList<>();
        ticketOrder = new Stack<>();

    }

    @Test
    void testArrayList() {
        /* big O insert and get is O(1)
           remove element re-order collections
         */
        testArray.add(111);
        testArray.add(222);
        testArray.add(222);
        Assertions.assertEquals(3, testArray.size());
        Iterator<Integer> it = testArray.iterator();
        while (it.hasNext()) {
            Integer entry = it.next();
            if (entry == 111) {
                it.remove();

            }

        }
        testArray.forEach(n -> System.out.println(n));
        Assertions.assertEquals(2, testArray.size());
    }

    @Test
    void testHashMap() throws Exception{
        testHashMap.put(101, "New York");
        testHashMap.put(102, "London");
        for(Map.Entry<Integer, String> set : testHashMap.entrySet()){
            System.out.println(set.getKey() + " "+ set.getValue());
        }
        testHashMap.forEach((key,value)->System.out.printf("%d %S%n",key,value));
    }
    @Test
    void setTestLinkedList() {
        testLinkedList.add("Sofia");
        testLinkedList.add("New York");
        testLinkedList.add("London");
        Assertions.assertEquals(3, testLinkedList.size());
        testLinkedList.remove("Sofia");
        Assertions.assertEquals(2, testLinkedList.size());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testArray = null;
        testLinkedList = null;
        System.gc();
    }
}