/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Message;
import com.qdu.pojo.MessageId;
import com.qdu.pojo.Users;
import com.qdu.service.impl.ChatServiceImpl;
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
public class InteruserChatBean implements Serializable {

    private Message mes = new Message();
    private MessageId mesId = new MessageId();
    private String mcon;


    public String getMcon() {
        return mcon;
    }

    public void setMcon(String mcon) {
        this.mcon = mcon;
    }

    public String chat(Users ue) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("ue", ue);
        return "chat2";
    }

    public String saveMes() throws ParseException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user7 = (Users) session.getAttribute("user");
        Users user6=(Users)session.getAttribute("ue");
        mesId.setMoutId(user7.getUserId());
        mesId.setMinId(user6.getUserId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
        mesId.setMtime(datetime);
        mes.setId(mesId);
        mes.setMcontent(mcon);
        ChatServiceImpl csi = new ChatServiceImpl();
        int flag = csi.saveChat(mes);
        if (flag == 1) {
            return "sendSuccess";
        } else {
            return "sendFailed";
        }

    }
}
