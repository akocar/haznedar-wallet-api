package me.haznedar.wallet.user.service;

import me.haznedar.wallet.user.dao.UserRepository;
import me.haznedar.wallet.user.entity.User;
import me.haznedar.wallet.user.exception.UserNotFoundException;
import me.haznedar.wallet.user.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UserNotFoundException("User not found with email - " + email);
        }
        return new CustomUserDetails(user);
    }
}
