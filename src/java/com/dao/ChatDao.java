/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.pojo.Message;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface ChatDao {
    int saveChat(Message mes);
    List<Message> lookUpMessage(String userid);
    int deleteMessage(Message mes);
}
