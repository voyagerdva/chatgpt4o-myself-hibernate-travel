package nn.ru;

import nn.ru.entity2.Company;
import nn.ru.entity2.Group;
import nn.ru.entity2.Item;
import nn.ru.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppRunner_4_util {

    public static final Logger logger = LogManager.getLogger(AppRunner_4_util.class);
    public static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try (PrintWriter writer = new PrintWriter(new FileWriter("ids.txt"))) {
            transaction = session.beginTransaction();

            // Создание и сохранение сущности Item
            Item item = new Item();
            session.save(item);
            Long itemId = item.getId();
            writer.println("Item:" + itemId);
            System.out.println("Item записан с ID=" + itemId);

            // Создание и сохранение сущности Item
            Group group = new Group();
            session.save(group);
            Long groupId = group.getId();
            writer.println("Group:" + groupId);
            System.out.println("Group записан с ID=" + groupId);

            // Создание и сохранение сущности Item
            Company company = new Company();
            session.save(company);
            Long companyId = company.getId();
            writer.println("Company:" + companyId);
            System.out.println("Company записан с ID=" + companyId);

            transaction.commit();
        } catch (IOException | RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.shutdown();

    }
}
