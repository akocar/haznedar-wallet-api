package me.haznedar.wallet.user.rest;

import lombok.RequiredArgsConstructor;
import me.haznedar.wallet.user.entity.User;
import me.haznedar.wallet.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

    // Final because Lombok looks any field marked as final to include in the constructor generated.
    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.listAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public User addUser(User user) {
        user.setId(0);
        User dbUser = userService.save(user);
        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(User user) {
        User dbUser = userService.save(user);
        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteById(id);
    }


}
