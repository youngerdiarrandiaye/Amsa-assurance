package net.momodev.roleservice.web;

import net.momodev.roleservice.entity.RolesEntity;
import net.momodev.roleservice.repository.RolesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesController {
    private RolesRepository rolesRepository;

    public RolesController(RolesRepository rolesRepository) {

        this.rolesRepository = rolesRepository;
    }
    @GetMapping("/roles")
    public List<RolesEntity> roles(){
        return rolesRepository.findAll();
    }
    @GetMapping("/roles/{id}")
    public RolesEntity roleById(@PathVariable Long id ){

        return  rolesRepository.findById(id).get();
    }

}
