package me.haznedar.wallet.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.haznedar.wallet.user.exception.UserNotFoundException;
import me.haznedar.wallet.user.dao.UserRepository;
import me.haznedar.wallet.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    // Final because Lombok looks any field marked as final to include in the constructor generated.
    private final UserRepository userRepository;

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        /*
         findMyId(int id) method returns Optional object. So I cannot just put the int id directly
         into the method
         */
        Optional<User> optionalUser = userRepository.findById(id);

        User theUser = null;

        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found with id " + id);
        }
        else {
            theUser = optionalUser.get();
        }
        return theUser;

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public String deleteById(long id) {
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id - " + id);
        }
        userRepository.deleteById(id);
        return "Deleted user with id - " + id;
    }
}
