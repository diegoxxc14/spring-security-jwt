package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.models.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    
}
