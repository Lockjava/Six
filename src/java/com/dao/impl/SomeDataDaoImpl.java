/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SomeDataDao;
import com.qdu.pojo.Demandapply;
import com.qdu.pojo.Speapply;
import com.qdu.pojo.Useridentity;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author 刘凯
 */
public class SomeDataDaoImpl implements SomeDataDao {

    @Override
    public int saveAplySpeDao(Speapply speapply) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(speapply);
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
    public int saveAplyDemandDao(Demandapply demandapply) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(demandapply);
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
    public List<Object[]> lookupspeapply() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.saidcardPhoto,b.sapersonDescribe,b.saeducationBackground,b.sasupportLevel,b.satime,b.saputonghua from Users a,Speapply b where a.userId=b.userId");
        List<Object[]> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deletespeapply(String userId) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Speapply spa = session.get(Speapply.class, userId);
            if (spa != null) {
                session.delete(spa);
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
    public int updateUseridentity(Useridentity urd) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(urd);
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
    public Useridentity lookupUseridentity(String userId) {
        Session session = HibernateUtil.getSession();
        Useridentity urd = session.get(Useridentity.class, userId);
        HibernateUtil.close(session);
        return urd;
    }

    @Override
    public List<Object[]> lookupneedapply() {
     Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.daidcardPhoto,b.dapersonDescribe from Users a,Demandapply b where a.userId=b.userId");
        List<Object[]> list = query.list();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int deleteneedapply(String userId) {
             Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Demandapply dda = session.get(Demandapply.class, userId);
            if (dda != null) {
                session.delete(dda);
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
