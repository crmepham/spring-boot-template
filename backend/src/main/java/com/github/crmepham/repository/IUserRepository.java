package com.github.crmepham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.crmepham.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String usernam);
}
