package suren.foodordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import suren.foodordering.exception.UserNotFoundException;
import suren.foodordering.model.UserReg;
import suren.foodordering.repository.UserRegRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegController
{
    @Autowired
    private UserRegRepo userRegRepo;

    @PostMapping("/user")
    public UserReg newUser(@RequestBody UserReg newUser){
        System.out.println(newUser.getName());
        UserReg savedUser = userRegRepo.save(newUser);
        if(savedUser != null) {
            System.out.println("User saved successfully: " + savedUser);
        } else {
            System.err.println("Failed to save user: " + newUser);
        }
        return savedUser;
    }

    @GetMapping("/users")
    public List<UserReg> getAllUsers(){
        return userRegRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public UserReg getUserById(@PathVariable Long id){
        return userRegRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


}
