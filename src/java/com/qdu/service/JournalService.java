/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.pojo.Journal;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface JournalService {

    int saveJournal(Journal jou);

    List<Journal> lookupJournal(String userid);

    int deletePost(Journal jou);

    List<Journal> lookupallJournal();
}
