package pl.sda.javaldz6.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.javaldz6.model.User;
import pl.sda.javaldz6.service.UserService;
import pl.sda.javaldz6.service.UserServiceSingleton;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    @Qualifier("userServiceSingleton")
    private UserService userServiceAnnotationSingleton;

    @GetMapping(value = "/users")
    public String getUsers(Model model){
        model.addAttribute("users", userServiceAnnotationSingleton.getAll());
        return "users";
    }
    @GetMapping(value = "/addUser")
    public String showUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("index",userServiceAnnotationSingleton.getAll().size());
        return "user";

    }
    @PostMapping(value = "/saveUser")
    String submit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @ModelAttribute("index") int index ){
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (index == userServiceAnnotationSingleton.getAll().size()){
            userServiceAnnotationSingleton.addUser(user.getName(),user.getAge());

        } else{
            User userFound = userServiceAnnotationSingleton.getUserById(new Integer(index));
        boolean isRemoved = userServiceAnnotationSingleton.getAll().remove(userFound);
        log.info("is user removed?" + isRemoved);
        userServiceAnnotationSingleton.addUser(user.getName(),user.getAge());
        }


//        bindingResult.getModel().put("index", index);
//        bindingResult.getModel().put("name",user.getName());
//        bindingResult.getModel().put("age",user.getAge());
        return "redirect:/searchUsers";
    }
    @GetMapping(value = "/searchUsers")
    String getUsersWithFilter(Model model, @RequestParam(value = "name", defaultValue = "") String string){
        model.addAttribute("users", userServiceAnnotationSingleton.getUserByName(string));
        return "usersWithFilter";
    }
    @PostMapping(value = "/")
    String delete(int index){
        userServiceAnnotationSingleton.deleteUser(index);
        return "redirect:/users";
    }
    @GetMapping(value = "/user/{id}/update")
    String showUserFormForUpdate(@PathVariable ("id") int index, Model model){
        model.addAttribute("user", userServiceAnnotationSingleton.getUserById(index));
        model.addAttribute("index",index);
        return "user";
    }
}
