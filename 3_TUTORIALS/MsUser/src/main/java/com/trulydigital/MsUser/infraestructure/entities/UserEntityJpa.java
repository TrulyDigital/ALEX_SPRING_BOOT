// @imports packages
package com.trulydigital.MsUser.infraestructure.entities;
// @imports libraries
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntityJpa {

  // @section properties

  @Id
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer age;

  // @section constructors

  public UserEntityJpa(){}

  public UserEntityJpa(
    UUID id,
    String name,
    Integer age
  ){
    this.id = id;
    this.name = name;
    this.age = age;
  }

  // @section Getters - camelCase mandayory for JPA

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  // @section Setters - camelCase mandayory for JPA

  public void setId(UUID id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
