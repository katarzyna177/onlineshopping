package pl.kate.service;

import org.springframework.stereotype.Service;
import pl.kate.entity.Order;
import pl.kate.repository.OrderRepository;
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

    public Optional<Order> getOrder(int id){
        return orderRepository.findById(id);
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}

