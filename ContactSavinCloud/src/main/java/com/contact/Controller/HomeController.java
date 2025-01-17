package com.contact.Controller;


import com.contact.Message;
import com.contact.Model.User;
import com.contact.Service.UserServices;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cloud")
public class HomeController {

    @Autowired
    UserServices userServices;

    @GetMapping("/")
    public String index() {
        return "redirect:/cloud/home";
    }

    //home page public
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        model.addAttribute("contact", "hii i am modal the thymeleaf");
        return "home";
    }

    @GetMapping("/signup")
    public String signUpFromOpen(Model model, HttpSession session) {
        model.addAttribute("user", new User());
        model.addAttribute("message", new Message());
        return "signup";
    }

    // signup registration process
    @PostMapping("/register")
    public String registerProcess(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
        if (result.hasErrors() || !agreement) {


            if (!agreement) model.addAttribute("message", new Message("alert-danger", "Agreement check required"));
            return "signup";
        }
        if (!userServices.UserInsertDataService(user)) {
            model.addAttribute("message", new Message("alert-danger", "Something went wrong"));
            return "signup";
        } else model.addAttribute("message", new Message("alert-success", "User successfully registered"));
        return "redirect:/cloud/login";
    }

    // login form
    @GetMapping("/login")
    public String LoginFormOpen() {
          return "login";
    }

    //login process form
}
