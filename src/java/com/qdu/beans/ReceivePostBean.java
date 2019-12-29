/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Spedu;
import com.qdu.pojo.Spesignup;
import com.qdu.pojo.SpesignupId;
import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
import com.qdu.service.impl.SignUpServiceImpl;
import com.qdu.service.impl.SomeDataServiceImpl;
import java.io.Serializable;
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
public class ReceivePostBean implements Serializable {

    private Spesignup ssu = new Spesignup();
    private SpesignupId ssuid = new SpesignupId();
    private int flag = 0;

    public Spesignup getSsu() {
        return ssu;
    }

    public String receive() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if((Users) session.getAttribute("user")!=null){
        Users user = (Users) session.getAttribute("user");
        Spedu spe = (Spedu) session.getAttribute("sp1");
        SomeDataServiceImpl sds = new SomeDataServiceImpl();
   Useridentity uidt=    sds.lookupUseridentity(user.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
        SignUpServiceImpl ssui = new SignUpServiceImpl();

        List<Spesignup> list4 = ssui.LookUpquantity(spe.getId().getSpeTime(), spe.getId().getUserId());
        for (Spesignup y : list4) {
            if (user.getUserId().equals(y.getId().getUserId())) {
                flag = 1;break;
            } else {
                flag = 0;
            }
        }
        if (flag == 0&&uidt.getUserStatue1()==1) {

            ssuid.setUserId(user.getUserId());
            ssuid.setSstime(datetime);
            ssuid.setSpeTime(spe.getId().getSpeTime());
            ssuid.setSpeId(spe.getId().getUserId());
            ssu.setId(ssuid);
            ssu.setSpeTitle(spe.getSpeTitle());
            ssui.SpeSaveSignUp(ssu);
            return "suptEdu";
        }
           return "receiveFailed";
         
    }  
        else{
            return "login";
        }
        
    }
 

}
