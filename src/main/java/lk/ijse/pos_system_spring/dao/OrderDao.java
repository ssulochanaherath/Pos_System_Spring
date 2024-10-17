package lk.ijse.pos_system_spring.dao;

import lk.ijse.pos_system_spring.entity.Impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity,String> {

}
