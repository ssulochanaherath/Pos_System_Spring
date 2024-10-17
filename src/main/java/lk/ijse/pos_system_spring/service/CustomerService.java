package lk.ijse.pos_system_spring.service;

import lk.ijse.pos_system_spring.dto.CustomerStatus;
import lk.ijse.pos_system_spring.dto.Impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerStatus searchCustomer(String customerId);

    List<CustomerDTO> getAllCustomers();

    void updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);
}
