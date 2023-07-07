package com.example.jpatest;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class OrderDetailId implements Serializable {
    private int orderId;

    private int productId;
}
