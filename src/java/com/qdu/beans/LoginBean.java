/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Admin;
import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
import com.qdu.service.impl.AdminServiceImpl;
import com.qdu.service.impl.SomeDataServiceImpl;
import com.qdu.service.impl.UserServiceImpl;
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
public class LoginBean implements Serializable {

    private String Id;
    private String Pwd;
    private Admin admin;
    private Users user;
    private String name;
    private int num;
    private boolean is = true;
    private String is1 = "none";

    public String getIs1() {
        return is1;
    }

    public boolean isIs() {
        return is;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean show = true;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public String isAdminlogin() {
        AdminServiceImpl usi = new AdminServiceImpl();
        admin = usi.isHaving(Id);
        if (admin != null && admin.getAdminPwd().equals(Pwd)) {
            num = 1;
            name = admin.getAdminName();
            is = false;
            is1 = "block";
            return "index";
        } else {           
            return "failed";
        }
    }

    public String isUserlogin() {
        UserServiceImpl uss = new UserServiceImpl();
        user = uss.isHavingUsers(Id);
        if (user != null && user.getUserPwd().equals(Pwd)) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("user", user);
            num = 2;
            name = user.getUserName();
            SomeDataServiceImpl sds = new SomeDataServiceImpl();
            Useridentity urd = sds.lookupUseridentity(Id);
            if (urd.getUserStatue1() == 1 && urd.getUserStatue2() == 0) {
                num = 3;
            }
            if (urd.getUserStatue1() == 0 && urd.getUserStatue2() == 1) {
                num = 4;
            }
            if (urd.getUserStatue1() == 1 && urd.getUserStatue2() == 1) {
                num = 5;
            }
            is = false;
            is1 = "block";
            session.setAttribute("is", is);
            return "index";
        } else {
            return "failed";
        }
    }

    public void save() throws ParseException {

        //把字符串类型转化成date类型
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //按照格式传入转换成date型
//        Date date=new java.sql.Date(sdf.parse(dateString).getTime());
//        user.setUserBirtnday(date);
        UserServiceImpl uss = new UserServiceImpl();
        int flag = uss.updateUsers(user);
        System.out.println(user.getUserName());
        System.out.println(flag);
        show = true;
    }

    public void edit() {
        show = false;
    }

    public boolean isShow() {
        return show;
    }

    public String isWho() {
        switch (num) {
            case 1:
                return "personalCenter1";
            case 2:
                return "personalCenter";
            case 3:
                return "personalCenter4";
            case 4:
                return "personalCenter3";
            case 5:
                return "personalCenter5";
            default:
                return "#";
        }

    }

    public String logout() {
        is = true;
        is1 = "none";
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
       
        return "index";
    }

}
