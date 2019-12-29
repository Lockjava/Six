/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Journal;
import com.qdu.pojo.Users;
import com.qdu.service.impl.JournalServiceImpl;
import java.io.Serializable;
import java.util.List;
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
public class LookHistoryJournalBean implements Serializable {

    private List<Journal> listjournal;
    private Journal jos;
    
    public List<Journal> getListjournal() {
        return listjournal;
    }

    public Journal getJos() {
        return jos;
    }

    public LookHistoryJournalBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        JournalServiceImpl josi=new JournalServiceImpl();
        listjournal=josi.lookupJournal(user.getUserId());
    }
    public void deleteJournal(Journal jou){
        JournalServiceImpl josi=new JournalServiceImpl();
        listjournal.remove(jou);
        int flag=josi.deletePost(jou);       
    }
   
    public String detailedJournal(Journal jou){
        jos=jou;
        return "detailedJournal";
       
    }
 
   
}
