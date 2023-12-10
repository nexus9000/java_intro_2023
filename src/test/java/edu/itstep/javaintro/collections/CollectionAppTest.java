package edu.itstep.javaintro.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;


class CollectionAppTest {
   private ArrayList<Integer> testArray;
   private LinkedList<String> testLinkedList;
   private HashMap<Integer, String> testHashMap;
   private LinkedHashMap<Integer, String> testLinkedHashMap;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testArray = new ArrayList<>(20);
        testLinkedList = new LinkedList<>();
        testHashMap = new HashMap<>();
    }
    @Test
    void testArrayList(){
        /* big O insert and get is O(1)
           remove element re-order collections
         */
     testArray.add(111);
     testArray.add(222);
     testArray.add(222);
     Assertions.assertEquals(3, testArray.size());
    }

    @Test
    void setTestLinkedList(){
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
    }
}