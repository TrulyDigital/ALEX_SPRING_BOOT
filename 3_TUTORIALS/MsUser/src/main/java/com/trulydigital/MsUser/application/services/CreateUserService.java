// @imports package
package com.trulydigital.MsUser.application.services;
// @imports libraries
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.github.f4b6a3.uuid.UuidCreator;
// @imports internal
import com.trulydigital.MsUser.application.dtos.InUserDto;
import com.trulydigital.MsUser.application.dtos.OutUserDto;
import com.trulydigital.MsUser.application.dtos.UserDto;
import com.trulydigital.MsUser.domain.entities.UserEntity;
import com.trulydigital.MsUser.domain.repositories.UserRepository;

@Service
public class CreateUserService {

  // @section properties

  private final UserRepository user_repository;

  // @section constructors

  public CreateUserService(
    UserRepository user_repository
  ){
    this.user_repository = user_repository;
  }
  
  // @section methods
  
  public OutUserDto create_user(
    InUserDto body_in
  ){
    
    UserEntity user_entity = new UserEntity(
      UuidCreator.getTimeOrderedEpoch(), // v7
      body_in.get_name(),
      body_in.get_age()
    );
    user_entity = this.user_repository.create_one_user(user_entity);

    UserDto user_dto = new UserDto(
      user_entity.get_id(),
      user_entity.get_name(),
      user_entity.get_age()
    );
    List<UserDto> users_dto = new ArrayList<>();
    users_dto.add(user_dto);

    OutUserDto out_user_dto = new OutUserDto(
      UuidCreator.getRandomBased(),
      "success",
      201,
      "User created successfully",
      users_dto
    );

    return out_user_dto;
  }
}
