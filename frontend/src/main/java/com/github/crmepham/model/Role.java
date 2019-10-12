package com.github.crmepham.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Encapsulates a user role. A user role may have many roles.
 * Roles are used to restrict access of features to certain users.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements GrantedAuthority {
    private String name;
    private Collection<User> users;
    private Collection<Privilege> privileges;

    @Override
    public String getAuthority() {
        return name;
    }
}
