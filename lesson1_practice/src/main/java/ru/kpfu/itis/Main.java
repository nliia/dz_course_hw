package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.config.JavaConfig;
import ru.kpfu.itis.impl.WarriorImpl;

public class Main {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
//        WarriorImpl warrior = (WarriorImpl) context.getBean("warrior");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Warrior warrior = context.getBean(Warrior.class);
        warrior.fight();
    }
}
