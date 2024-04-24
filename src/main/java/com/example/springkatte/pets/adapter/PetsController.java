package com.example.springkatte.pets.adapter;

import com.example.springkatte.pets.application.PetsService;
import com.example.springkatte.pets.domain.Pets;
import com.example.springkatte.users.application.UserService;
import com.example.springkatte.users.domain.User;
import com.example.springkatte.users.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e, Model model) {
        // Add the error message to the model
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

    private int getCurrentUserId(Principal principal) {
        String email = principal.getName();
        User currentUser = userDAO.getUserByEmail(email);
        return currentUser.getId();
    }

    @GetMapping("/userpets")
    public String showUserPets(Model model, Principal principal) {
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

    @PostMapping("/prevPet")
    public String prevPet() {
        cuerrentpetindex--;
        return "redirect:/userpets";
    }

    @GetMapping("/editUserPets/{petId}")
    public String showEditUserPets(@PathVariable("petId") int petId, Model model, Principal principal) {
        int ownerId = getCurrentUserId(principal);

        Pets pet = petsService.getPetByIds(petId, ownerId);

        model.addAttribute("Pet", pet);
        System.out.println("Hvad" + pet);

        return "editUserPets";
    }

    @PostMapping("/updatePet")
    public String updatePet(Principal principal, @RequestParam("petId") int petId,
                            @RequestParam("petName") String petName,
                            @RequestParam("petAge") int petAge,
                            @RequestParam("petRace") String petRace) {


        int ownerId = getCurrentUserId(principal);
        Pets updatedPet = new Pets(petId,petAge, ownerId, petName, petRace);
        System.out.println("nej" + updatedPet);

        petsService.updatePet(updatedPet);

        // Redirect to the userpets page
        return "redirect:/userpets";
    }
}