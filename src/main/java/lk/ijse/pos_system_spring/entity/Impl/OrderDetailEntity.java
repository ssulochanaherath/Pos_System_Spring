package lk.ijse.pos_system_spring.entity.Impl;

import jakarta.persistence.*;
import lk.ijse.pos_system_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetails")
@IdClass(OrderDetailEntity.class)
public class OrderDetailEntity implements SuperEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private OrderEntity order;
    @Id
    @ManyToOne
    @JoinColumn(name = "ItemId",nullable = false)
    private ItemEntity item;
    private int qty;
    private double unitPrice;
    private double total;
}
