package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.HelmetApplicationTests;
import com.hustar.smarthelmet.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryTest extends HelmetApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();

        user.setAccount("maple123");
        user.setPassword("nxon131");
        user.setName("james");

        User newUser = userRepository.save(user);
    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            System.out.println(selectUser.getName());
            System.out.println((selectUser.getAccount()));
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setName("서영준");
            selectUser.setAccount("abcd123");
            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
    }

}
