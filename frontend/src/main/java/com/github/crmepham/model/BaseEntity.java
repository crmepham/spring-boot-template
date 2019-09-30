package com.github.crmepham.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity implements Serializable {
    private long id;
    private Date created;
    private Date lastUpdated;
}