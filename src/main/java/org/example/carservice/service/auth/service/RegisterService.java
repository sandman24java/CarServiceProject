package org.example.carservice.service.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.carservice.dto.auth.dto.RegisterRequestDto;
import org.example.carservice.exception.AuthErrorEnum;
import org.example.carservice.exception.AuthException;
import org.example.carservice.model.AppUserEntity;
import org.example.carservice.model.RoleEntity;
import org.example.carservice.repository.auth.repository.RoleRepository;
import org.example.carservice.repository.auth.repository.UserRepository;
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
