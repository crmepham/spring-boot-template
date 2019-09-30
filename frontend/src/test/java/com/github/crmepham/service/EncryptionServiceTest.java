package com.github.crmepham.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionServiceTest {

    @Test
    public void testBycryptEncoding() {
        String bcrypt = new BCryptPasswordEncoder().encode("admin");
        System.out.println(bcrypt);
    }
}
