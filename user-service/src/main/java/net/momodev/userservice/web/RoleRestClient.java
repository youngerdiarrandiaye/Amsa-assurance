package net.momodev.userservice.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.momodev.userservice.models.RolesEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "ROLE-SERVICE")
public interface RoleRestClient {
    @GetMapping("/roles/{id}")
    @CircuitBreaker(name = "roleService",fallbackMethod = "getDefaultRole")
    RolesEntity findRolesEntityById(@PathVariable Long id);
    @GetMapping("/roles")
    @CircuitBreaker(name = "roleService",fallbackMethod = "getAllRole")
    List<RolesEntity> allRolesEntity();

    default RolesEntity getDefaultRole(Long id, Exception exception) {
        RolesEntity roles = new RolesEntity();
        roles.setId(id);
        roles.setNom("Not Vailable");
        return  roles;
    }
    default List<RolesEntity>  getAllRole(Long id,Exception exception) {
        return List.of();
    }

}
