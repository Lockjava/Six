/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.pojo.Spesignup;
import com.qdu.pojo.SpesignupId;
import com.qdu.pojo.Users;
import com.qdu.service.impl.PpostServiceImpl;
import com.qdu.service.impl.SignUpServiceImpl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class PrintsupEduBean implements Serializable {

    private List<Spedu> listspe = new ArrayList();
    private List<Goodsdemand> listgoodsdemand = new ArrayList();


    public List<Spedu> getListspe() {
        return listspe;
    }

    public List<Goodsdemand> getListgoodsdemand() {
        return listgoodsdemand;
    }

    public PrintsupEduBean() {
        PpostServiceImpl pps = new PpostServiceImpl();
        List<Spedu> list1 = pps.lookPost();

        for (Spedu s : list1) {

            if (s.getDemandStatus().equals("通过")) {

                listspe.add(s);
            }
        }

        List<Goodsdemand> list2 = pps.lookPost1();
        for (Goodsdemand d : list2) {
            if (d.getDemandStatus().equals("通过")) {
                listgoodsdemand.add(d);
            }
        }
    }

    public String changePage(Spedu spe) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("sp1", spe);
        return "readDetailedNeed1";
    }

    public String changePage1(Goodsdemand gds) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("gd1", gds);
        return "readDeatailedNeed2";
    }

}
