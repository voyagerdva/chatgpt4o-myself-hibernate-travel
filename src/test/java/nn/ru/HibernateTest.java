package nn.ru;

import nn.ru.entity2.Company;
import nn.ru.entity2.Group;
import nn.ru.entity2.Item;
import nn.ru.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    @Test
    public void testInsert() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        Long itemId = null;
        Long groupId = null;
        Long companyId = null;

        try {
            transaction = session.beginTransaction();

            Item item = new Item();
            session.save(item);
            assertNotNull(item.getId(), "Item ID не должно быть НУЛЛ после сохранения в таблицу");

            Group group = new Group();
            session.save(group);
            assertNotNull(group.getId(), "Group ID не должно быть НУЛЛ после сохранения в таблицу");

            Company company = new Company();
            session.save(company);
            assertNotNull(company.getId(), "Company ID не должно быть НУЛЛ после сохранения в таблицу");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void testEntitiesExist() {

        Map<String, Long> ids = readIdsFromFile("ids.txt");

        Long itemId = ids.get("Item");
        Long groupId = ids.get("Group");
        Long companyId = ids.get("Company");

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Item savedItem = session.get(Item.class, itemId);
            assertNotNull(savedItem, "Item ID не должно быть НУЛЛ после сохранения в таблицу");

            Group savedGroup = session.get(Group.class, groupId);
            assertNotNull(savedGroup, "Group ID не должно быть НУЛЛ после сохранения в таблицу");

            Company savedCompany = session.get(Company.class, itemId);
            assertNotNull(savedCompany, "Company ID не должно быть НУЛЛ после сохранения в таблицу");

        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }

    private Map<String, Long> readIdsFromFile(String filename) {
        Map<String, Long> ids = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                ids.put(parts[0], Long.parseLong(parts[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ids;
    }
}
