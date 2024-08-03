package nn.ru;

import nn.ru.entity2.Order;
import nn.ru.entity4.Company;
import nn.ru.entity4.Group;
import nn.ru.entity4.Item;
import nn.ru.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SessionJobDB {
    public Map<String, Long> mainJob() {

        Map<String, Long> ids = new HashMap<>();

        // === with HibernateUtil: =================================================
        // Session session = HibernateUtil.getSessionFactory().openSession();
        //
        // bla bla bla ...
        //
        // HibernateUtil.shutdown();

        // === Classic: ============================================================
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(nn.ru.entity4.Item.class);
        configuration.addAnnotatedClass(nn.ru.entity4.Group.class);
        configuration.addAnnotatedClass(nn.ru.entity4.Company.class);

        // СОЗДАЕМ ФАКБРИКУ СЕССИЙ:
        SessionFactory factory = configuration.buildSessionFactory();

// === SESSCION 1: ===============================================================

        // ОТКРЫВАЕМ СЕССИЮ:
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // РАБОТА С ДАННЫМИ:
        // Создание и сохранение сущности Item
        Item item = new Item();
        session.save(item);
        Long itemId = item.getId();
        ids.put("itemId", itemId);

        // Создание и сохранение сущности Item
        Group group = new Group();
        session.save(group);
        Long groupId = group.getId();
        ids.put("groupId", groupId);

        // Создание и сохранение сущности Item
        Company company = new Company();
        session.save(company);
        Long companyId = company.getId();
        ids.put("companyId", companyId);

        // ЗАКРЫВАЕМ СЕССИЮ:
        transaction.commit();
        session.close();

        // ЗАКРЫВАЕМ ФАКБРИКУ СЕССИЙ:
        factory.close();


        return ids;

    }
}
