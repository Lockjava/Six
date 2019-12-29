/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.UserDaoImpl;
import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
import com.qdu.service.UserService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public class UserServiceImpl implements UserService {
    @Override
    public int saveUser(Users user) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.saveUser(user);
    }

    @Override
    public Users isHavingUsers(String userId) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.isHavingUsers(userId);

    }

    @Override
    public int updateUsers(Users user) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.updateUsers(user);
    }

    @Override
    public List<Object[]> lookup() {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.lookup();
    }

    @Override
    public int deleteUser(String userId) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.deleteUser(userId);

    }

    @Override
    public List<Object[]> likeUser(String userId) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.likeUser(userId);
    }

    @Override
    public List<Object[]> likeUser1(String userName) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.likeUser1(userName);
    }

    @Override
    public List<Object[]> likeUser2(String userGender) {
        UserDaoImpl usd = new UserDaoImpl();
        return usd.likeUser2(userGender);
    }

    @Override
    public int saveuseridentity(Useridentity urd) {
        UserDaoImpl usd = new UserDaoImpl();
   return  usd.saveuseridentity(urd);
    }

    @Override
    public int deleteuseridentity(String userId) {
        UserDaoImpl usd = new UserDaoImpl();
         return  usd.deleteuseridentity(userId);
    }

}
