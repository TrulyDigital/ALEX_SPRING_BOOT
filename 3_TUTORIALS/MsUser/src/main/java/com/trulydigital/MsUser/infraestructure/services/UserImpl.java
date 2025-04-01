// @imports packages
package com.trulydigital.MsUser.infraestructure.services;
// @imports libraries
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
// @imports internal
import com.trulydigital.MsUser.domain.entities.UserEntity;
import com.trulydigital.MsUser.domain.repositories.UserRepository;
import com.trulydigital.MsUser.infraestructure.entities.UserEntityJpa;
import com.trulydigital.MsUser.infraestructure.repositories.UserRepositoryJpa;

@Service
public class UserImpl implements UserRepository {

  // @section properties

  private final UserRepositoryJpa user_repository_jpa;

  // @section constructors

  public UserImpl(
    UserRepositoryJpa user_repository_jpa
  ){
    this.user_repository_jpa = user_repository_jpa;
  }


  // @section UserRepository implementation

  @Override
  public List<UserEntity> find_all_users(){
    List<UserEntityJpa> users_entity_jpa = this.find_all();
    List<UserEntity> users_entity = users_entity_jpa
      .stream()
      .map(user -> new UserEntity(user.getId(), user.getName(), user.getAge()))
      .collect(Collectors.toList());

    return users_entity;
  }

  @Override
  public Optional<UserEntity> find_one_user_by_id(UUID id) {
    Optional<UserEntityJpa> user_entity_jpa = this.find_by_id(id);
    return user_entity_jpa.map(this::transform_to_user_entity);
  }

  @Override
  public UserEntity create_one_user(UserEntity user) {

    UserEntityJpa user_entity_jpa = new UserEntityJpa(
      user.get_id(),
      user.get_name(),
      user.get_age()
    );

    user_entity_jpa = this.save(user_entity_jpa);
    user.set_id(user_entity_jpa.getId());
    user.set_name(user_entity_jpa.getName());
    user.set_age(user_entity_jpa.getAge());
    
    System.out.println("Pase por aqui");
    return user;
  }

  // @section method's class

  private UserEntityJpa save(UserEntityJpa user_entity_jpa){
    return this.user_repository_jpa.save(user_entity_jpa);
  }

  private List<UserEntityJpa> find_all(){
    return this.user_repository_jpa.findAll();
  }

  private Optional<UserEntityJpa> find_by_id(UUID id){
    return this.user_repository_jpa.findById(id);
  }

  private UserEntity transform_to_user_entity(UserEntityJpa user){
    return new UserEntity(user.getId(), user.getName(), user.getAge());
  }
}
