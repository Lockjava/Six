/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Spesignup;
import com.qdu.pojo.Users;
import com.qdu.service.impl.SignUpServiceImpl;
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
public class SignUpBean implements Serializable {

    private List<Spesignup> listspesignup;

    public List<Spesignup> getListspesignup() {
        return listspesignup;
    }

    public SignUpBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users user = (Users) session.getAttribute("user");
        SignUpServiceImpl ssui=new SignUpServiceImpl();
        listspesignup=ssui.LookUpSpeSignUp(user.getUserId());     
    }
    public void DeleteSignUp(Spesignup ssp){
        SignUpServiceImpl ssui=new SignUpServiceImpl();
        int flag=ssui.deleteSpeSignUp(ssp);
        listspesignup.remove(ssp);
    }

}
