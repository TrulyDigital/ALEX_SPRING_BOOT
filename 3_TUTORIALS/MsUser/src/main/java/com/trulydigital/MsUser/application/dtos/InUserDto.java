// @imports packages
package com.trulydigital.MsUser.application.dtos;
// @imports libraries
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InUserDto {

  // @section properties

  @NotBlank(message = "name cant't be empty")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "age can't be empty")
  @JsonProperty("age")
  private Integer age;

  // @section constructors

  public InUserDto(){}

  // @section Getters

  @JsonProperty("name")
  public String get_name() {
    return this.name;
  }

  @JsonProperty("age")
  public Integer get_age() {
    return this.age;
  }

  // @section Setters

  @JsonProperty("name")
  public void set_name(String name){
    this.name = name;
  }

  @JsonProperty("age")
  public void set_age(Integer age){
    this.age = age;
  }
}

/**
 * 
 * SERIALIZACIÓN
 * 
 * Jackson usa getters para convertir un objeto 
 * java a JSON
 * 
 * DESERIALIZACIÓN
 * 
 * Jackson usa setters para convertir JSON a un
 * objeto java
 * 
 */
