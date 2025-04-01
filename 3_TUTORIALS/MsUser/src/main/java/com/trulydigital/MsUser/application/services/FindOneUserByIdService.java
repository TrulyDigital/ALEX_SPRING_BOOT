// @imports packages
package com.trulydigital.MsUser.application.services;
// @imports libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.github.f4b6a3.uuid.UuidCreator;
// @imports internal
import com.trulydigital.MsUser.application.dtos.OutUserDto;
import com.trulydigital.MsUser.application.dtos.UserDto;
import com.trulydigital.MsUser.domain.entities.UserEntity;
import com.trulydigital.MsUser.domain.repositories.UserRepository;

@Service
public class FindOneUserByIdService {
  
  // @section properties

  private final UserRepository user_repository;

  // @section constructors

  public FindOneUserByIdService(
    UserRepository user_repository
  ){
    this.user_repository = user_repository;
  }

  // @section methods

  public OutUserDto find_one_user_by_id(
    UUID id
  ){
    Optional<UserEntity> user_entity = this.user_repository.find_one_user_by_id(id);
    List<UserDto> users_dto = new ArrayList<>();

    if(user_entity.isPresent()){
      UserEntity user = user_entity.get();
      users_dto.add(
        new UserDto(
          user.get_id(), 
          user.get_name(), 
          user.get_age()
        )
      );
    }

    OutUserDto out_user_dto = new OutUserDto(
      UuidCreator.getRandomBased(),
      "success",
      200,
      "Query One User By Id",
      users_dto
    );

    return out_user_dto;
  }

}
