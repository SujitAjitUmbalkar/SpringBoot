package com.codingshuttle.SecurityApp.SecurityApplication.services;

import com.codingshuttle.SecurityApp.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException( "user with "+ username+" not found."));
    }
}

/*
1. When there is **no implementation of `UserDetailsService`**,
 Spring Boot automatically configures default authentication,
 2. Spring Security creates an `InMemoryUserDetailsManager`,
  3. a default user (`username = user`) with a randomly generated password is created,
  4. the generated password is printed in the console at application startup,
   5. authentication uses this **in-memory user instead of loading users from a database**.
6. if you have wrote properties , then passoword will be used but not printed on console
 */
