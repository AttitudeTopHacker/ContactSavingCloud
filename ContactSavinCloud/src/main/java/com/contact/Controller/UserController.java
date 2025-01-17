package com.contact.Controller;

import com.contact.Message;
import com.contact.Model.Contact;
import com.contact.Model.User;
import com.contact.Repository.ContactRepository;
import com.contact.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "user_dash/welcome";

    }

    @GetMapping("/add_contact_form")
    public String contactForm(Model model) {
        model.addAttribute("message", new Message());
        return "user_dash/add_contact";
    }

    @PostMapping("/add/contact")
    public String UseraddContact(@ModelAttribute("contact") Contact contact, @RequestParam(value = "image", required = false) MultipartFile image,
                                 Principal principal, Model model
            , BindingResult result) throws IOException {
        try {
            if (image != null) {
                String filename = image.getOriginalFilename();
                assert filename != null;
                filename = filename.substring(filename.lastIndexOf("."));
                filename = UUID.randomUUID() + filename;
                File filePath = new File("uploads/image");
                if (!filePath.exists()) {
                    System.out.println(filePath.mkdirs());
                }
                FileOutputStream fos = new FileOutputStream(filePath.getPath() + "/" + filename);

                fos.write(image.getBytes());
                fos.close();
            } else contact.setImage_c("default.png");

            User user = userServices.FindByUserNameService(principal.getName());
            contact.setUser(user);
            user.getContact().add(contact);
            System.out.println(userServices.ContactInsertDataService(contact));
           model.addAttribute("message", new Message("alert alert-success","Contact added successfully"));
        } catch (Exception e) {
            model.addAttribute("message", new Message("alert alert-danger", "something went wrong"));
        }
        return "user_dash/add_contact";
    }

}