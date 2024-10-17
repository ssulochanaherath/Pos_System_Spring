package lk.ijse.pos_system_spring.service.Impl;

import lk.ijse.pos_system_spring.dao.CustomerDao;
import lk.ijse.pos_system_spring.dao.ItemDao;
import lk.ijse.pos_system_spring.dao.OrderDao;
import lk.ijse.pos_system_spring.dao.OrderDetailDao;
import lk.ijse.pos_system_spring.dto.Impl.OrderDTO;
import lk.ijse.pos_system_spring.dto.Impl.OrderDetailsDTO;
import lk.ijse.pos_system_spring.entity.Impl.CustomerEntity;
import lk.ijse.pos_system_spring.entity.Impl.ItemEntity;
import lk.ijse.pos_system_spring.entity.Impl.OrderDetailEntity;
import lk.ijse.pos_system_spring.entity.Impl.OrderEntity;
import lk.ijse.pos_system_spring.exception.DataPersistException;
import lk.ijse.pos_system_spring.exception.ItemNotFoundException;
import lk.ijse.pos_system_spring.service.OrderService;
import lk.ijse.pos_system_spring.util.AppUtil;
import lk.ijse.pos_system_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping orderMapping;

    @Override
    public void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOList) {
        orderDTO.setOrderId(AppUtil.generateOrderId());
        Optional<CustomerEntity>customer = customerDao.findById(orderDTO.getCustomerId());
        OrderEntity tempOrder = orderMapping.toOrderEntity(orderDTO);
        tempOrder.setCustomer(customer.get());

        OrderEntity savedOrder = orderDao.save(tempOrder);
        if (savedOrder==null){
            throw new DataPersistException("Order is not saved !");
        }
        //order Details and Item

        for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOList){
            OrderDetailEntity orderDetailEntity = orderMapping.toOrderDetailEntity(orderDetailsDTO);
            orderDetailEntity.setOrder(savedOrder);

            Optional<ItemEntity>selectItem= itemDao.findById(orderDetailsDTO.getItemId());
            if (selectItem==null){
                throw new ItemNotFoundException("Item is not found!");
            }
            orderDetailEntity.setItem(selectItem.get());
            OrderDetailEntity savedOrderDetail=orderDetailDao.save(orderDetailEntity);

            //Item
            ItemEntity item=selectItem.get();
            int updateQty= item.getQty() - orderDetailsDTO.getQty();

            item.setQty(updateQty);
            ItemEntity updateItem=itemDao.save(item);

            if (savedOrderDetail == null || updateItem == null) {
                throw new DataPersistException("Order Detail not saved");
            }

        }

    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> allOrders=orderDao.findAll();
        return orderMapping.asOrderDtoLIst(allOrders);
    }
}
