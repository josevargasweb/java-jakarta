package com.jose.curso.springboot.webapp.springbootweb.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.webapp.springbootweb.model.User;
import com.jose.curso.springboot.webapp.springbootweb.model.dto.UserDto;


@RestController
@RequestMapping("/api")
public class UserRestController {

  // @GetMapping esto es equivalente a @RequestMapping(value = "/details", method = RequestMethod.GET)
  @RequestMapping(path = "/details", method = RequestMethod.GET)
  public UserDto details() {
    UserDto userDto = new UserDto();
    User user = new User("José", "Vargas");
    userDto.setUser(user);
    userDto.setTitle("Hola mundo Spring boot desde controlador");
    return userDto;
  }

  @GetMapping("/list")
  public List<User> list(){
    User user = new User("José", "Vargas");
    User user2 = new User("Emma", "Vargas");
    User user3 = new User("Vane", "Munoz");

    List<User> users = Arrays.asList(user, user2, user3);
    // List<User> users = new ArrayList<>();
    // users.add(user);
    // users.add(user2);
    // users.add(user3);

    return users;
  }

  @RequestMapping(path = "/details-map", method = RequestMethod.GET)
  public Map<String, Object> detailsMap() {
    User user = new User("José", "Vargas");

    Map<String, Object> body = new HashMap<>();

    body.put("title", "Hola mundo Spring boot desde controlador");
    body.put("user", user);
    return body;
  }
}
