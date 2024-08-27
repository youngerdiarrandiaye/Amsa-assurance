package net.momodev.userservice.web;

import net.momodev.userservice.entity.UserEntity;
import net.momodev.userservice.models.RolesEntity;
import net.momodev.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    private UserRepository userRepository;
    private RoleRestClient roleRestClient;

    public UserController(UserRepository userRepository, RoleRestClient roleRestClient) {
        this.userRepository = userRepository;
        this.roleRestClient = roleRestClient;
    }
//    @GetMapping("/users")
//    public List<UserEntity> userList() {
//        return userRepository.findAll();
//    }
    @GetMapping("/users")
    public List<UserEntity> userEntityList(){
        List<UserEntity> userEntityList = userRepository.findAll();
        userEntityList.forEach(acc->{
            acc.setRolesEntity(roleRestClient.findRolesEntityById(acc.getRolesEntityId()));
        });
        return userEntityList;
    }
    @GetMapping("/users/{id}")
    public  UserEntity userEntityById(@PathVariable Long id ){
        UserEntity userEntity=  userRepository.findById(id).get();
        RolesEntity role=roleRestClient.findRolesEntityById(userEntity.getRolesEntityId());
        userEntity.setRolesEntity(role);
        return userEntity;

    }

//    @GetMapping("/users/{id}")
//    public UserEntity userById(@PathVariable Long id ){
//        return  userRepository.findById(id).get();
//    }
}
