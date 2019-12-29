/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.dao.impl.UserDaoImpl;
import com.qdu.pojo.Demandsignup;
import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.pojo.Spesignup;
import com.qdu.pojo.Users;
import com.qdu.service.UserService;
import com.qdu.service.impl.PpostServiceImpl;
import com.qdu.service.impl.SignUpServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class LookHistoryBean implements Serializable {

    private List<Spedu> listspe;
    private List<Goodsdemand> listgoodsdemand;
    private Goodsdemand gd;
    private Spedu sp;
    private List<Users> userlist = new ArrayList<>();

  
    UserDaoImpl udi = new UserDaoImpl();

    public List<Goodsdemand> getListgoodsdemand() {
        return listgoodsdemand;
    }

    public Goodsdemand getGd() {
        return gd;
    }

    public Spedu getSp() {
        return sp;
    }

    public List<Spedu> getListspe() {
        return listspe;
    }

    public LookHistoryBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        PpostServiceImpl pps = new PpostServiceImpl();
        listspe = pps.lookpostHistory(user.getUserId());
        listgoodsdemand = pps.lookpostHistory1(user.getUserId());
    }

    public void deletepost(Spedu spe) {
        PpostServiceImpl pps = new PpostServiceImpl();
        int rows = pps.deletePost(spe);
        listspe.remove(spe);
    }

    public void deletepost1(Goodsdemand gs) {
        PpostServiceImpl pps = new PpostServiceImpl();
        int rows = pps.deletePost1(gs);
        listgoodsdemand.remove(gs);
    }

    public String dtpost(Spedu spe) {
        sp = spe;
        return "postdetails";
    }

    public String dtpost1(Goodsdemand gs) {
        gd = gs;
        return "postdetails1";
    }

    public int calculateQuantity(Date Spetime, String SpeId) {
        int num = 0;
        SignUpServiceImpl susi = new SignUpServiceImpl();
        List<Spesignup> list3 = susi.LookUpquantity(Spetime, SpeId);
        for (Spesignup n : list3) {
            userlist.add(udi.isHavingUsers(n.getId().getUserId()));
            num++;
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("userlist", userlist);
        return num;
    }

    public int calculateQuantity1(Date Spetime, String SpeId) {
        int num = 0;
        SignUpServiceImpl susi = new SignUpServiceImpl();
        List<Demandsignup> list3 = susi.LookUpquantity1(Spetime, SpeId);
        for (Demandsignup n : list3) {       
            userlist.add(udi.isHavingUsers(n.getId().getUserId()));
            num++;
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("userlist", userlist);
        return num;
    }

}
