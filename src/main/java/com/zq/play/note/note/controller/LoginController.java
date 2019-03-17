package com.zq.play.note.note.controller;

import com.zq.play.note.note.entity.UserEntity;
import com.zq.play.note.note.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class LoginController{


    @Autowired
    private UserJPA userJPA;

   @RequestMapping(value = "/login")
 public  String login(UserEntity user, HttpServletRequest request){

       boolean flag = true;

       String result="登录成功";
       //根据用户名查询用户是否存在
       Optional<UserEntity> userEntity = userJPA.findOne(new Specification<UserEntity>() {
           @Override
           public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               criteriaQuery.where(criteriaBuilder.equal(root.get("username"), user.getUsername()));
               return null;
           }
       });

       UserEntity userInfo = userEntity.get();

       if(userInfo == null){
           flag =false;
           result ="用户不存在，登录失败";
       }else if (!userInfo.getPassword().equals(user.getPassword())){
           flag =false;
           result ="用户密码不相符，登录失败";
       }


       if(flag){
           //将用户写入session
           request.getSession().setAttribute("_session_user",userEntity);
       }

       return result;
 }

}
