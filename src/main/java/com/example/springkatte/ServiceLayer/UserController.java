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

    @Autowired
    private UserDAO userDAO;



    @PostMapping("/User")
    public String AddUser(@ModelAttribute User user, Model model) {
        userDAO.adduser(user);
        model.addAttribute("User", user);
        return "UserCreation";
    }
}
