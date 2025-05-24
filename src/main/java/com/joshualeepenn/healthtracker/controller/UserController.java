package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.dto.MessageDto;
import com.joshualeepenn.healthtracker.model.AppUser;
import com.joshualeepenn.healthtracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
        AppUser createdAppUser = userService.createUser(appUser);
        return new ResponseEntity<>(createdAppUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        return new ResponseEntity<>(userService.getUserCount(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable long id, @RequestBody AppUser appUser) {
        if (appUser.getId() != id) {
            throw new IllegalArgumentException("User id mismatch");
        }
        return new ResponseEntity<>(userService.updateUser(appUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteUser(@PathVariable long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

}
