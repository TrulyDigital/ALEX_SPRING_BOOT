// @imports packages
package com.trulydigital.MsUser.infraestructure.repositories;
// @imports libraries
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
// @imports internal
import com.trulydigital.MsUser.infraestructure.entities.UserEntityJpa;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntityJpa, UUID>{
}
