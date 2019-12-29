/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.SignUpDaoImpl;
import com.qdu.pojo.Demandsignup;
import com.qdu.pojo.Spesignup;
import com.qdu.service.SignUpService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public class SignUpServiceImpl implements SignUpService {

    @Override
    public int SpeSaveSignUp(Spesignup ssu) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.SpeSaveSignUp(ssu);
    }

    @Override
    public List<Spesignup> LookUpSpeSignUp(String userid) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.LookUpSpeSignUp(userid);
    }

    @Override
    public int deleteSpeSignUp(Spesignup ssu) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.deleteSpeSignUp(ssu);
    }

    @Override
    public int deleteSpeSignUp1(Demandsignup dds) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.deleteSpeSignUp1(dds);
    }

    @Override
    public int SpeSaveSignUp1(Demandsignup dds) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.SpeSaveSignUp1(dds);
    }

    @Override
    public List<Demandsignup> LookUpSpeSignUp1(String userid) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.LookUpSpeSignUp1(userid);
    }

    @Override
    public List<Spesignup> LookUpquantity(Date Spetime, String SpeId) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.LookUpquantity(Spetime, SpeId);
    }

    @Override
    public List<Demandsignup> LookUpquantity1(Date Spetime, String SpeId) {
        SignUpDaoImpl sudi = new SignUpDaoImpl();
        return sudi.LookUpquantity1(Spetime, SpeId);
    }

}
