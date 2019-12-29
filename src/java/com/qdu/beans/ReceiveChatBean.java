/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Message;
import com.qdu.pojo.Users;
import com.qdu.service.impl.ChatServiceImpl;
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
public class ReceiveChatBean implements Serializable {

    private List<Message> meslist;
    private int num=0;

    public int getNum() {
        return num;
    }
    public List<Message> getMeslist() {
        return meslist;
    }

    public ReceiveChatBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        ChatServiceImpl csi = new ChatServiceImpl();
        meslist = csi.lookUpMessage(user.getUserId());
        for(Message m:meslist){
            num++;
        }
        
    }
    public String lookdetailedMessage(Message mes){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("detailedMes", mes);
        return "detailedMessage";
    }
   public void deleteMessage(Message mes){
        ChatServiceImpl csi=new ChatServiceImpl();
        csi.deleteMessage(mes);
        meslist.remove(mes);
   }
}
