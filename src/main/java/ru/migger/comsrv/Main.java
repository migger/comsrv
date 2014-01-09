package ru.migger.comsrv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] strings) throws Exception {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("comsrv.context.xml");
    }
}
