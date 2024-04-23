package com.example.springkatte.users.adapter;

import com.example.springkatte.users.application.UserService;
import com.example.springkatte.users.domain.User;
import com.example.springkatte.users.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class UserController {
    int id;

    @Autowired
    private UserService userService;
   
    @Autowired
    private UserDAO userDAO;    

    // current user function :P
    private int getCurrentUserId(Principal principal) {
        String email = principal.getName();
        User currentUser = userDAO.getUserByEmail(email);
        return currentUser.getId();
    }


    @GetMapping("/")
    public String defaultRedirect(@RequestParam(required = false) String continueParam) {
        if (continueParam != null && !continueParam.isEmpty()) {
            return "redirect:" + continueParam;
        }
        return "redirect:/LoginPage";
    }

    @GetMapping("/LoginPage")
    public String showLoginForm(Model model) {
        model.addAttribute("User", new User());
        return "LoginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "LogoutPage";
    }

    @GetMapping("/HomeSite")
    public String ShowHomeSite(Model model) {
        model.addAttribute("User", new User());
        return "HomeSite";
    }

  /*  @PostMapping("/LoginUser")
    public String LoginUser(@ModelAttribute User user, Model model) {
        boolean loginSuccessful = userService.loginCheck(user);
        id = UserDAO.id;
        if (loginSuccessful) {
            System.out.println("id" + id);
            model.addAttribute("User", user);
            return "HomeSite";

        } else {
            model.addAttribute("User", user);
            return "LoginPage";
        }
    }

   */


    @GetMapping("/UserCreation")
    public String Usercreation(Model model){
        model.addAttribute("User", new User());
        return "UserCreation";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        model.addAttribute("User", user);
        return "LoginPage";
    }


    @GetMapping("/UserDelete")
    public String UserDelete(Model model){
        model.addAttribute("User", new User());
        return "UserDelete";
    }

    @PostMapping("/DeleteUser")
    public String GotoHomeSite(@ModelAttribute User user, Model model, Principal principal) {
        int id = getCurrentUserId(principal);
        userService.removeUser(id);
        model.addAttribute("User", user);
        return "LoginPage";
    }

    @GetMapping("/AccountDetails")
    public String showAccountDetails(Model model, Principal principal) {
        int id = getCurrentUserId(principal);
        User user = userService.getUser(id);
        model.addAttribute("User", user);
        return "AccountDetails";
    }

    @GetMapping("/ChangeAccountDetails")
    public String EditAccountDetails(Model model, Principal principal){
        int id = getCurrentUserId(principal);
        User user = userService.getUser(id);
        model.addAttribute("User", user);
        return "ChangeAccountDetails";
    }

    @PostMapping("/GoToChangeDetails")
    public String ToChangeDetails() {
        return "redirect:ChangeAccountDetails";
    }

    @PostMapping("/EditAccount")
    public String EditUser(@ModelAttribute User user, Model model, Principal principal) {
        int id = getCurrentUserId(principal);
        userService.updateUser(id, user);
        return "redirect:HomeSite";
    }
}
