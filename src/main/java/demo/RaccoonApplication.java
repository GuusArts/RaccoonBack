package demo;

import demo.Domain.Role;
import demo.Domain.User;
import demo.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
@SpringBootApplication
@EnableWebSecurity
public class RaccoonApplication {

	public static void main(String[] args) {
        SpringApplication.run(RaccoonApplication.class, args);
        // Creating a Mongo client
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_USER"));

            userService.saveUser(new User(null, "Guus Arts", "Guus", "0000", new ArrayList<>()));
            userService.saveUser(new User(null, "Tijn de Rooij", "Tijn", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Pieter Soeren", "Pieter", "1234", new ArrayList<>()));


            userService.addRoleToUser("Guus", "ROLE_ADMIN");
            userService.addRoleToUser("Tijn", "ROLE_USER");
            userService.addRoleToUser("Pieter", "ROLE_USER");
        };

    }


}




