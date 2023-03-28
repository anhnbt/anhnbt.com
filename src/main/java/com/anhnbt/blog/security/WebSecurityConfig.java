package com.anhnbt.blog.security;

import com.anhnbt.blog.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
                        .antMatchers("/",
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
                                "/nicknames",
                                "/p/**").permitAll()
                        .mvcMatchers(
                                "/assets/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/uploads/**",
                                "/ads.txt",
                                "/robots.txt",
                                "/favicon.ico",
                                "/favicon-32x32.png").permitAll()
                        .mvcMatchers("/admin/**").hasRole("ADMIN")
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