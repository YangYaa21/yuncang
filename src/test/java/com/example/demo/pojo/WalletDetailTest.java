package com.example.demo.pojo;

import com.example.demo.repository.WalletDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class WalletDetailTest {

    @Autowired
    private WalletDetailRepository repository;

    @Test
    void save() {
        WalletDetail walletDetail = new WalletDetail();
        walletDetail.setUserId("999");
        walletDetail.setWalletId("499424847579971584");
        walletDetail.setAmountChange(new BigDecimal(-100));
        walletDetail.setRemainingAmount(new BigDecimal("788.88"));
        walletDetail.setDescription("购物");
        WalletDetail detail = repository.save(walletDetail);
        log.info(detail.toString());

    }

    @Test
    void getWalletDetailsByUserId() {
        List<WalletDetail> walletDetails = repository.findAllByUserId("999");
        log.info(walletDetails.toString());
    }
}