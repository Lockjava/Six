/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.impl.JournalDaoImpl;
import com.qdu.pojo.Journal;
import com.qdu.service.JournalService;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public class JournalServiceImpl implements JournalService {

    @Override
    public int saveJournal(Journal jou) {
        JournalDaoImpl jod = new JournalDaoImpl();
        return jod.saveJournal(jou);
    }

    @Override
    public List<Journal> lookupJournal(String userid) {
        JournalDaoImpl jod = new JournalDaoImpl();
        return jod.lookupJournal(userid);
    }

    @Override
    public int deletePost(Journal jou) {
        JournalDaoImpl jod = new JournalDaoImpl();
        return jod.deletePost(jou);
    }

    @Override
    public List<Journal> lookupallJournal() {
        JournalDaoImpl jod = new JournalDaoImpl();
        return jod.lookupallJournal();
    }

}
