package com.github.crmepham.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.val;

/**
 * Contains basic, shared functionality that most respository
 * implementations will use.
 */
@Getter
public abstract class BaseRepository {

    private static final Gson GSON = new Gson();

    public BaseRepository() {}

    HttpEntity getEntity() {
        return new HttpEntity<>(null, new HttpHeaders());
    }

    protected HttpEntity postEntity(Object instance) {
        val headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(GSON.toJson(instance), headers);
    }
}
