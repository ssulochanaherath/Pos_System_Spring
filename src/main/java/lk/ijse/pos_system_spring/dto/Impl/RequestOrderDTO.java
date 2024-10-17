package lk.ijse.pos_system_spring.dto.Impl;

import lk.ijse.pos_system_spring.dto.RequestOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDTO implements RequestOrderStatus {
    private OrderDTO orderDTO;
    private List<OrderDetailsDTO> orderDetailsDTOList;

}
