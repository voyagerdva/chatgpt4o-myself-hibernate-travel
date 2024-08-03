package nn.ru;

import nn.ru.entity4.Company;
import nn.ru.entity4.Group;
import nn.ru.entity4.Item;
import nn.ru.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HibernateTest {
//
//    @Test
//    public void testInsert() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//
//        Long itemId = null;
//        Long groupId = null;
//        Long companyId = null;
//
//        try {
//            transaction = session.beginTransaction();
//
//            Item item = new Item();
//            session.save(item);
//            assertNotNull(item.getId(), "Item ID не должно быть НУЛЛ после сохранения в таблицу");
//
//            Group group = new Group();
//            session.save(group);
//            assertNotNull(group.getId(), "Group ID не должно быть НУЛЛ после сохранения в таблицу");
//
//            Company company = new Company();
//            session.save(company);
//            assertNotNull(company.getId(), "Company ID не должно быть НУЛЛ после сохранения в таблицу");
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    @Test
//    public void testEntitiesExist() {
//
//        Map<String, Long> ids = readIdsFromFile("ids.txt");
//
//        Long itemId = ids.get("Item");
//        Long groupId = ids.get("Group");
//        Long companyId = ids.get("Company");
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        try {
//            Item savedItem = session.get(Item.class, itemId);
//            assertNotNull(savedItem, "Item ID не должно быть НУЛЛ после сохранения в таблицу");
//
//            Group savedGroup = session.get(Group.class, groupId);
//            assertNotNull(savedGroup, "Group ID не должно быть НУЛЛ после сохранения в таблицу");
//
//            Company savedCompany = session.get(Company.class, itemId);
//            assertNotNull(savedCompany, "Company ID не должно быть НУЛЛ после сохранения в таблицу");
//
//        } finally {
//            session.close();
//            HibernateUtil.shutdown();
//        }
//    }

    @Test
    public void testClassSessionJobDB() {

        SessionJobDB sessionJobDB = new SessionJobDB();
        Map<String, Long> ids = sessionJobDB.mainJob();

        Long itemId = ids.get("itemId");
        Long groupId = ids.get("groupId");
        Long companyId = ids.get("companyId");

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(nn.ru.entity4.Item.class);
        configuration.addAnnotatedClass(nn.ru.entity4.Group.class);
        configuration.addAnnotatedClass(nn.ru.entity4.Company.class);


        // СОЗДАЕМ ФАКБРИКУ СЕССИЙ:
        SessionFactory factory = configuration.buildSessionFactory();

// === SESSION 1: ===============================================================

        // ОТКРЫВАЕМ СЕССИЮ:
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // РАБОТА С ДАННЫМИ:
        Item savedItem = session.get(Item.class, itemId);
        assertNotNull(savedItem, "Item ID must not be NULL after save in table");

        Group savedGroup = session.get(Group.class, groupId);
        assertNotNull(savedGroup, "Group ID must not be NULL after save in table");

        Company savedCompany = session.get(Company.class, companyId);
        assertNotNull(savedCompany, "Company ID must not be NULL after save in table");


        // ЗАКРЫВАЕМ СЕССИЮ:
        transaction.commit();
        session.close();

        // ЗАКРЫВАЕМ ФАКБРИКУ СЕССИЙ:
        factory.close();

    }

    @Test
    public void testDirectRelation() {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(nn.ru.entity4.Item.class);
        configuration.addAnnotatedClass(nn.ru.entity4.Group.class);


        // СОЗДАЕМ ФАКБРИКУ СЕССИЙ:
        SessionFactory factory = configuration.buildSessionFactory();

// === SESSION 1: ===============================================================

        // ОТКРЫВАЕМ СЕССИЮ:
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // РАБОТА С ДАННЫМИ:
        Item savedItem = session.get(Item.class, itemId);
        assertNotNull(savedItem, "Item ID must not be NULL after save in table");

        Group savedGroup = session.get(Group.class, groupId);
        assertNotNull(savedGroup, "Group ID must not be NULL after save in table");



        // ЗАКРЫВАЕМ СЕССИЮ:
        transaction.commit();
        session.close();

        // ЗАКРЫВАЕМ ФАКБРИКУ СЕССИЙ:
        factory.close();

    }
}
