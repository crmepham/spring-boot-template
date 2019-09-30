package com.github.crmepham.controller;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.crmepham.model.BaseEntity;
import com.google.gson.Gson;
import lombok.val;

public abstract class GenericController<T, ID extends Serializable> {

    static Gson GSON = new Gson();

    JpaRepository<T, ID> r;

    public GenericController(JpaRepository<T, ID> r) {
        this.r = r;
    }

    T create(T o) {
        return r.save(o);
    }

    T update(T o) {
        if (((BaseEntity)o).getId() > 0) {
            return r.save(o);
        } else {
            return null;
        }
    }

    @GetMapping("{id}")
    T get(@PathVariable ID id) {
        val opt = r.findById(id);
        return opt.orElse(null);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable ID id) {
        val opt = r.findById(id);
        if (opt.isPresent()) {
            r.deleteById(id);
        }
    }
}
