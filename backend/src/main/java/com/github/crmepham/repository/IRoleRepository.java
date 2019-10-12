package com.github.crmepham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.crmepham.model.Role;

/**
 * A simple JPA repository to provide CRUD access to the {@link Role} entity.
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
