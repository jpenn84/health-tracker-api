package com.joshualeepenn.healthtracker.tests.integration;

import com.joshualeepenn.healthtracker.model.AppUser;
import com.joshualeepenn.healthtracker.repository.UserRepository;
import com.joshualeepenn.healthtracker.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserIntegrationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    AppUser user1 = new AppUser( 1L, "user1", "Una Europa", ZoneId.of("Europe/Berlin"));
    AppUser user2 = new AppUser(2L, "user2", "Dos America", ZoneId.of("America/New_York"));
    AppUser user3 = new AppUser(3L, "user3", "Tria Asia", ZoneId.of("Asia/Kathmandu"));

    @Test
    public void getAllUsers_success() throws Exception {
        List<AppUser> users = List.of(user1, user2, user3);
        for (AppUser user : users ) {
            Mockito.when(userRepository.saveAndFlush(user)).thenReturn(user);
            AppUser savedUser = userService.createUser(user);
            Assertions.assertEquals(savedUser, user);
        }
    }
}
