package com.example.springkatte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringkatteApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringkatteApplication.class, args);

        User user = new User("egadsdsn","Madsss@gmail.com","jamssdsen6");
        UserDAO userdao = new UserDAO();
        System.out.println("hej");

        userdao.adduser(user);

    }

}
