package com.github.crmepham.repository;

import static org.springframework.http.HttpMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.github.crmepham.model.User;

/**
 * The user repository.
 */
@Repository
public class UserRepository extends BaseRepository {

    private RestTemplate restTemplate;
    private String base;

    @Autowired
    public UserRepository(RestTemplate restTemplate, @Value("${backend.uri}") String base) {
        this.restTemplate = restTemplate;
        this.base = base;
    }

    public User getByUsername(String username) {
        return restTemplate.exchange(base + "user/get-by-username/" + username, GET, getEntity(), User.class).getBody();
    }
}
