/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Users;
import com.qdu.service.impl.UserServiceImpl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class editBean implements Serializable {

    private final List<Object[]> listuser;
    private List<Object[]> listuser3 = new ArrayList();
    private List<Object[]> listuser1 = new ArrayList();
    private List<Object[]> listuser2 = new ArrayList();
    private String statue;
    private String userResult;
    private String judegeResult;

    public String getJudegeResult() {
        return judegeResult;
    }

    public void setJudegeResult(String judegeResult) {
        this.judegeResult = judegeResult;
    }

    public String getUserResult() {
        return userResult;
    }

    public void setUserResult(String userResult) {
        this.userResult = userResult;
    }

    public List<Object[]> getListuser3() {
        return listuser3;
    }

    public List<Object[]> getListuser1() {
        return listuser1;
    }

    public List<Object[]> getListuser2() {
        return listuser2;
    }

    public String getStatue() {
        return statue;
    }

    public editBean() {
        UserServiceImpl usi = new UserServiceImpl();
        listuser = usi.lookup();
        for (Object[] ui : listuser) {
            if ((Integer) ui[10] == 1) {
                listuser1.add(ui);
            }
            if ((Integer) ui[11] == 1) {
                listuser2.add(ui);
            }
        }

    }

    public void likeQuery() throws ParseException {
        UserServiceImpl usi = new UserServiceImpl();
        if (judegeResult.equals("id")) {
            listuser3 = usi.likeUser(userResult);
        }
        if (judegeResult.equals("name")) {
            listuser3 = usi.likeUser1(userResult);
        }
        if (judegeResult.equals("gender")) {
            listuser3 = usi.likeUser2(userResult);
        }
        if (judegeResult.equals("age")) {
            for (Object[] array : listuser) {
                Calendar cal = Calendar.getInstance();
                //如果出生日期大于当前时间，则抛出异常
                if (cal.before((Date) array[1])) {
                    throw new IllegalArgumentException(
                            "The birthDay is before Now.It's unbelievable!");
                }
                //取出系统当前时间的年、月、日部分
                int yearNow = cal.get(Calendar.YEAR);
                int monthNow = cal.get(Calendar.MONTH);
                int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

                //将日期设置为出生日期
                cal.setTime((Date) array[1]);
                //取出出生日期的年、月、日部分  
                int yearBirth = cal.get(Calendar.YEAR);
                int monthBirth = cal.get(Calendar.MONTH);
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
                //当前年份与出生年份相减，初步计算年龄
                int age = yearNow - yearBirth;
                //当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁
                if (monthNow <= monthBirth) {
                    //如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow < dayOfMonthBirth) {
                            age--;
                        }
                    } else {
                        age--;
                    }
                }
                if (age == Integer.parseInt(userResult)) {
                    listuser3.add(array);
                }
            }
        }
    }

    public List<Object[]> getListuser() {
        return listuser;
    }

    public String judgeStatue(Object[] user) {
        if ((Integer) user[10] == 1 && (Integer) user[11] == 0) {
            statue = "支教";
        } else if ((Integer) user[10] == 0 && (Integer) user[11] == 1) {
            statue = "需求者";
        } else if ((Integer) user[10] == 1 && (Integer) user[11] == 1) {
            statue = "支教与需求者";
        } else {
            statue = "无";
        }
        return statue;
    }

    public void deleteUser(Object[] user) {
        UserServiceImpl usi = new UserServiceImpl();
        int flag = usi.deleteUser((String) user[0]);
        int flag1 = usi.deleteuseridentity((String) user[0]);

        if (flag == 1 && flag1 == 1) {
            listuser1.remove(user);
            listuser2.remove(user);
            listuser.remove(user);
        } else {
            System.out.println("错误");
        }

    }

    public String chat(String userid) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("chatuserid", userid);
        return "chat";
    }

}
