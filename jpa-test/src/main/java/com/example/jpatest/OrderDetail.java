package com.example.jpatest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_detail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @Id
    @Column(name="order_id")
    public int orderId;

    @Id
    @Column(name="product_id")
    public int productId;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="price", nullable = false)
    private float price;

    @Column(name="amount", nullable = false)
    private float amount;
}