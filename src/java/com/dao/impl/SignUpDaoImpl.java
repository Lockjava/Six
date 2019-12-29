/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SignUpDAO;
import com.qdu.pojo.Demandsignup;
import com.qdu.pojo.Journal;
import com.qdu.pojo.Spesignup;
import com.qdu.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author 刘凯
 */
public class SignUpDaoImpl implements SignUpDAO {

    @Override
    public int SpeSaveSignUp(Spesignup ssu) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(ssu);
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
    public List<Spesignup> LookUpSpeSignUp(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Spesignup where id.userId= :userId");
        query.setParameter("userId", userid);
        List<Spesignup> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deleteSpeSignUp(Spesignup ssu) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (ssu != null) {
                session.delete(ssu);
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
    public int deleteSpeSignUp1(Demandsignup dds) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (dds != null) {
                session.delete(dds);
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
    public int SpeSaveSignUp1(Demandsignup dds) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(dds);
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
    public List<Demandsignup> LookUpSpeSignUp1(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Demandsignup where id.userId= :userId");
        query.setParameter("userId", userid);
        List<Demandsignup> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public List<Spesignup> LookUpquantity(Date Spetime, String SpeId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Spesignup where id.speId= :speid and id.speTime= :spetime");
        query.setParameter("speid", SpeId);
        query.setParameter("spetime", Spetime);
        List<Spesignup> list = query.list();
        HibernateUtil.close(session);
        return list;

    }

    @Override
    public List<Demandsignup> LookUpquantity1(Date Spetime, String SpeId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Demandsignup where id.demandId= :speid and id.demandTime= :spetime");
        query.setParameter("speid", SpeId);
        query.setParameter("spetime", Spetime);
        List<Demandsignup> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

}
