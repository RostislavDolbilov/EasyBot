package com.spring.springboot.controller;

import com.spring.springboot.entity.UserEntity;
import com.spring.springboot.exeption.UserAlreadyExistException;
import com.spring.springboot.exeption.UserNotFoundException;
import com.spring.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//@Hidden
@Tag(name="UserController", description="Creation of new user, updating and getting")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @Operation( summary = "Creation a new user",
                description = "Creation a new user")
    public ResponseEntity<String> registration(@RequestBody @Parameter(description = "Header with user body") UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("User added");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get_user")
    @Operation( summary = "Getting user by ID",
                description = "Getting user by ID)")
    public ResponseEntity getUser(@RequestParam @Parameter(description = "User ID") Long id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete_user")
    @Operation( summary = "Deleting use by ID",
                description = "Deleting user by ID)")
    public ResponseEntity deleteUser(@RequestParam @Parameter(description = "User ID") Long id) {
        try {
            return ResponseEntity.ok("User with id "+ userService.delete(id) + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
