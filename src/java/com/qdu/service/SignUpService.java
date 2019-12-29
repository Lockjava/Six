/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.pojo.Demandsignup;
import com.qdu.pojo.Spesignup;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface SignUpService {

    int SpeSaveSignUp(Spesignup ssu);

    List<Spesignup> LookUpSpeSignUp(String userid);

    List<Spesignup> LookUpquantity(Date Spetime, String SpeId);

    List<Demandsignup> LookUpquantity1(Date Spetime, String SpeId);

    int deleteSpeSignUp(Spesignup ssu);

    int deleteSpeSignUp1(Demandsignup dds);

    int SpeSaveSignUp1(Demandsignup dds);

    List<Demandsignup> LookUpSpeSignUp1(String userid);
}
