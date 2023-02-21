package com.example.demo.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class WalletDetail {

    @Id
    @GenericGenerator(name = "snowFlakeIdGenerator", strategy = "com.example.demo.utils.SnowFlakeIdGenerator")
    @GeneratedValue(generator = "snowFlakeIdGenerator")
    private String walletDetailId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 钱包Id
     */
    private String walletId;

    /**
     * 变动金额
     */
    private BigDecimal amountChange;

    /**
     * 剩余金额
     */
    private BigDecimal remainingAmount;

    /**
     * 金额变动描述
     */
    private String description;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;

}
