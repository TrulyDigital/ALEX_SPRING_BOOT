// @imports packages
package com.trulydigital.MsUser.application.services;
// @imports libraries
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.github.f4b6a3.uuid.UuidCreator;
// @imports internal
import com.trulydigital.MsUser.application.dtos.OutUserDto;
import com.trulydigital.MsUser.application.dtos.UserDto;
import com.trulydigital.MsUser.domain.entities.UserEntity;
import com.trulydigital.MsUser.domain.repositories.UserRepository;

@Service
public class FindAllUsersService {

  // @section properties

  private final UserRepository user_repository;

  // @section constructors

  public FindAllUsersService(
    UserRepository user_repository
  ){
    this.user_repository = user_repository;
  }

  // @section methods

  public OutUserDto find_all_users(){

    List<UserEntity> users = this.user_repository.find_all_users();

    List<UserDto> users_dto = users
      .stream()
      .map(user -> new UserDto(user.get_id(), user.get_name(), user.get_age()))
      .collect(Collectors.toList());

    OutUserDto out_user_dto = new OutUserDto(
      UuidCreator.getRandomBased(),
      "success",
      200,
      "Query all users",
      users_dto
    );

    return out_user_dto;
  }
  
}
