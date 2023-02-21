package com.example.demo.service.impl;

import com.example.demo.VO.WalletDetailVO;
import com.example.demo.VO.WalletVO;
import com.example.demo.pojo.Wallet;
import com.example.demo.pojo.WalletDetail;
import com.example.demo.repository.WalletDetailRepository;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.WalletService;
import com.example.demo.utils.CopyClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletDetailRepository walletDetailRepository;

    /**
     * 查询钱包余额
     * @param userId
     * @return
     */
    @Override
    public WalletVO getWalletAmountByUserId(String userId) {
        Wallet wallet = walletRepository.findByUserId(userId);

        WalletVO walletVO = new WalletVO();
        walletVO.setUserId(wallet.getUserId());
        walletVO.setAmount(wallet.getAmount());

        return walletVO;
    }

    /**
     * 用户消费
     * @param userId
     * @param number
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WalletVO consume(String userId, BigDecimal number) {

        if (number.signum() == -1) {
            throw new RuntimeException("金额错误，不能为负");
        }

        Wallet wallet = walletRepository.findByUserId(userId);
        // 剩余金额 = 当前账户余额 - 消费金额
        BigDecimal remainingAmount = wallet.getAmount().subtract(number);

        if (remainingAmount.signum() == -1) {
            throw new RuntimeException("余额不足");
        }

        // 余额充足，更新 wallet 表、wallet_detail 表
        wallet.setAmount(remainingAmount);
        wallet.setUpdateTime(LocalDateTime.now());
        Integer flag = walletRepository.updateMoney(wallet);

        if (flag.equals(0)) {
            throw new RuntimeException("更新账户信息失败");
        }

        WalletDetail walletDetail = new WalletDetail();
        walletDetail.setUserId(wallet.getUserId());
        walletDetail.setWalletId(wallet.getWalletId());
        walletDetail.setAmountChange(number.negate());
        walletDetail.setRemainingAmount(remainingAmount);
        walletDetail.setDescription("消费");
        walletDetailRepository.save(walletDetail);

        WalletVO walletVO = new WalletVO();
        walletVO.setUserId(userId);
        walletVO.setAmount(remainingAmount);

        return walletVO;
    }

    /**
     * 用户退款
     * @param userId
     * @param number
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WalletVO refund(String userId, BigDecimal number) {

        if (number.signum() == -1) {
            throw new RuntimeException("金额错误，不能为负");
        }

        Wallet wallet = walletRepository.findByUserId(userId);
        // 剩余金额 = 当前账户余额 + 退款金额
        BigDecimal remainingAmount = wallet.getAmount().add(number);

        wallet.setAmount(remainingAmount);
        wallet.setUpdateTime(LocalDateTime.now());
        Integer flag = walletRepository.updateMoney(wallet);

        if (flag.equals(0)) {
            throw new RuntimeException("更新账户信息失败");
        }

        WalletDetail walletDetail = new WalletDetail();
        walletDetail.setUserId(wallet.getUserId());
        walletDetail.setWalletId(wallet.getWalletId());
        walletDetail.setAmountChange(number);
        walletDetail.setRemainingAmount(remainingAmount);
        walletDetail.setDescription("退款");
        walletDetailRepository.save(walletDetail);

        WalletVO walletVO = new WalletVO();
        walletVO.setUserId(userId);
        walletVO.setAmount(remainingAmount);

        return walletVO;
    }

    /**
     * 查询用户钱包金额变动明细
     * @param userId
     * @return
     */
    @Override
    public List<WalletDetailVO> listAllChangesByUserId(String userId) {
        List<WalletDetail> walletDetails = walletDetailRepository.findAllByUserId(userId);
        // 实体转换工具类 CopyClassUtil
        return CopyClassUtil.copyClassList(walletDetails, WalletDetailVO.class);
    }
}
