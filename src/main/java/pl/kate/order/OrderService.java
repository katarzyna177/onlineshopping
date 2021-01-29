package pl.kate.order;

import org.springframework.stereotype.Service;
import pl.kate.order.Order;
import pl.kate.order.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(long id){
        return orderRepository.findById(id);
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}

