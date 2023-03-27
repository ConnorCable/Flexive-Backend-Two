package com.flexivebackend.Flexive.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexivebackend.Flexive.Model.User;
import com.flexivebackend.Flexive.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    private ObjectMapper objectMapper;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(int id){
        Optional<User> userResponse = userRepo.findById(id);
        User user = userResponse.get();
        return user;
    }

    @Override
    public ResponseEntity<User> updateWallet(int id, Map<Object, Object> fields){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            fields.forEach((key,value) -> {
                Field field = ReflectionUtils.findField(User.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, user.get(), value);
            });

        }
        User updatedWallet = saveUser(user.get());
        return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
    }

    public boolean validateUser(User user){
       Optional<User> check =  userRepo.findByUsername(user.getUsername());

       return check.isPresent();
    }

}
