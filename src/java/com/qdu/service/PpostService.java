/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.pojo.Goodsdemand;
import com.qdu.pojo.Spedu;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface PpostService {

    int savespedu(Spedu sp);

    int savedemand(Goodsdemand gd);

    List<Spedu> lookpostHistory(String userid);

    List<Goodsdemand> lookpostHistory1(String userid);

    int deletePost(Spedu sp);

    int deletePost1(Goodsdemand gd);

    int updatePost(Spedu sp);

    int updatePost1(Goodsdemand gd);

    List<Spedu> lookPost();

    List<Goodsdemand> lookPost1();
    

}
