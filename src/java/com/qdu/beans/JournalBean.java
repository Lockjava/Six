/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Journal;
import com.qdu.pojo.JournalId;
import com.qdu.pojo.Users;
import com.qdu.service.impl.JournalServiceImpl;
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
public class JournalBean implements Serializable {

    private Journal jou = new Journal();
    private JournalId jouid = new JournalId();

    public Journal getJou() {
        return jou;
    }

    public void setJou(Journal jou) {
        this.jou = jou;
    }

    public JournalId getJouid() {
        return jouid;
    }

    public void setJouid(JournalId jouid) {
        this.jouid = jouid;
    }

    public void saveJournal() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        jouid.setUserId(user.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
        jouid.setJourTime(datetime);
        jou.setId(jouid);
        JournalServiceImpl jos = new JournalServiceImpl();
        int flag = jos.saveJournal(jou);
    }
}
