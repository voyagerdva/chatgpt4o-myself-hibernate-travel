package nn.ru;

import nn.ru.entity2.Item;
import nn.ru.entity2.Group;
import nn.ru.entity2.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppRunner_3_items_groups_companies {

    public static final Logger logger = LogManager.getLogger(AppRunner_3_items_groups_companies.class);
    public static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(Item.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        // инициализация данных сущностей
        Group group1 = new Group();
        Item item1 = new Item();
        Company company1 = new Company();

        session.save(group1);
        session.save(item1);
        session.save(company1);

        session.getTransaction().commit();
        session.close();



        factory.close();
    }
}
