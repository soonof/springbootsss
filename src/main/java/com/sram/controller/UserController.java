package com.sram.controller;

import com.sram.beans.User;
import com.sram.common.CodeMenu;
import com.sram.common.ResponseResult;
import com.sram.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/findAll")
    public ResponseResult<User> findAll(){

        List<User> users = userDao.findAll();
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(new User());
        rr.setUserList(users);
        return rr;
    }

    @GetMapping("/findById")
    public ResponseResult<User> findById(int id){

        Optional<User> byId = userDao.findById(id);
        User user = byId.get();
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(user);
        rr.setUserList(new ArrayList<User>());
        return rr;
    }

    @PostMapping("/update")
    public ResponseResult<User> update(@RequestBody User user){
        System.out.println(user);
        userDao.save(user);
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);

        return rr;
    }
}
