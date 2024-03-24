package edu.itstep.javaintro.mashinelearning;

import java.io.*;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.core.converters.ConverterUtils.DataSource;

public class DecisionTreeML {
    public static void main(String[] arg){
        File inputData = new File("iris.arff");

        //load iris.arff from resources folder
        ClassLoader classLoader = DecisionTreeML.class.getClassLoader();
        File file = new File(classLoader.getResource("iris.arff").getFile());
        File unlabeledFile = new File(classLoader.getResource("ev.arff").getFile());
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            Instances datasetInstances = new Instances(bufferedReader);
            Instances unlabeled = new Instances(new BufferedReader(new FileReader(unlabeledFile)));
            datasetInstances.setClassIndex(datasetInstances.numAttributes()-1);
            unlabeled.setClassIndex(unlabeled.numAttributes()-1);
            J48 tree = new J48();
            tree.buildClassifier(datasetInstances);
            Evaluation evaluation = new Evaluation(datasetInstances);
            evaluation.crossValidateModel(tree, datasetInstances,20, new Random(1));
            //System.out.println(evaluation.toSummaryString("\n ###### J48 #############",true));
            evaluation.evaluateModel(tree, unlabeled);
            System.out.println(evaluation.toSummaryString("\nResults\n======\n", true));
            Instances labeled = new Instances(unlabeled);
            // label instances
            for (int i = 0; i < unlabeled.numInstances(); i++) {
                double clsLabel = tree.classifyInstance(unlabeled.instance(i));
                labeled.instance(i).setClassValue(clsLabel);
            }
            // save labeled data
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("labeled.arff"));
            writer.write(labeled.toString());
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException io) {
            throw new RuntimeException(io);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
