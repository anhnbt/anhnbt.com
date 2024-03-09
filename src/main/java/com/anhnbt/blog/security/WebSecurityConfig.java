package com.anhnbt.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/",
                                "/search",
                                "/signup",
                                "/ky-tu-dac-biet",
                                "/chu-kieu",
                                "/ten-game-hay",
                                "/chu-in-dam",
                                "/ki-tu-dac-biet-chu-nho",
                                "/tao-chu-i-am",
                                "/ki-tu-qua-tao",
                                "/ki-tu-vuong-mien",
                                "/ki-tu-tang-hinh",
                                "/ki-tu-khoang-trong-ff",
                                "/ki-tu-trai-tim",
                                "/nicknames",
                                "/p/**",
                                "/apps/**",
                                "/ki-tu/**",
                                "/sao-chep-ky-tu-dac-biet",
                                "/assets/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/uploads/**",
                                "/ads.txt",
                                "/robots.txt",
                                "/sitemap.xml",
                                "/favicon.ico",
                                "/favicon-32x32.png").permitAll()
                        .requestMatchers(antMatcher("/admin/**")).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                );

        return http.build();
    }
}