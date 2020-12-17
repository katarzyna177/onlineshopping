package pl.kate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kate.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
