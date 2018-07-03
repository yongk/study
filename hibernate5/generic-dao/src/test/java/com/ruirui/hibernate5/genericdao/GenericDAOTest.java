package com.ruirui.hibernate5.genericdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericDAOTest {

    static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testSave() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person person = new Person();
        person.setName("Jacky");
        person.setAge(11);
        session.save(person);

        session.getTransaction().commit();
        session.close();
    }
}
