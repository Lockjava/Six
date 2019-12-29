/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import com.qdu.pojo.Users;
import com.qdu.service.impl.PpostServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
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
public class AdminCheckPostBean implements Serializable {

    private List<Spedu> listspe = new ArrayList();
    private List<Goodsdemand> listgoodsdemand = new ArrayList();
    private Goodsdemand gd;
    private Spedu sp;

    public List<Spedu> getListspe() {
        return listspe;
    }

    public List<Goodsdemand> getListgoodsdemand() {
        return listgoodsdemand;
    }

    public Goodsdemand getGd() {
        return gd;
    }

    public Spedu getSp() {
        return sp;
    }

    public AdminCheckPostBean() {

        PpostServiceImpl pps = new PpostServiceImpl();
  
        List<Spedu> list1=pps.lookPost();

        for(Spedu s:list1){
           
            if(s.getDemandStatus().equals("正在审核")){

                listspe.add(s);
} 
            }
        
        List<Goodsdemand> list2 = pps.lookPost1();
        for (Goodsdemand d : list2) {
            if (d.getDemandStatus().equals("正在审核")) {
                listgoodsdemand.add(d);
            }
        }

    }

    public void checkPostOk(Spedu spe) {
        spe.setDemandStatus("通过");
        PpostServiceImpl posi = new PpostServiceImpl();
        posi.updatePost(spe);
        listspe.remove(spe);
    }

    public void checkPostNo(Spedu spe) {
        spe.setDemandStatus("不通过");
        PpostServiceImpl posi = new PpostServiceImpl();
        posi.updatePost(spe);
        listspe.remove(spe);
    }
        public void checkPostOk1(Goodsdemand gds) {
        gds.setDemandStatus("通过");
        PpostServiceImpl posi = new PpostServiceImpl();
        posi.updatePost1(gds);
        listgoodsdemand.remove(gds);
    }

    public void checkPostNo1(Goodsdemand gds) {
        gds.setDemandStatus("不通过");
        PpostServiceImpl posi = new PpostServiceImpl();
        posi.updatePost1(gds);
        listgoodsdemand.remove(gds);
    }

   public String spedetail(Spedu sp1){
       sp=sp1;
       return "speDetail";
   }
    public String spedetail1(Goodsdemand  gd1){
       gd=gd1;
       return "speDetail1";
   }
}
