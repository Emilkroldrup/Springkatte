package com.example.springkatte;

import com.example.springkatte.DAO.UserDAO;
import com.example.springkatte.Model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringkatteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringkatteApplication.class, args);

        User user = new User("sfdfdffs","Madsss@gmail.com","jamssdsen6","2");
        UserDAO userdao = new UserDAO();
        System.out.println("hej");

        //userdao.adduser(user); WORKS
        // System.out.println(userdao.getallusers()); WORKS
        //userdao.removeuser(1); WORKS
        userdao.EditUserDetails(2,user);


    }
}
