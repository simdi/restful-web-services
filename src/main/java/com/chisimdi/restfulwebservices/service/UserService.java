package com.chisimdi.restfulwebservices.service;

import java.util.List;
import java.util.Optional;

import com.chisimdi.restfulwebservices.dao.UserDAO;
import com.chisimdi.restfulwebservices.exception.UserNotFoundException;
import com.chisimdi.restfulwebservices.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDAO userDAO;

  public List<UserModel> getUsers() {
    return userDAO.findAll();
  }

  public UserModel save(UserModel user) {
    return userDAO.save(user);
  }

  public UserModel getUser(int id) {
    Optional<UserModel> user = userDAO.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("User not found");
    }
    return user.get();
  }

}