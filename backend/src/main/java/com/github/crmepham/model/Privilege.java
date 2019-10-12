package com.github.crmepham.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false, updatable = false, length = 25)
    private String name;

    @JsonIgnoreProperties("privileges")
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
