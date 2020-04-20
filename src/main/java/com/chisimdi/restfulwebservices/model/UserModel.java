package com.chisimdi.restfulwebservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int Id;
  @Size(min = 2)
  private String name;
  @Past
  private Date dob;

  public UserModel() {}

  public UserModel(String name, Date dob) {
    this.name = name;
    this.dob = dob;
  }

  public int getId() {
    return Id;
  }
  public void setId(int id) {
    Id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Date getDob() {
    return dob;
  }
  public void setDob(Date dob) {
    this.dob = dob;
  }
}