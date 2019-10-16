package com.github.crmepham.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * A user that logins and uses the application.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false, updatable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "account_non_expired", columnDefinition = "bit default 1", nullable = false)
    private boolean accountNonExpired;

    @Column(name = "account_non_locked", columnDefinition = "bit default 1", nullable = false)
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired", columnDefinition = "bit default 1", nullable = false)
    private boolean credentialsNonExpired;

    @Column(name = "enabled", columnDefinition = "bit default 0", nullable = false)
    private boolean enabled;

    @Column(name = "visible", columnDefinition = "bit default 1", nullable = false)
    private boolean visible;

    @JoinTable(
        name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ElementCollection(targetClass = Role.class)
    private Collection<Role> roles;
}
