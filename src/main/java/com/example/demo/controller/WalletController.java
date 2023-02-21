package com.example.demo.controller;

import com.example.demo.VO.WalletDetailVO;
import com.example.demo.VO.WalletVO;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    /**
     * 1. 查询用户钱包余额
     * @param userId
     * @return
     */
    @GetMapping("/getAmount")
    public WalletVO getWalletAmountByUserId(@RequestParam String userId) {
        return walletService.getWalletAmountByUserId(userId);
    }

    /**
     * 2. 用户消费100元的接口
     * @param walletVO
     * @return
     */
    @PutMapping("/consume")
    public WalletVO consume(WalletVO walletVO) {
        return walletService.consume(walletVO.getUserId(), walletVO.getAmount());
    }

    /**
     * 3. 用户退款20元接口
     * @param walletVO
     * @return
     */
    @PutMapping("/refund")
    public WalletVO refund(WalletVO walletVO) {
        return walletService.refund(walletVO.getUserId(), walletVO.getAmount());
    }

    /**
     * 4. 查询用户钱包金额变动明细的接口
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public List<WalletDetailVO> listAllChanges(@RequestParam String userId) {
        return walletService.listAllChangesByUserId(userId);
    }
}
