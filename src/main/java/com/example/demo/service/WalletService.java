package com.example.demo.service;

import com.example.demo.VO.WalletDetailVO;
import com.example.demo.VO.WalletVO;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {

    /**
     * 查询钱包余额
     * @param userId
     * @return
     */
    WalletVO getWalletAmountByUserId(String userId);

    /**
     * 用户消费
     * @param userId
     * @param number
     * @return
     */
    WalletVO consume(String userId, BigDecimal number);

    /**
     * 用户退款
     * @param userId
     * @param number
     * @return
     */
    WalletVO refund(String userId, BigDecimal number);

    /**
     * 查询用户钱包金额变动明细
     * @param userId
     * @return
     */
    List<WalletDetailVO> listAllChangesByUserId(String userId);

}
