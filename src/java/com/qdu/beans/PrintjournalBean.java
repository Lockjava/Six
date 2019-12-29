/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.qdu.pojo.Journal;
import com.qdu.service.impl.JournalServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 刘凯
 */
@Named
@RequestScoped
public class PrintjournalBean implements Serializable {

    private List<Journal> jourlist = new ArrayList();
    private Journal jos;

    public Journal getJos() {
        return jos;
    }

    public List<Journal> getJourlist() {
        return jourlist;
    }

    public PrintjournalBean() {
        JournalServiceImpl josi = new JournalServiceImpl();
        jourlist = josi.lookupallJournal();
    }

    public String detailedJournal1(Journal jou) {
        jos = jou;
        return "recordLife1";

    }

}
