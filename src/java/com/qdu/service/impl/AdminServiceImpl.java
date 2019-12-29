/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.AdminDaoImpl;
import com.qdu.pojo.Admin;
import java.util.List;
import com.qdu.service.AdminService;

/**
 *
 * @author 刘凯
 */
public class AdminServiceImpl implements AdminService{

    @Override
    public Admin isHaving(String adminId) {
       AdminDaoImpl adi=new AdminDaoImpl();
       return  adi.isHavingDao(adminId);
    }
    
}
