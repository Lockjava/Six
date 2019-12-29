/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.ChatDaoImpl;
import com.qdu.pojo.Message;
import com.qdu.service.ChatService;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public class ChatServiceImpl implements ChatService {

    @Override
    public int saveChat(Message mes) {
        ChatDaoImpl cdi = new ChatDaoImpl();
        return cdi.saveChat(mes);
    }

    @Override
    public List<Message> lookUpMessage(String userid) {
        ChatDaoImpl cdi = new ChatDaoImpl();
        return cdi.lookUpMessage(userid);
    }

    @Override
    public int deleteMessage(Message mes) {

        ChatDaoImpl cdi = new ChatDaoImpl();
        return cdi.deleteMessage(mes);
    }

}
