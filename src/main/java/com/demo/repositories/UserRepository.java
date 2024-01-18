package com.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
    // La notación requerida
    Optional<UserEntity> findByUsername(String username);

    // Si el método tiene otro nombre, especificamos la query
    @Query("select u from UserEntity u where u.username = ?1")  // Primer parámetro
    Optional<UserEntity> getUsername(String username);
}
