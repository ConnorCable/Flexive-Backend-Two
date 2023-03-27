package com.flexivebackend.Flexive.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.flexivebackend.Flexive.Model.User;
import com.flexivebackend.Flexive.Service.UserService;
import com.flexivebackend.Flexive.Service.UserServiceImpl;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public String add(@RequestBody User user){
        if(userService.validateUser(user)){
            return "User already exists";
        }


        userService.saveUser(user);
        return "New User Added";
    }

    @GetMapping("/getAll")
    public List<User> list(){
        return userService.getAllUsers();
    }

    @GetMapping("/getWallet/{id}")
    public ResponseEntity<?> getWallet(@PathVariable int id){
        User user = userService.getUser(id);
        int wallet = user.getWallet();
        return ResponseEntity.ok(wallet);
    }

    @PatchMapping(path = "/account/{id}")
    public ResponseEntity<?> updateWallet(@PathVariable int id, @RequestBody Map<String,String> updatedWallet){
        User user = userService.getUser(id);

        int newWallet = Integer.parseInt(updatedWallet.get("wallet"));
        int oldWallet = user.getWallet();
        String operation = updatedWallet.get("operation");
        int combined;
        if(operation.equals("add")){
            combined = newWallet + oldWallet;
        }
        else{
            combined = oldWallet - newWallet;
            if(combined < 0){
                combined = 0;
            }
        }

        user.setWallet(combined);

        userService.saveUser(user);

        return ResponseEntity.ok(newWallet);
    }


}
