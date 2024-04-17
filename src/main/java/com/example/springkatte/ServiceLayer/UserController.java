package com.example.springkatte.ServiceLayer;
import com.example.springkatte.DAO.UserDAO;
import com.example.springkatte.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    int id;

    @Autowired
    private UserDAO userDAO;

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

    @GetMapping("/UserLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("User", new User());
        return "UserLogin";
    }

    @GetMapping("/HomeSite")
    public String ShowHomeSite(Model model) {
        model.addAttribute("User", new User());
        return "HomeSite";
    }

    @GetMapping("/AccountDetails")
    public String AccountDetails(Model model){
        model.addAttribute("User", new User());
        return "AccountDetails";
    }



    @PostMapping("/AddUser")
    public String AddUser(@ModelAttribute User user, Model model) {
        userDAO.adduser(user);
        model.addAttribute("User", user);
        return "UserLogin";
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
            return "UserLogin";
        }
    }

    @PostMapping("/DeleteUser")
    public String GotoHomeSite(@ModelAttribute User user, Model model) {
        userDAO.removeuser(id);
        model.addAttribute("User", user);
        return "HomeSite";
    }
    @PostMapping("/GoToAccountDetails")
    public String GotoHomeSite() {

        return "redirect:AccountDetails";
    }

    @PostMapping("/EditUser")
    public String EditUser(@ModelAttribute User user, Model model) {
        userDAO.EditUserDetails(id,user);
        model.addAttribute("User", user);
        return "AccountDetails";
    }
}
