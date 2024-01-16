package com.jose.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.jose.curso.springboot.webapp.springbootweb.model.User;



@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model){
     User user = new User("José", "Vargas");
     user.setEmail("jox.wall@gmail.com");
    model.addAttribute("title", "Hola mundo Spring boot desde controlador");
    model.addAttribute("user", user);
    return "details";
  }

  @GetMapping("/list")
  public String list(ModelMap model) {
    List<User> users = Arrays.asList(
      new User("jose", "Vargas","jox.wall@gmail.com"),
      new User("emma", "Vargas","emma.wall@gmail.com"),
      new User("vane", "Munoz")
      );

    model.addAttribute("users",users);
    model.addAttribute("title","Listado de usuarios");
    return "list";
  }
  

  // @ModelAttribute("users")
  // public List<User> userModel(){
  //   List<User> users = Arrays.asList(
  //     new User("jose", "Vargas","jox.wall@gmail.com"),
  //     new User("emma", "Vargas","emma.wall@gmail.com"),
  //     new User("vane", "Munoz")
  //     );

  //     return users;
  // }
}
