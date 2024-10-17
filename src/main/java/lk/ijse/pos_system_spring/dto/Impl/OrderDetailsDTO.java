package lk.ijse.pos_system_spring.dto.Impl;

import lk.ijse.pos_system_spring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements OrderDetailsStatus {
    /*private String orderId;*/
    private String itemId;
    private int qty;
    private double unitPrice;
    private double total;
}
