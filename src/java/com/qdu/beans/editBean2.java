/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Useridentity;
import com.qdu.service.impl.SomeDataServiceImpl;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 刘凯
 */
@Named
@RequestScoped
public class editBean2 {

    private List<Object[]> list;
    private String introduce;
    private Object[] s;

    public Object[] getS() {
        return s;
    }

    public List<Object[]> getList() {
        return list;
    }

    public editBean2() {
        SomeDataServiceImpl sdsi = new SomeDataServiceImpl();
        list = sdsi.lookupneedapply();
    }

    public String perIntroduce(Object[] u) {
        introduce = (String) u[11];
        return introduce.substring(0, 6);
    }

    public String details(Object[] u) {
        s = u;
        return "perdetails1";
    }


    public void handleOkneed(String aa) {
        SomeDataServiceImpl sdsi = new SomeDataServiceImpl();
        Useridentity usd = sdsi.lookupUseridentity(aa);
        usd.setUserStatue2(1);
        int num = sdsi.updateUseridentity(usd);
        int flag = sdsi.deleteneedapply(aa);
        for (Object[] io : list) {
            if (io[0].equals(aa)) {
                list.remove(io);
                break;
            }
        }

    }

    public void handleNo(String aa) {
        SomeDataServiceImpl sdsi = new SomeDataServiceImpl();
        int flag = sdsi.deleteneedapply(aa);
        for (Object[] io : list) {
            if (io[0].equals(aa)) {
                list.remove(io);
                break;
            }
        }

    }

}
