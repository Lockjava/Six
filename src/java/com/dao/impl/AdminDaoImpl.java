/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.AdminDao;
import com.qdu.pojo.Admin;
import com.qdu.util.HibernateUtil;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;


/**
 *
 * @author 刘凯
 */
public class AdminDaoImpl  implements AdminDao{

    @Override
    public Admin isHavingDao(String adminId) {
    
        Session session=HibernateUtil.getSession();     
        Query query=session.createQuery("from Admin where adminId=:adminId");
        query.setParameter("adminId", adminId);
        Admin admin = (Admin) query.uniqueResult();      
        HibernateUtil.close(session); 
        return admin;
 
}
}