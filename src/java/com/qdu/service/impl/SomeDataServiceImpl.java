/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.SomeDataDaoImpl;
import com.qdu.pojo.Demandapply;
import com.qdu.pojo.Speapply;
import com.qdu.pojo.Useridentity;
import com.qdu.service.SomeDataService;
import java.util.List;


/**
 *
 * @author 刘凯
 */
public class SomeDataServiceImpl implements SomeDataService{

    @Override
    public int saveAplySpeDao(Speapply speapply) {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.saveAplySpeDao(speapply);
    }

    @Override
    public int saveAplyDemandDao(Demandapply demandapply) {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.saveAplyDemandDao(demandapply);
    }

    @Override
    public List<Object[]> lookupspeapply() {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.lookupspeapply();
    }

    @Override
    public int deletespeapply(String userId) {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.deletespeapply(userId);
    }

    @Override
    public int updateUseridentity(Useridentity urd) {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.updateUseridentity(urd);
    }

    @Override
    public Useridentity lookupUseridentity(String userId) {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.lookupUseridentity(userId);
    }

    @Override
    public List<Object[]> lookupneedapply() {
        SomeDataDaoImpl sddi=new SomeDataDaoImpl();
        return sddi.lookupneedapply();
    }

    @Override
    public int deleteneedapply(String userId) {
       SomeDataDaoImpl sddi=new SomeDataDaoImpl();
       return sddi.deleteneedapply(userId);
    }

  
    
}
