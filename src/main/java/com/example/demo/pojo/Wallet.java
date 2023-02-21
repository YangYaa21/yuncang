package com.example.demo.pojo;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class Wallet {

    @Id
    @GenericGenerator(name = "snowFlakeIdGenerator", strategy = "com.example.demo.utils.SnowFlakeIdGenerator")
    @GeneratedValue(generator = "snowFlakeIdGenerator")
    private String walletId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 账户余额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @ColumnDefault("false")
    private Boolean isDeleted;
}
