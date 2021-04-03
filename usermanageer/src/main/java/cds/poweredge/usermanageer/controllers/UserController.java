package cds.poweredge.usermanageer.controllers;

import javax.validation.Valid;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cds.poweredge.usermanageer.models.User;
import cds.poweredge.usermanageer.services.UserService;
import cds.poweredge.usermanageer.validations.UserValidator;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/findbyname/{name}")
    public List<User> getAllUserByName(
            @PathVariable("name") String userName) {
        return userService.findUsersByName(userName);
    }

    @PostMapping
    public void addUser(@Valid @RequestBody User user ) {
        UserValidator userValidation = new UserValidator();
        userValidation.isValid(user, userService);
        userService.addUser(user);
    }


    @DeleteMapping(path = "{id}")
    public void deleteUser(
        @PathVariable("id")  Long userId) {
                UserValidator userValidation = new UserValidator();
                userValidation.isValidId(userId, userService);
                userService.deleteUser(userId);
    }

    @PutMapping
    public void editUser(@Valid @RequestBody User user ) {
        UserValidator userValidation = new UserValidator();
        userValidation.isValidId(user.getId(), userService);
        userService.updateUser(user);
    }
}
