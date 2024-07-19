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
//        configuration.addAnnotatedClass(City.class);
//        configuration.addAnnotatedClass(Trip.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        // инициализация данных Department
        Department department = new Department("CasterRock4", 500, 1200);

        // инициализация данных Leader
        Leader leader = new Leader("Stannis4", 1000);

        // инициализация данных Employee
        Employee employee1 = new Employee("Tirion4", 800);
        Employee employee2 = new Employee("Jeime4", 600);


        // Добавление начальника и работников в департамент:
        department.setLeader(leader);
        leader.setDepartment(department);

//        department.addEmployeeToDepartment(employee1);
//        department.addEmployeeToDepartment(employee2);

        session.save(leader);
//        session.save(department);

//        Long leaderId = 34L;
//        Leader leader1 = session.get(Leader.class, leaderId);
//        System.out.println();
//        System.out.println(leader1);


        session.getTransaction().commit();
        session.close();





        factory.close();



    }


}
