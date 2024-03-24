package edu.itstep.javaintro.sql;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.Doc;

class MongoDBTest {
    private final static Logger logger = LoggerFactory.getLogger(MongoDBTest.class);
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    @BeforeEach
    void setUp() {
        mongoClient = MongoClients.create("mongodb://192.168.88.239:27017");
        database = mongoClient.getDatabase("testMongoDb");
        mongoClient.listDatabaseNames().forEach(System.out::println);
        database.createCollection("users");
        collection = database.getCollection("users");
    }

    @Test
    void mongoDbTest() throws Exception {



//        Document document = new Document();
//        document.put("name", "test2");
//        document.put("password","pass1");
//        collection.insertOne(document);

        Document query = new Document();//as row in database
        query.put("name", "test2");
        Document newDoc = new Document();
        newDoc.put("name", "test3");

        Document update = new Document();
        update.put("$set",newDoc);
        collection.updateOne(query,update);

        Document search = new Document();
        search.put("name","test2");
        FindIterable<Document> cursor = collection.find(search);
        try(MongoCursor<Document> cursorIterator = cursor.cursor()){
            while(cursorIterator.hasNext()){
                System.out.println(cursorIterator.next());
            }
        }
    }
    @Test
    void deleteTest()throws Exception{
        Document search = new Document();
        search.put("name","test1");
        DeleteResult res = collection.deleteOne(search);
        Assertions.assertEquals(0, res.getDeletedCount());
    }
    @AfterEach
    void tearDown() {
    }
}