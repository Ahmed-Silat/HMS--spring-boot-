package HospitalManagementSystem.HMS.Controller;

import HospitalManagementSystem.HMS.Models.User;
import HospitalManagementSystem.HMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping(value = "/users/save")
    public String createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping(value = "/users/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        return this.userService.deleteUser(id);
    }

}
