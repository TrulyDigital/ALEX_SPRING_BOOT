// @imports packages
package com.trulydigital.MsUser.domain.repositories;
// @imports libraries
import java.util.List;
import java.util.Optional;
import java.util.UUID;
// @imports internal
import com.trulydigital.MsUser.domain.entities.UserEntity;

public interface UserRepository{
  List<UserEntity> find_all_users();
  Optional<UserEntity> find_one_user_by_id(UUID id);
  UserEntity create_one_user(UserEntity user);
}
