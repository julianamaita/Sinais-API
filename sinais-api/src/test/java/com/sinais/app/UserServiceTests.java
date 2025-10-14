package com.sinais.app;

import com.sinais.app.service.UserService;
import com.sinais.app.repository.UserRepository;
import com.sinais.app.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class UserServiceTests {

    @Test
    void registerHashesPasswordAndSaves() {
        var repo = Mockito.mock(UserRepository.class);
        var svc = new UserService(repo, new BCryptPasswordEncoder());
        Mockito.when(repo.existsByEmail("a@b.com")).thenReturn(false);
        Mockito.when(repo.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        var u = svc.register("a@b.com", "123", "Alice");
        assertEquals("a@b.com", u.getEmail());
        assertNotEquals("123", u.getPasswordHash());
        assertTrue(new BCryptPasswordEncoder().matches("123", u.getPasswordHash()));
    }
}
