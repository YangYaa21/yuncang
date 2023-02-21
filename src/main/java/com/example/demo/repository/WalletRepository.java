package com.example.demo.repository;

import com.example.demo.pojo.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    @Transactional(rollbackFor = Exception.class)
    @Modifying()
    @Query(value = "UPDATE wallet SET amount = :#{#wallet.amount}, update_time = :#{#wallet.updateTime} where wallet_id = :#{#wallet.walletId}", nativeQuery = true)
    Integer updateMoney(Wallet wallet);

    Wallet findByUserId(String userId);
}
