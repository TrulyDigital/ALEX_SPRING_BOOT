// @imports packages
package com.trulydigital.MsUser.domain.entities;
// @imports libraries
import java.util.UUID;

public class UserEntity {
  
  // @section properties

  private UUID id;
  private String name;
  private Integer age;

  // @section constructors

  public UserEntity(
    UUID id,
    String name,
    Integer age
  ){
    this.id = id;
    this.name = name;
    this.age = age;
  }

  // @section Getters
  
  public UUID get_id() {
    return this.id;
  }

  public String get_name() {
    return this.name;
  }

  public Integer get_age() {
    return this.age;
  }

  // @section Setters

  public void set_id(UUID id) {
    this.id = id;
  }

  public void set_name(String name) {
    this.name = name;
  }

  public void set_age(Integer age) {
    this.age = age;
  }
}
