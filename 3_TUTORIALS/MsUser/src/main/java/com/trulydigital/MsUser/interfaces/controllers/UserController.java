// @imports packages
package com.trulydigital.MsUser.interfaces.controllers;
// @imports libraries
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
// @imports internal
import com.trulydigital.MsUser.application.dtos.InUserDto;
import com.trulydigital.MsUser.application.dtos.OutUserDto;
import com.trulydigital.MsUser.application.services.CreateUserService;
import com.trulydigital.MsUser.application.services.FindAllUsersService;
import com.trulydigital.MsUser.application.services.FindOneUserByIdService;

@RestController
@RequestMapping("${application.basepath}") 
public class UserController {

  // @section properties

  private final CreateUserService create_user_service;
  private final FindAllUsersService find_all_users_service;
  private final FindOneUserByIdService find_one_user_by_id_service;

  // @section constructors

  public UserController(
    CreateUserService create_user_service,
    FindAllUsersService find_all_users_service,
    FindOneUserByIdService find_one_user_by_id_service
  ){
    this.create_user_service = create_user_service;
    this.find_all_users_service = find_all_users_service;
    this.find_one_user_by_id_service = find_one_user_by_id_service;
  }

  // @section handling routes

  @GetMapping("${application.operation.find.user.by.id}")
  public ResponseEntity<OutUserDto> find_one_user_by_id(
    @RequestParam UUID id
  ){
    System.out.println(id);
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(this.find_one_user_by_id_service.find_one_user_by_id(id));
  }

  @GetMapping("${application.operation.find.user}")
  public ResponseEntity<OutUserDto> find_all_users(){
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(this.find_all_users_service.find_all_users());
  }

  @PostMapping("${application.operation.create.user}")
  public ResponseEntity<OutUserDto> create_user(
    @Valid @RequestBody InUserDto body_in
  ){
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(this.create_user_service.create_user(body_in));
  }
}
