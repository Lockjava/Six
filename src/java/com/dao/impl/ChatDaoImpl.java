/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.ChatDao;
import com.qdu.pojo.Message;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author 刘凯
 */
public class ChatDaoImpl implements ChatDao {

    @Override
    public int saveChat(Message mes) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(mes);
            tran.commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close(session);
        }
        return rows;
    }

    @Override
    public List<Message> lookUpMessage(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Message where id.minId= :userId");
        query.setParameter("userId", userid);
        List<Message> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deleteMessage(Message mes) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (mes != null) {
                session.delete(mes);
                tran.commit();
                rows = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close(session);
        }
        return rows;
    }

}
