/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Demandsignup;
import com.qdu.pojo.DemandsignupId;
import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.pojo.Users;
import com.qdu.service.impl.SignUpServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ReceiveDonateBean {

    private Demandsignup demsign = new Demandsignup();
    private DemandsignupId demsignid = new DemandsignupId();
    private int flag = 0;

    public Demandsignup getDemsign() {
        return demsign;
    }

    public String receive() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if ((Users) session.getAttribute("user") != null) {
            Users user = (Users) session.getAttribute("user");
            Goodsdemand gds = (Goodsdemand) session.getAttribute("gd1");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
            SignUpServiceImpl ssui = new SignUpServiceImpl();

            List<Demandsignup> list4 = ssui.LookUpquantity1(gds.getId().getDemandTime(), gds.getId().getUserId());
            for (Demandsignup y : list4) {
                if (user.getUserId().equals(y.getId().getUserId())) {
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                demsignid.setUserId(user.getUserId());
                demsignid.setDstime(datetime);
                demsignid.setDemandId(gds.getId().getUserId());
                demsignid.setDemandTime(gds.getId().getDemandTime());
                demsign.setId(demsignid);
                demsign.setDemandTitle(gds.getDemandTitle());
                ssui.SpeSaveSignUp1(demsign);
                return "donate";
            }
            return "receiveFailed1";

        } else {
            return "login";
        }
    }

}
