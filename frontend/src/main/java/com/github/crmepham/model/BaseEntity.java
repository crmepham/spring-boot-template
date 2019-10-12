package com.github.crmepham.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Contains shared fields.
 */
@Getter
@Setter
class BaseEntity implements Serializable {
    private long id;
    private Date created;
    private Date lastUpdated;
}