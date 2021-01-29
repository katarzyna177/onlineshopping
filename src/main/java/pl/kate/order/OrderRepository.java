package pl.kate.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kate.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
