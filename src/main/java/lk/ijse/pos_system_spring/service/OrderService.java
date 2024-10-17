package lk.ijse.pos_system_spring.service;

import lk.ijse.pos_system_spring.dto.Impl.OrderDTO;
import lk.ijse.pos_system_spring.dto.Impl.OrderDetailsDTO;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOList);

    List<OrderDTO> getAllOrders();
}
