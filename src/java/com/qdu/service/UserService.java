/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface UserService {

    int saveUser(Users user);

    int saveuseridentity(Useridentity urd);

    int deleteuseridentity(String userId);

    Users isHavingUsers(String userId);

    int updateUsers(Users user);

    List<Object[]> lookup();

    int deleteUser(String userId);

    List<Object[]> likeUser(String userId);

    List<Object[]> likeUser1(String userName);

    List<Object[]> likeUser2(String userGender);

}
