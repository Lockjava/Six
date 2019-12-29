/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.UserDao;
import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
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
public class UserDaoImpl implements UserDao {

    @Override
    public int saveUser(Users user) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(user);
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
    public Users isHavingUsers(String userId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Users where userId=:userId");
        query.setParameter("userId", userId);
        Users user = (Users) query.uniqueResult();
        HibernateUtil.close(session);
        return user;
    }

    @Override
    public int updateUsers(Users user) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(user);
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
    public List<Object[]> lookup() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.userStatue1,b.userStatue2 from Users a,Useridentity b where a.userId=b.userId");
        List<Object[]> list = query.list();
        HibernateUtil.close(session);
        return list;

    }

    @Override
    public int deleteUser(String userId) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Users user = session.get(Users.class, userId);
            if (user != null) {
                session.delete(user);
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
    public List<Object[]> likeUser(String userId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.userStatue1,b.userStatue2 from Users a,Useridentity b where a.userId=b.userId and a.userId like :userid");
        query.setParameter("userid", "%" + userId + "%");
        List<Object[]> list = query.getResultList();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public List<Object[]> likeUser1(String userName) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.userStatue1,b.userStatue2 from Users a,Useridentity b where a.userId=b.userId and a.userRealName like :username");
        query.setParameter("username", "%" + userName + "%");
        List<Object[]> list = query.getResultList();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public List<Object[]> likeUser2(String userGender) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select a.userId,a.userBirtnday,a.userCard,a.userCity,a.userEmail, "
                + "a.userGender,a.userName,a.userOccupation,a.userRealName,a.userTel, "
                + "b.userStatue1,b.userStatue2 from Users a,Useridentity b where a.userId=b.userId and a.userGender like :usergender");
        query.setParameter("usergender", "%" + userGender + "%");
        List<Object[]> list = query.getResultList();
        HibernateUtil.close(session);
        return list;
    }

    @Override
    public int saveuseridentity(Useridentity urd) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(urd);
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
    public int deleteuseridentity(String userId) {
        Session session = null;
        int rows = 0;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Useridentity urd = session.get(Useridentity.class, userId);
            if (urd != null) {
                session.delete(urd);
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
