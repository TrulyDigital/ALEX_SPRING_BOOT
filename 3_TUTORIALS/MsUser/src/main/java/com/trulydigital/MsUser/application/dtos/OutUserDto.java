// @imports packages
package com.trulydigital.MsUser.application.dtos;
// @imports libraries
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutUserDto {

  // @section properties

  private UUID transaction_id;
  private String status;
  private Integer status_code;
  private String message;
  private List<UserDto> data = new ArrayList<>();

  // @section constructors

  public OutUserDto(){}

  public OutUserDto(
    UUID transaction_id,
    String status,
    Integer status_code,
    String message,
    List<UserDto> users
  ){
    this.transaction_id = transaction_id;
    this.status = status;
    this.status_code = status_code;
    this.message = message;
    this.data = users;
  }

  // @section Getters

  @JsonProperty("transaction_id")
  public UUID get_transaction_id() {
    return this.transaction_id;
  }

  @JsonProperty("status")
  public String get_status() {
    return this.status;
  }

  @JsonProperty("status_code")
  public Integer get_status_code() {
    return status_code;
  }

  @JsonProperty("message")
  public String get_message() {
    return message;
  }

  @JsonProperty("data")
  public List<UserDto> get_users() {
    return data;
  }

  // @section Setters

  @JsonProperty("transaction_id")
  public void set_transaction_id(UUID transaction_id) {
    this.transaction_id = transaction_id;
  }
  
  @JsonProperty("status")
  public void set_status(String status) {
    this.status = status;
  }
  
  @JsonProperty("status_code")
  public void set_status_code(Integer status_code) {
    this.status_code = status_code;
  }
  
  @JsonProperty("message")
  public void set_message(String message) {
    this.message = message;
  }
  
  @JsonProperty("data")
  public void set_users(List<UserDto> users) {
    this.data = users;
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
