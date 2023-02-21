package com.example.demo.service.impl;

import com.example.demo.VO.WalletDetailVO;
import com.example.demo.VO.WalletVO;
import com.example.demo.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class WalletServiceImplTest {

    @Autowired
    private WalletService walletService;

    @Test
    void getWalletAmountByUserId() {
        WalletVO walletAmountByUserId = walletService.getWalletAmountByUserId("999");
        log.info(walletAmountByUserId.toString());
    }

    @Test
    void consume() {
        WalletVO walletVO = walletService.consume("999", new BigDecimal("100"));

        log.info(walletVO.toString());
    }

    @Test
    void refund() {
        WalletVO walletVO = walletService.refund("999", new BigDecimal("20"));

        log.info(walletVO.toString());
    }

    @Test
    void listAllChangesByUserId() {
        List<WalletDetailVO> walletDetailVOList = walletService.listAllChangesByUserId("999");
        log.info(walletDetailVOList.toString());
    }
}