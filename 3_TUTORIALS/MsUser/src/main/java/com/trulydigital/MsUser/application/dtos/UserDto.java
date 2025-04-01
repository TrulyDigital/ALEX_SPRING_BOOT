// @imports packages
package com.trulydigital.MsUser.application.dtos;
// @imports libraries
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

  // @section properties

  private UUID id;
  private String name;
  private Integer age;

  // @section constructors

  public UserDto(){}

  public UserDto(
    UUID id,
    String name,
    Integer age
  ){
    this.id = id;
    this.name = name;
    this.age = age;
  }

  // @section Getters
  
  @JsonProperty("id")
  public UUID get_id() {
    return this.id;
  }

  @JsonProperty("name")
  public String get_name() {
    return this.name;
  }

  @JsonProperty("age")
  public Integer get_age() {
    return this.age;
  }

  // @section Setters

  @JsonProperty("id")
  public void set_id(UUID id) {
    this.id = id;
  }

  @JsonProperty("name")
  public void set_name(String name) {
    this.name = name;
  }

  @JsonProperty("age")
  public void set_age(Integer age) {
    this.age = age;
  }
}
