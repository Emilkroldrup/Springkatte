package com.example.springkatte;

import com.example.springkatte.Application.MemberList;
import com.example.springkatte.Application.PetList;
import com.example.springkatte.Domain.Pets;
import com.example.springkatte.Domain.User;
import com.example.springkatte.Infrastructure.DAO.PetsDAO;
import com.example.springkatte.Infrastructure.DAO.UserDAO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringkatteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringkatteApplication.class, args);

        User user = new User("adsadasd","Madsss@gmail.com","jamssdsen6","2");
        User user2 = new User("bruger2", "bruger2@gmail.com", "bruger2kode", "1");
        Pets pet = new Pets(1,2,1,"Katten","Bobkat");
        UserDAO userdao = new UserDAO();
        MemberList memberList = new MemberList();
        PetsDAO pdao = new PetsDAO();
        PetList plist = new PetList();


        System.out.println("hej");

        //userdao.addUser(user); WORKS
        // System.out.println(userdao.getAllUsers()); WORKS
        //userdao.removeUser(1); WORKS
        //userdao.EditUserDetails(2,user); WORKS
       // System.out.println(userdao.getUserById(46)); WORKS

        //memberList.addMember(user); WORKS
        //memberList.addMember(user2); WORKS
        //System.out.println(memberList); WORKS

        // plist.addPet(pet); WORKS
        // System.out.println(plist); WORKS


    }
}
