package com.github.crmepham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.crmepham.model.User;

/**
 * A simple JPA repository to provide CRUD access to the {@link User} entity.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String usernam);
}
