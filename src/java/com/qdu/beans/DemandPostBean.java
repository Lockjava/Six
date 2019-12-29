/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Spedu;
import com.qdu.pojo.SpeduId;
import com.qdu.pojo.Users;
import com.qdu.service.impl.PpostServiceImpl;
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
public class DemandPostBean {

    private Spedu spe = new Spedu();
    private SpeduId speid = new SpeduId();

    public Spedu getSpe() {
        return spe;
    }

    public void setSpe(Spedu spe) {
        this.spe = spe;
    }

    public void saveDemandPost() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        speid.setUserId(user.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
        speid.setSpeTime(datetime);
        spe.setId(speid);
        spe.setDemandStatus("正在审核");
        PpostServiceImpl pps = new PpostServiceImpl();
        int flag = pps.savespedu(spe);
        System.out.println(flag);
    }
}
