package net.momodev.roleservice;

import net.momodev.roleservice.entity.RolesEntity;
import net.momodev.roleservice.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RoleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(RolesRepository rolesRepository ) {
        return args -> {
            List<RolesEntity> roleEntityList =List.of(
                    RolesEntity.builder()
                            .nom("Superviseur")
                            .build(),
                    RolesEntity.builder()
                            .nom("Admin")
                            .build()
            );
            rolesRepository.saveAll(roleEntityList);
        };
    }
}
