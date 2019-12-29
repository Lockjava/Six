/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.PpostDaoImpl;
import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.service.PpostService;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public class PpostServiceImpl implements PpostService {

    @Override
    public int savespedu(Spedu sp) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.savespedu(sp);
    }

    @Override
    public int savedemand(Goodsdemand gd) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.savedemand(gd);
    }

    @Override
    public List<Spedu> lookpostHistory(String userid) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.lookpostHistory(userid);
    }

    @Override
    public List<Goodsdemand> lookpostHistory1(String userid) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.lookpostHistory1(userid);
    }

    @Override
    public int deletePost(Spedu sp) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.deletePost(sp);
    }

    @Override
    public int deletePost1(Goodsdemand gd) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.deletePost1(gd);
    }

    @Override
    public int updatePost(Spedu sp) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.updatePost(sp);
    }

    @Override
    public int updatePost1(Goodsdemand gd) {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.updatePost1(gd);
    }

    @Override
    public List<Spedu> lookPost() {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.lookPost();
    }

    @Override
    public List<Goodsdemand> lookPost1() {
        PpostDaoImpl pps = new PpostDaoImpl();
        return pps.lookPost1();
    }
}
