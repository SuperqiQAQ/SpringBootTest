package com.zq.play.note.note.controller;

import com.zq.play.note.note.entity.UserEntity;
import com.zq.play.note.note.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * springBoot 学习
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }
    /**
     * 添加，更新用户方法
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }

    /**
     * 删除delete
     * 根据id删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
         userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
