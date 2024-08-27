package net.momodev.userservice;

import net.momodev.userservice.entity.UserEntity;
import net.momodev.userservice.models.RolesEntity;
import net.momodev.userservice.repository.UserRepository;
import net.momodev.userservice.web.RoleRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRestClient roleRestClient) {
        return args -> {
            // Fetch all roles
            List<RolesEntity> roles = roleRestClient.allRolesEntity();

            // Manually assign roles to users by their IDs
            // Ensure roles list contains at least the required number of roles
            if (roles.size() >= 2) {
                RolesEntity role1 = roles.get(0); // Assuming this role is for user1
                RolesEntity role2 = roles.get(1); // Assuming this role is for user2

                // Create user1 with role1
                UserEntity user1 = UserEntity.builder()
                        .nom("younous")
                        .prenom("diop")
                        .email("younous@gmail.com")
                        .password(new BCryptPasswordEncoder().encode("passer@1"))
                        .rolesEntityId(role1.getId()) // Assign role1's ID
                        .build();

                // Create user2 with role2
                UserEntity user2 = UserEntity.builder()
                        .nom("momo")
                        .prenom("diop")
                        .email("momo@gmail.com")
                        .password(new BCryptPasswordEncoder().encode("passer@1"))
                        .rolesEntityId(role2.getId()) // Assign role2's ID
                        .build();

                // Save users to the database
                userRepository.save(user1);
                userRepository.save(user2);
            } else {
                throw new IllegalStateException("Not enough roles to assign to users");
            }
        };

//        return args -> {
//            roleRestClient.allRolesEntity().forEach(c -> {
//                UserEntity user1 = UserEntity.builder()
//                          .nom("younous")
//                          .prenom("diop")
//                          .email("younous@gmail.com")
//                          .password("passer@1")
//                        .rolesEntityId(c.getId())
//                        .build();
//                UserEntity user2 = UserEntity.builder()
//                        .nom("momo")
//                        .prenom("diop")
//                        .email("momo@gmail.com")
//                        .password("passer@1")
//                        .rolesEntityId(c.getId())
//                        .build();
//                userRepository.save(user1);
//                userRepository.save(user2);
//
//            });
//
//        };


    }

}