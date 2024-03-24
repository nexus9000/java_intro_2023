package edu.itstep.javaintro.mashinelearning;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DecisionTreeMLTest {
private File inputData;
    @BeforeEach
    void setUp() {
       inputData  = new File("iris.arff");

    }
    @Test
    void testDataExists()throws IOException{
        boolean dataSetExists = inputData.exists();
        assertTrue(dataSetExists,"DataSet exists");
    }
}