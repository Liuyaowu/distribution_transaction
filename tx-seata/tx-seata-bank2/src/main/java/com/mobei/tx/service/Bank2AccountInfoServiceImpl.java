package com.mobei.tx.service;

import com.mobei.tx.dao.AccountInfoDao;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class Bank2AccountInfoServiceImpl implements Bank2AccountInfoService {
    @Autowired
    AccountInfoDao accountInfoDao;

    /**
     * 张三已经开启了全局事务,这里就不用再开了
     */
//    @Transactional
    @Override
    public void updateAccountBalance(Double amount) {
        log.info("bank2 service begin,XID：{}", RootContext.getXID());
        log.error("李四增加:{}", amount);
        //李四增加金额
        accountInfoDao.updateAccountBalance("2", amount);
        if (amount == 20) {
            //人为制造异常
            int i = 1 / 0;
        }
    }
}
