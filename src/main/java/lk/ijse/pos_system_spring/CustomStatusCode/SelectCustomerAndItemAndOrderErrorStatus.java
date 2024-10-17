package lk.ijse.pos_system_spring.CustomStatusCode;

import lk.ijse.pos_system_spring.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectCustomerAndItemAndOrderErrorStatus implements CustomerStatus, ItemStatus , OrderStatus, OrderDetailsStatus, RequestOrderStatus {
    private int statusCode;
    private String statusMassage;
}
