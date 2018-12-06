package com.example.MySqlWithGradle.controller;

import com.example.MySqlWithGradle.data.entity.User;
import com.example.MySqlWithGradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String goHome(ModelMap modelMap)
    {
        List<User> userList = userRepository.findAll();
        modelMap.addAttribute("users",userList);
        return "index";
    }

    @GetMapping("/add_new")
    public String addNew(ModelMap modelMap)
    {
        modelMap.addAttribute("user",new User());
        return "add_new";
    }

    @PostMapping("/add_new")
    public String addNew(@ModelAttribute User user)
    {
        userRepository.save(user);
        return "inserted-message";
    }

    @GetMapping("/delete/{id}")
    public String delateUser(@PathVariable(value = "id") Integer id, Model model)
    {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return "redirect:/";
    }

    @GetMapping("/upload/{id}")
    public String uploadPage(@PathVariable(value = "id") Integer id, Model model)
    {
        User user = userRepository.getOne(id);
        model.addAttribute("user",user);
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadPage(@ModelAttribute("user") User user)
    {
        userRepository.save(user);
        return "redirect:/";
    }

}
