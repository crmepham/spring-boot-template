package com.github.crmepham.model;

import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class Privilege extends BaseEntity {
    private String name;
    private Collection<Role> roles;
}
