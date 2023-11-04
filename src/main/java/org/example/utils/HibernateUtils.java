package org.example.utils;

import lombok.Getter;
import org.example.entity.Car;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().
            configure().build();

    @Getter
    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new MetadataSources(REGISTRY).
                addAnnotatedClass(Car.class).
                buildMetadata().buildSessionFactory();
    }

    public static void shutDown(){
        getSessionFactory().close();
    }


}
