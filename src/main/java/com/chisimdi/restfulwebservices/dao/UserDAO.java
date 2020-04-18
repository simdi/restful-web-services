package com.chisimdi.restfulwebservices.dao;

// import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import com.chisimdi.restfulwebservices.model.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<UserModel, Integer> {
  // private List<UserModel> users = new ArrayList<>();

  // static {
  //   users.add(new UserModel("John Doe", new Date()));
  //   users.add(new UserModel("John Smith", new Date()));
  // }
  @Override
  List<UserModel> findAll();

}