package nn.ru;

import nn.ru.entity2.Order;
import nn.ru.entity4.Company;
import nn.ru.entity4.Group;
import nn.ru.entity4.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class AppRunner_4_util {

    public static final Logger logger = LogManager.getLogger(AppRunner_4_util.class);
    public static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {
        SessionJobDB sessionJobDB = new SessionJobDB();
        sessionJobDB.mainJob();
    }
}
