package com.example.springkatte;

import com.example.springkatte.pets.domain.PetList;
import com.example.springkatte.pets.domain.Pets;
import com.example.springkatte.pets.domain.PetsDAO;
import com.example.springkatte.users.domain.MemberList;
import com.example.springkatte.users.domain.User;
import com.example.springkatte.users.domain.UserDAO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringkatteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringkatteApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserDAO userDAO, PetsDAO petsDAO) {
        return args -> {
            User user = new User("adsfdfsdffasd","Madsss@dsfsgmail.com","jamssdsen6","2");
            User user2 = new User("bruger2", "bruger2@gmail.com", "bruger2kode", "1");
            Pets pet = new Pets(1,2,1,"Katten","Bobkat");
            MemberList memberList = new MemberList();
            PetList plist = new PetList();

            //userDAO.addUser(user); WORKS
            //userDAO.removeUser(62); WORKS

            // System.out.println(userDAO.getAllUsers()); Works

            //memberList.addMember(user); WORKS
            //memberList.addMember(user2); WORKS
            //System.out.println(memberList); WORKS

            // plist.addPet(pet);
            // System.out.println(plist); WORKS
        };
    }
}
