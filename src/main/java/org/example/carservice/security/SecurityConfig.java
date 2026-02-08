package org.example.carservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {

        http
//        CSRF (disable): Мы отключаем защиту от межсайтовой подделки запросов.
//        В приложениях с JWT она обычно не нужна, так как токены не хранятся в куках автоматически.
//
//                STATELESS: Это самое важное. Мы говорим Spring Security: "Не создавай сессии на сервере.
//                Я не буду хранить состояние пользователя. Каждый запрос должен приходить с токеном".
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagementConfigurer ->
                        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        permitAll(): Эти эндпоинты открыты для всех.
//        Логично, ведь чтобы войти или зарегистрироваться, у пользователя еще нет токена.
//
//        anyRequest().authenticated(): Все остальные пути в твоем приложении будут требовать валидный JWT.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/login",
                                "/auth/register",
                                "/auth/refresh"
                        ).permitAll()

                        // Everything else secured
                        .anyRequest().authenticated()
                )

// Убираем форму входа (которая в браузере) и Basic Auth (логин:пароль в заголовке),
                // так как у нас свой кастомный механизм на JWT.
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);

// Вставляем наш JwtFilter ПЕРЕД стандартным фильтром проверки логина/пароля.
        // Это значит: сначала проверяем токен в заголовке. Если он валиден — пропускаем дальше.
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    // МЕНЕДЖЕР АУТЕНТИФИКАЦИИ
    // Создаем бин для управления проверкой учетных данных.
    // Он пригодится в контроллере для метода login, чтобы проверить пароль.
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }


    // КОДИРОВЩИК ПАРОЛЕЙ
    // Используем BCrypt — это стандарт индустрии.
    // Он автоматически добавляет соль и делает хеширование надежным.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
