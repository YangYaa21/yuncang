package com.example.demo.VO;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletDetailVO implements Serializable {

    private static final long serialVersionUID = -3316482359875506182L;

    /**
     * 用户Id
     */
    private String userId;

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
