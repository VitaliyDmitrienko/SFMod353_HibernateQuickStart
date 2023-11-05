package org.example;

import org.example.entity.Car;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args ) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Car car = new Car();
        car.setProducer("Tesla");
        car.setModel("Model Turbo");

        session.save(car);
        session.getTransaction().commit();
        session.close();

        session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Car existedCar = session.get(Car.class,1L);

        System.out.println(existedCar != null);
        System.out.println(existedCar);
        session.getTransaction().commit();
        session.close();

        HibernateUtils.shutDown();
    }
}
