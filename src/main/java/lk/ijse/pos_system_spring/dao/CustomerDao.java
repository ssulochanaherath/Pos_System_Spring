package lk.ijse.pos_system_spring.dao;

import lk.ijse.pos_system_spring.entity.Impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
