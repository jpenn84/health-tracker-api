package com.joshualeepenn.healthtracker.service;

import com.joshualeepenn.healthtracker.dto.MessageDto;
import com.joshualeepenn.healthtracker.exceptions.ResourceNotFoundException;
import com.joshualeepenn.healthtracker.exceptions.TransactionException;
import com.joshualeepenn.healthtracker.model.AppUser;
import com.joshualeepenn.healthtracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public AppUser createUser(AppUser appUser) {
        return userRepository.saveAndFlush(appUser);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public long getUserCount() {
        return userRepository.count();
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("User with id '%d' not found", id)));
    }

    public AppUser getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException(String.format("User with username '%s' not found", username)));
    }

    @Transactional
    public AppUser updateUser(AppUser appUser) {
        return userRepository.saveAndFlush(appUser);
    }

    @Transactional
    public MessageDto deleteUser(Long id) {
        AppUser appUser = getUserById(id);

        userRepository.delete(appUser);

        if (!userRepository.existsById(id))
            return MessageDto.success(String.format("deleted user with ID %d", id));
        else throw new TransactionException(String.format("Problem deleting user with ID %d", id));
    }

}
