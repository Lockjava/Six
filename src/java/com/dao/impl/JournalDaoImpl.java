/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.JournalDao;
import com.qdu.pojo.Journal;
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
public class JournalDaoImpl implements JournalDao {

    @Override
    public int saveJournal(Journal jou) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(jou);
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
    public List<Journal> lookupJournal(String userid) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Journal where id.userId= :userId");
        query.setParameter("userId", userid);
        List<Journal> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deletePost(Journal jou) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            if (jou != null) {
                session.delete(jou);
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
    public List<Journal> lookupallJournal() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Journal");
        List<Journal> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

}
