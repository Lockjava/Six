/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.pojo.Demandapply;
import com.qdu.pojo.Speapply;
import com.qdu.pojo.Useridentity;
import java.util.List;

/**
 *
 * @author 刘凯
 */
public interface SomeDataDao {

    int saveAplySpeDao(Speapply speapply);

    int saveAplyDemandDao(Demandapply demandapply);

    List<Object[]> lookupspeapply();

    int deletespeapply(String userId);

    int updateUseridentity(Useridentity urd);

    Useridentity lookupUseridentity(String userId);

    List<Object[]> lookupneedapply();

    int deleteneedapply(String userId);

}
