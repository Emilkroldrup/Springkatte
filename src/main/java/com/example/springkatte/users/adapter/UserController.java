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

import java.util.List;


@Controller
public class UserController {
    int id;

    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;


    @GetMapping("/")
    public String redirectToLoginPage(Model model) {
        return "redirect:/LoginPage";
    }

    @GetMapping("/LoginPage")
    public String showLoginForm(Model model) {
        model.addAttribute("User", new User());
        return "LoginPage";
    }

    @GetMapping("/UserCreation")
    public String Usercreation(Model model){
        model.addAttribute("User", new User());
        return "UserCreation";
    }

    @GetMapping("/UserDelete")
    public String UserDelete(Model model){
        model.addAttribute("User", new User());
        return "UserDelete";
    }
    @GetMapping("/MemberList")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("UserList", userList);
        return "MemberList";
    }

    @GetMapping("/HomeSite")
    public String ShowHomeSite(Model model) {
        model.addAttribute("User", new User());
        return "HomeSite";
    }

    @GetMapping("/AccountDetails")
    public String showAccountDetails(Model model) {
        User user = userService.getUser(id); // Assuming id is defined somewhere
        model.addAttribute("User", user);
        return "AccountDetails";
    }

    @GetMapping("/ChangeAccountDetails")
    public String EditAccountDetails(Model model){
        model.addAttribute("User", new User());
        return "ChangeAccountDetails";
    }






    @PostMapping("/LoginUser")
    public String LoginUser(@ModelAttribute User user, Model model) {
        boolean loginSuccessful = userDAO.logincheck(user);
        id = UserDAO.id;
        if (loginSuccessful) {

            model.addAttribute("User", user);
            return "HomeSite";

        } else {
            model.addAttribute("User", user);
            return "LoginPage";
        }
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        model.addAttribute("User", user);
        return "LoginPage";
    }

    @PostMapping("/DeleteUser")
    public String GotoHomeSite(@ModelAttribute User user, Model model) {
        userService.removeUser(id);
        model.addAttribute("User", user);
        return "LoginPage";
    }

    @PostMapping("/GoToAccountDetails")
    public String GoToAccountDetails() {

        return "redirect:AccountDetails";
    }



    @PostMapping("/AccountDetails")
    public String ShowAccountDetails(@ModelAttribute User user, Model model) {
        user = userService.getUser(id);
        model.addAttribute("User", user);
        return "AccountDetails";
    }

    @PostMapping("/GoToChangeDetails")
    public String ToChangeDetails() {
        return "redirect:ChangeAccountDetails";
    }

    @PostMapping("/EditAccount")
    public String EditUser(@ModelAttribute User user, Model model) {
        userService.updateUser(id,user);
        model.addAttribute("User", user);
        return "ChangeAccountDetails";
    }

}
