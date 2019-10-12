package com.github.crmepham;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.crmepham.model.Role;
import com.github.crmepham.model.User;
import com.github.crmepham.repository.IPrivilegeRepository;
import com.github.crmepham.repository.IRoleRepository;
import com.github.crmepham.repository.IUserRepository;
import lombok.val;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IPrivilegeRepository privilegeRepository;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("username");
        user.setPassword("password");

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("role_admin"));
        user.setRoles(roles);
    }

    @Test
    public void testUserCrud() {
        assertThat(userRepository.findAll().size()).isEqualTo(1); // Already a single user 'admin' with role 'ROLE_ADMIN' and 2 privileges. Setup by flyway script.

        var result = userRepository.findByUsername("admin");
        assertThat(result).isNotNull();
        userRepository.delete(result);

        assertThat(userRepository.findAll()).isEmpty();

        userRepository.save(user);

        assertThat(userRepository.findByUsername("invalid")).isNull();
        assertThat(userRepository.findAll().size()).isEqualTo(1);

        result = userRepository.findByUsername("username");
        assertThat(result).isNotNull();
        assertThat(result.getRoles().size()).isEqualTo(1);
        assertThat(result.getRoles().iterator().next().getPrivileges().size()).isEqualTo(2);

        result.getRoles().iterator().next().getPrivileges().removeIf(p -> p.getName().equals("privilege_read"));
        userRepository.save(result);

        val updated = userRepository.findByUsername("username");
        assertThat(updated.getRoles().iterator().next().getPrivileges().size()).isEqualTo(1);

        assertThat(privilegeRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    public void testRoleRepository() {
        val results = roleRepository.findAll();
        assertThat(results.size()).isEqualTo(2);
    }
}
