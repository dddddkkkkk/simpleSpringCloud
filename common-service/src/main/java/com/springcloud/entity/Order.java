package com.springcloud.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    private Integer id;

    private Integer user_id;

    private Integer product_id;

    private Integer number;

    private BigDecimal price;

    private BigDecimal amount;

    private String product_name;

    private String username;


}
