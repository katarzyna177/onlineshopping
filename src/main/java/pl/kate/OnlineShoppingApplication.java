package pl.kate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.kate.order.Order;

import javax.xml.validation.Validator;

@SpringBootApplication
public class OnlineShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingApplication.class, args);
    }

    /*@Bean
    Validator validator(){
        return new LocalValidatorFactoryBean();
    }*/

    //Order order = new Order();


}
