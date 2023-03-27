package com.flexivebackend.Flexive.Service;

import com.flexivebackend.Flexive.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUsers();

    public User getUser(int id);

    public ResponseEntity<?> updateWallet(int id, Map<Object,Object> fields);

    public boolean validateUser(User user);
}
