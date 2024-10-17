package lk.ijse.pos_system_spring.dto.Impl;

import lk.ijse.pos_system_spring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String orderId;
    private String customerId;
    private String date;
    private double netTotal;
    private double discount;
    private double subTotal;
    private List<OrderDetailsDTO> orderDetails;
}
