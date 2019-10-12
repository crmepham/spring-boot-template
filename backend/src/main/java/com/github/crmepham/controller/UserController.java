package com.github.crmepham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.crmepham.model.User;
import com.github.crmepham.repository.IUserRepository;

/**
 * A RESTful controller that serves requests related to a {@link User}.
 */
@RestController
@RequestMapping("user")
public class UserController extends GenericController<User, Long> {

    @Autowired
    private IUserRepository userRepository;

    public UserController(final JpaRepository<User, Long> r) {
        super(r);
    }

    @GetMapping("get-by-username/{username}")
    public User getByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping
    public User create(@RequestBody String payload) {
        return create(getGSON().fromJson(payload, User.class));
    }

    @PutMapping
    public User update(@RequestBody String payload) {
        return update(getGSON().fromJson(payload, User.class));
    }
}
