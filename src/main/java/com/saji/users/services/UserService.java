package com.saji.users.services;

import com.saji.stocks.constants.LogicalDelIn;
import com.saji.users.entities.User;
import com.saji.users.pojo.UserPojo;
import com.saji.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(UserPojo userPojo) {
        User user = new User();
        typeCast(user, userPojo);
        userRepository.saveAndFlush(user);
    }

    public void updateUser(UserPojo userPojo, BigInteger id) {
        userRepository.findById(id).ifPresent(user -> {
            typeCast(user, userPojo);
            userRepository.saveAndFlush(user);
        });
    }

    public UserPojo findUser(BigInteger id) {
        Optional<User> userOptional = userRepository.findById(id);
        UserPojo pojo = new UserPojo();
        userOptional.ifPresent(val ->
                typeCast(pojo, val));
        return pojo;
    }

    public void deleteUser(BigInteger id) {

        userRepository.deleteById(id);
    }

    public List<UserPojo> listUsers() {
        return userRepository.findAll().stream().map(val -> {
            UserPojo pojo = new UserPojo();
            typeCast(pojo, val);
            return pojo;
        }).toList();
    }

    private void typeCast(User user, UserPojo userPojo) {

        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setPhoneNumber(userPojo.getPhoneNumber());
        user.setPin(userPojo.getPin());
        user.setTpin(userPojo.getTpin());
        user.setId(userPojo.getId());
        user.setName(userPojo.getName());
        user.setLogicalDelIn(LogicalDelIn.N.label);
    }

    private void typeCast(UserPojo userPojo, User user) {

        userPojo.setEmail(user.getEmail());
        userPojo.setPassword(user.getPassword());
        userPojo.setPhoneNumber(user.getPhoneNumber());
        userPojo.setPin(user.getPin());
        userPojo.setTpin(user.getTpin());
        userPojo.setId(user.getId());
        userPojo.setName(user.getName());
        userPojo.setLogicalDelIn(user.getLogicalDelIn());
    }

    public UserPojo findUser(String name) {
        Optional<User> userOptional = userRepository.findByUserId(name);
        UserPojo pojo = new UserPojo();
        if (userOptional.isPresent()) {
            typeCast(pojo, userOptional.get());
        }
        return pojo;
    }
}
