/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.Ppost;
import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author 刘凯
 */
public class PpostDaoImpl implements Ppost {

    @Override
    public int savespedu(Spedu sp) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(sp);
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
    public int savedemand(Goodsdemand gd) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(gd);
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
    public List<Spedu> lookpostHistory(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Spedu where id.userId= :userId");
        query.setParameter("userId", userid);
        List<Spedu> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public List<Goodsdemand> lookpostHistory1(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Goodsdemand where id.userId= :userId");
        query.setParameter("userId", userid);
        List<Goodsdemand> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deletePost(Spedu sp) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (sp != null) {
                session.delete(sp);
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

    @Override
    public int deletePost1(Goodsdemand gd) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (gd != null) {
                session.delete(gd);
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

    @Override
    public int updatePost(Spedu sp) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(sp);
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
    public int updatePost1(Goodsdemand gd) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(gd);
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
    public List<Spedu> lookPost() {
        Session session = HibernateUtil.getSession();
   
        Query query = session.createQuery("from Spedu");
        List<Spedu> list = query.list();
        HibernateUtil.close(session);
     
        return list;
    }

    @Override
    public List<Goodsdemand> lookPost1() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Goodsdemand");
        List<Goodsdemand> list = query.list();
        HibernateUtil.close(session);
        return list;
    }
}
