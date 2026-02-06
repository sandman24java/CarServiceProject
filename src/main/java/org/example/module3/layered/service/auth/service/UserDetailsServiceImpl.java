package org.example.module3.layered.service.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.module3.layered.exception.AuthErrorEnum;
import org.example.module3.layered.exception.AuthException;
import org.example.module3.layered.model.AppUserEntity;
import org.example.module3.layered.repository.auth.repository.UserRepository;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        AppUserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AuthException(AuthErrorEnum.USER_NOT_EXISTS));

        if (!user.getIsActive()) {
            throw new DisabledException("User inactive");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        // Roles
        user.getRoleEntities().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

            // Permissions
            role.getPermissionEntities().forEach(permission -> {
                authorities.add(new SimpleGrantedAuthority(permission.getPermissionCode())
                );
            });
        });

        return new User(user.getUsername(), user.getPasswordHash(), authorities);
    }
}
