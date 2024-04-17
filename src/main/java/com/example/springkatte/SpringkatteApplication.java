package com.example.springkatte;

import com.example.springkatte.Domain.Pets;
import com.example.springkatte.Domain.User;
import com.example.springkatte.Infrastructure.DAO.UserDAO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringkatteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringkatteApplication.class, args);

        User user = new User("adsadasd","Madsss@gmail.com","jamssdsen6","2");
        Pets pet = new Pets(1,2,1,"Katten","Bobkat");
        UserDAO userdao = new UserDAO();
        System.out.println("hej");

        //userdao.adduser(user); WORKS
        // System.out.println(userdao.getallusers()); WORKS
        //userdao.removeuser(1); WORKS
        //userdao.EditUserDetails(2,user); WORKS
       // System.out.println(userdao.GetDetailsFromId(46)); WORKS


    }
}
