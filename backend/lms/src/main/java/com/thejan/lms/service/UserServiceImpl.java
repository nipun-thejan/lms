package com.thejan.lms.service;


import com.thejan.lms.entity.User;
import com.thejan.lms.entity.UserFactory;
import com.thejan.lms.exception.EntityNotFoundException;
import com.thejan.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserFactory userFactory;

    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("No user found with "+id)
        );
        return userFactory.getInstance(user);
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No user found with "+email)
        );
        return userFactory.getInstance(user);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }

}
