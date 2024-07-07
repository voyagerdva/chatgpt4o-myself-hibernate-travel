package nn.ru;

import nn.ru.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppRunner {

    public static final Logger logger = LogManager.getLogger(AppRunner.class);
    public static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Leader.class);
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Trip.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        // инициализация данных
        Department department = new Department("IT", 500, 1000);

    }


}
