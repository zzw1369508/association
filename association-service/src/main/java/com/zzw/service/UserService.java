package com.zzw.service;

import com.zzw.entity.User;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface UserService{
    PageInfo<User> getUserPage(int num, int size,User search);

    User login(User user);

    List<User> getByAccount(String account);

    User add(User user);

    User updateById(User user);

    User getById(Serializable id);

   void  DeleteById(Serializable id);

    User getOneByAccount(String account);

    User register(User user,String rePassWord);
}
