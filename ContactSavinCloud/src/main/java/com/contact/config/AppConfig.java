package com.contact.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppConfig {
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").hasRole("USER")
//               .requestMatchers("/**").permitAll()).formLogin(form -> form.loginPage("/cloud/login")
//                .loginProcessingUrl("/login").defaultSuccessUrl("/user/dashboard").failureForwardUrl("/login?error"));

              http.csrf(AbstractHttpConfigurer::disable)
                      .authorizeHttpRequests(a->a.
                              requestMatchers("/user/**").hasRole("USER")
                              .anyRequest().permitAll()
                      ).formLogin(f->f.loginPage("/cloud/login")
                      .loginProcessingUrl("/login")
                                      .defaultSuccessUrl("/user/dashboard"));
//                                      .failureForwardUrl("/login"));



//                http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
//                        auth->
//                auth.requestMatchers("cloud/signup").authenticated().anyRequest().permitAll());
        return http.build();
    }

}