/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.GoodsdemandId;
import com.qdu.pojo.Users;
import com.qdu.service.impl.PpostServiceImpl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 刘凯
 */
@Named
@RequestScoped
public class DemandPost1Bean  implements Serializable{

    private Goodsdemand goodsdemand = new Goodsdemand();
    private GoodsdemandId goodsdemandid = new GoodsdemandId();

    public Goodsdemand getGoodsdemand() {
        return goodsdemand;
    }

    public void setGoodsdemand(Goodsdemand goodsdemand) {
        this.goodsdemand = goodsdemand;
    }

    public GoodsdemandId getGoodsdemandid() {
        return goodsdemandid;
    }

    public void setGoodsdemandid(GoodsdemandId goodsdemandid) {
        this.goodsdemandid = goodsdemandid;
    }

    public void saveDemandPost1() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        goodsdemandid.setUserId(user.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
        goodsdemandid.setDemandTime(datetime);
        goodsdemand.setId(goodsdemandid);
        goodsdemand.setDemandStatus("正在审核");
        PpostServiceImpl pps = new PpostServiceImpl();
        int flag = pps.savedemand(goodsdemand);
    }
}
