package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA
        int userAPrice = statefulService1.order("userA",10000);
        // ThreadB
        int userBPrice = statefulService2.order("userB",20000);

        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }
}