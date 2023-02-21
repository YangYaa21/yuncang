package com.example.demo.repository;

import com.example.demo.pojo.WalletDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletDetailRepository extends JpaRepository<WalletDetail, String> {

    List<WalletDetail> findAllByUserId(String userId);
}
