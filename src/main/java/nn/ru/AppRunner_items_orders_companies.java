package nn.ru;

import nn.ru.entity2.Item;
import nn.ru.entity2.Order;
import nn.ru.entity2.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppRunner_items_orders_companies {

    public static final Logger logger = LogManager.getLogger(AppRunner_items_orders_companies.class);
    public static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(Item.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        // инициализация данных сущностей
        Order order1 = new Order();
        Item item1 = new Item();
        Company company1 = new Company();

        order1.setCompany(company1);
        item1.setOrder(order1);

        session.save(order1);
//        session.save(item1);
//        session.save(company1);

        session.getTransaction().commit();
        session.close();
// ==================================================================
//        session = factory.openSession();
//        session.beginTransaction();
//
//        // Вычитываем Order:
//        Order order = session.get(Order.class, 1L);
//        Item item = order.getItem();
//        Long itemId = item.getId();
//
//        System.out.println(item.getId());
//        System.out.println("\n\n\n" + session.get(Order.class, 4L));
//
//
//        //        Item item = session.get(Item.class, 1L);
////        System.out.println("\n\n" + item);
//////        item.setOrder(order);
//////        session.save(item);
////
//        session.getTransaction().commit();
//        session.close();


        // ==================================================================
//        session = factory.openSession();
//        session.beginTransaction();
//
//
//        Order order = new Order();
//        session.save(order);
//
//        item = session.get(Item.class, 1L);
//        item.setOrder(order);
//
//
//        System.out.println("\n\n" + order);
//        System.out.println("\n\n" + item);
//
//
////        session.delete(order);
//
//
//        session.getTransaction().commit();
//        session.close();

        // =============================================================

        factory.close();



    }


}
