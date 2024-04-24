package com.example.springkatte.pets.adapter;

import com.example.springkatte.pets.application.PetsService;
import com.example.springkatte.pets.domain.Pets;
import com.example.springkatte.users.application.UserService;
import com.example.springkatte.users.domain.User;
import com.example.springkatte.users.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class PetsController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PetsService petsService;

    private int cuerrentpetindex = 0;


    private int getCurrentUserId(Principal principal) {
        String email = principal.getName();
        User currentUser = userDAO.getUserByEmail(email);
        return currentUser.getId();
    }

    @GetMapping("/userpets")
    public String showUserPets(Model model,Principal principal) {
        int userId = getCurrentUserId(principal);
        User user = userService.getUser(userId);
        List<Pets> userPets = petsService.getallPetsbyOwnerid(userId);

        if (cuerrentpetindex < 0) {
            cuerrentpetindex = 0;
        } else if (cuerrentpetindex >= userPets.size()) {
            cuerrentpetindex = userPets.size() - 1;
        }

        Pets currentpetid = userPets.get(cuerrentpetindex);
        model.addAttribute("User", user);
        model.addAttribute("Pets", currentpetid);

        return "userPets";
    }
    @PostMapping("/gotouserPets")
    public String ToUserPets() {
        return "redirect:userpets";
    }

    @PostMapping("/nextPet")
    public String nextPet() {
        cuerrentpetindex++;
        return "redirect:/userpets";
    }

    // Add a method to handle navigation to the previous pet
    @PostMapping("/prevPet")
    public String prevPet() {
        cuerrentpetindex--;
        return "redirect:/userpets";
    }
}
