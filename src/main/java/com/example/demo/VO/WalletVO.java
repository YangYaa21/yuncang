package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WalletVO implements Serializable {

    private static final long serialVersionUID = 5714381870111222427L;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 金额
     */
    private BigDecimal amount;
}
