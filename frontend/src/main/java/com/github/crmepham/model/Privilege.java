package com.github.crmepham.model;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Encapsulates a single user role privilege. There
 * may be multiple privileges per user role.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
class Privilege extends BaseEntity {
    private String name;
    private Collection<Role> roles;
}
