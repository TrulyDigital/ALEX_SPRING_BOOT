// @imports packages
package com.trulydigital.MsUser.infraestructure.services;
// @imports libraries
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;
// @imports internal
import com.trulydigital.MsUser.infraestructure.entities.UserEntityJpa;
import com.trulydigital.MsUser.infraestructure.repositories.UserRepositoryJpa;

@Component
@Profile("test") // profile
@Primary
public class MockUserJpaImpl implements UserRepositoryJpa {

  // @section properties

  private final Map<UUID, UserEntityJpa> storage = new HashMap<>();

  // @section methods implemented that we need.

  @Override
  public List<UserEntityJpa> findAll() {
    // TODO Auto-generated method stub
    return new ArrayList<>(storage.values());
  }

  @Override
  public Optional<UserEntityJpa> findById(UUID id) {
    // TODO Auto-generated method stub
    return Optional.ofNullable(storage.get(id));
  }

  /**
   * 
   * UserRepositoryJpa interface extends JpaRepository<UserEntityJpa, UUID>, which
   * in turn inherits from CrudRepository<T ID> (generics)
   * 
   * The save() method in JpaRepository has a generic signature
   * 
   * We need extend of UserEntityJpa
   * 
   */
  @Override
  public <S extends UserEntityJpa>S save(S entity) {
    // TODO Auto-generated method stub
    storage.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public void deleteById(UUID id) {
    // TODO Auto-generated method stub
    storage.remove(id);
  }

  // @section methods no implemented for nothing to do

  @Override
  public void delete(UserEntityJpa entity) {
    // TODO Auto-generated method stub
    storage.remove(entity.getId());
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    storage.clear();
  }

  @Override
  public boolean existsById(UUID id) {
    return storage.containsKey(id);
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'flush'");
  }

  @Override
  public <S extends UserEntityJpa> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
  }

  @Override
  public <S extends UserEntityJpa> List<S> saveAllAndFlush(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
  }

  @Override
  public void deleteAllInBatch(Iterable<UserEntityJpa> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<UUID> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public UserEntityJpa getOne(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
  }

  @Override
  public UserEntityJpa getById(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public UserEntityJpa getReferenceById(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
  }

  @Override
  public <S extends UserEntityJpa> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends UserEntityJpa> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends UserEntityJpa> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
  }

  @Override
  public List<UserEntityJpa> findAllById(Iterable<UUID> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public void deleteAllById(Iterable<? extends UUID> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
  }

  @Override
  public void deleteAll(Iterable<? extends UserEntityJpa> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public List<UserEntityJpa> findAll(Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public Page<UserEntityJpa> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends UserEntityJpa> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
  }

  @Override
  public <S extends UserEntityJpa> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends UserEntityJpa> long count(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public <S extends UserEntityJpa> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
  }

  @Override
  public <S extends UserEntityJpa, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
  }
}
