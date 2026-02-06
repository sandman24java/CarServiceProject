package org.example.module3.layered.service.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.module3.layered.dto.auth.dto.RegisterRequestDto;
import org.example.module3.layered.exception.AuthErrorEnum;
import org.example.module3.layered.exception.AuthException;
import org.example.module3.layered.model.AppUserEntity;
import org.example.module3.layered.model.RoleEntity;
import org.example.module3.layered.repository.auth.repository.RoleRepository;
import org.example.module3.layered.repository.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    @Transactional
    public void register(RegisterRequestDto req) {

        if (userRepo.findByUsername(req.username()).isPresent()) {
            throw new AuthException(AuthErrorEnum.USERNAME_EXISTS);
        }

        RoleEntity userRole = roleRepo.findByName("USER").orElseThrow();

        AppUserEntity user = new AppUserEntity();
        user.setUsername(req.username());
        user.setFullName(req.fullName());
        user.setEmail(req.email());

        user.setPasswordHash(encoder.encode(req.password()));
        user.setIsActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setRoleEntities(Set.of(userRole));
        userRepo.save(user);
    }
}
