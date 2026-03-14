package com.codingshuttle.SecurityApp.SecurityApplication.services;

import com.codingshuttle.SecurityApp.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
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

**Why Default Password Is Not Printed (Spring Security)**

1. When Spring Security is added, Spring Boot automatically creates a **default user** (`username = user`) and prints a **random password** in the console.
2. This happens only when **no authentication-related beans** are defined in the project.
3. If a custom `UserDetailsService` bean is created (like `UserService implements UserDetailsService`), Spring Boot assumes the developer will **handle authentication manually**.
4. Because of this, Spring Boot **disables the default user and password generation**.
5. Therefore **no password is printed in the console** when the application starts.
6. Authentication will then use **database users loaded through `UserDetailsService` instead of the default in-memory user**.


 */
