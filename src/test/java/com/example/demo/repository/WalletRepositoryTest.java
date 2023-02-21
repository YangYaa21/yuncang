package com.example.demo.repository;

import com.example.demo.pojo.Wallet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@SpringBootTest
class WalletRepositoryTest {

    @Autowired
    private WalletRepository walletRepository;

    @Test
    void testSave() {
        Wallet wallet = new Wallet();
        //wallet.setWalletId(UUID.randomUUID().toString());
        wallet.setUserId("999");
        wallet.setAmount(new BigDecimal("666.00"));
        Wallet savedWallet = walletRepository.save(wallet);
        log.info(savedWallet.toString());
    }

    @Test
    void testFindById() {
        Optional<Wallet> optional = walletRepository.findById("499424729942327296");
        if (optional.isPresent()) {
            Wallet wallet = optional.get();
            Assert.isTrue(wallet.getAmount().equals(new BigDecimal("888.88")), "查询错误");
        } else {
            Assert.isTrue(false, "查询出错");
        }
    }

    @Test
    void testUpdateMoney() {
        Optional<Wallet> optional = walletRepository.findById("499424847579971584");
        if (optional.isPresent()) {
            Wallet wallet = optional.get();
            wallet.setAmount(new BigDecimal("999.99"));
            wallet.setUpdateTime(LocalDateTime.now());
            Integer updateMoney = walletRepository.updateMoney(wallet);
            Assert.isTrue(updateMoney.equals(1), "更新失败");
        } else {
            Assert.isTrue(false, "查询出错");
        }
    }

    @Test
    void findByUserId() {
        Wallet wallet = walletRepository.findByUserId("999");
        log.info(wallet.toString());
    }

}