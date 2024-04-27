package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.UserEntity;
import com.apigestion.hoteleria.persistence.Entity.UserRoleEntity;
import com.apigestion.hoteleria.persistence.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository repository;

    public UserSecurityService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.repository.findById(username).orElseThrow(()-> new UsernameNotFoundException("User" + username + "not found"));
        System.out.println(user);

        String[] roles = user.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .accountLocked(user.getLocked())
                .disabled(user.getDisabled())
                .build();
    }
}
