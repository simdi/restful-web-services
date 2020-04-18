package com.chisimdi.restfulwebservices.api;

import java.net.URI;
import java.util.List;

import com.chisimdi.restfulwebservices.model.UserModel;
import com.chisimdi.restfulwebservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<UserModel> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/users/{id}")
  public UserModel getUser(@PathVariable int id) {
    return userService.getUser(id);
  }

  @PostMapping("/users")
  public ResponseEntity<Object> postUser(@RequestBody UserModel user) {
    UserModel savedUser = userService.save(user);
    // I want to return the newly created path
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }
}