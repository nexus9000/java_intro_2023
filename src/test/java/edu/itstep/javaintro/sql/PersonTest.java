package edu.itstep.javaintro.sql;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PersonTest {
    private static Logger logger = LoggerFactory.getLogger(PersonTest.class);

    @BeforeEach
    void setUp() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Person person = new Person("John", "Doe", 33, 123456);
            // PersonTest person1 = new PersonTest("John", 20);
            em.persist(person);
            // em.persist(person1);
//        List<Users> result = em.createQuery("from Users").getResultList();
//        System.out.println("##################################################");
//        for (Users user : result) {
//            System.out.println(user.getUserName() + " " + user.getPassword());
//        }
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
            logger.error(he.getMessage());
        }
        em.close();

    }

    @Test
    @Disabled
    void testPersonName()throws Exception{

    }
    @AfterEach
    void tearDown() {
    }
}