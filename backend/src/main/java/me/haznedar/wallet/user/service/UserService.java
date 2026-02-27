package me.haznedar.wallet.user.service;

import me.haznedar.wallet.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAll();
    User findById(long id);
    User findByEmail(String email);
    User save(User user);
    String deleteById(long id);

}
