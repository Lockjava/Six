/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Demandapply;
import com.qdu.pojo.Speapply;
import com.qdu.pojo.Users;
import com.qdu.service.impl.SomeDataServiceImpl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 刘凯
 */
@Named
@SessionScoped
public class ApplyBean implements Serializable {

    private Speapply speapply = new Speapply();
    private Demandapply demandapply=new Demandapply();
    private String dateString;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    public Demandapply getDemandapply() {
        return demandapply;
    }

    public void setDemandapply(Demandapply demandapply) {
        this.demandapply = demandapply;
    }
    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Speapply getSpeapply() {
        return speapply;
    }

    public void setSpeapply(Speapply speapply) {
        this.speapply = speapply;
    }

    public void submitAplSpe() throws ParseException {
       
        Users user = (Users) session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new java.sql.Date(sdf.parse(dateString).getTime());
        speapply.setUserId(user.getUserId());
        speapply.setSatime(date);
        SomeDataServiceImpl sdsi = new SomeDataServiceImpl();
        int flag = sdsi.saveAplySpeDao(speapply);
        System.out.println(flag);
    }
        public void submitAplDemander() throws ParseException {    
        Users user = (Users) session.getAttribute("user");
        demandapply.setUserId(user.getUserId());
        SomeDataServiceImpl sdsi = new SomeDataServiceImpl();
        int flag = sdsi.saveAplyDemandDao(demandapply);
        System.out.println(flag);
    }
    

}
