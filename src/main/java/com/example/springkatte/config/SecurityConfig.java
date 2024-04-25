package com.example.springkatte.config;

import com.example.springkatte.users.domain.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDAO userDAO;

    public SecurityConfig(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(
                                        new OrRequestMatcher(
                                                new AntPathRequestMatcher("/login"),
                                                new AntPathRequestMatcher("/UserCreation"),
                                                new AntPathRequestMatcher("/**/*.css"),
                                                new AntPathRequestMatcher("/**/*.jpg")
                                        )
                                ).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/LoginPage")
                                .defaultSuccessUrl("/HomeSite")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/LoginPage?logout")
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserDAO userDAO) {
        List<UserDetails> userdetailslist = new ArrayList<>();

        List<com.example.springkatte.users.domain.User> users = userDAO.getAllUsers();


        for (com.example.springkatte.users.domain.User user : users) {
            boolean userExists = false;


            for (UserDetails userDetails : userdetailslist) {
                if (userDetails.getUsername().equals(user.getEmail())) {
                    userExists = true;
                    break;
                }
            }

            if (!userExists) {
                UserDetails userDetails = User.withUsername(user.getEmail())
                        .passwordEncoder(passwordEncoder()::encode)
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build();
                userdetailslist.add(userDetails);

            }
        }


        return new InMemoryUserDetailsManager(userdetailslist);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


 
}