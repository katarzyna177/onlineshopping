package pl.kate.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kate.order.Order;
import pl.kate.order.OrderService;
import java.net.URI;
import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> readAllOrders(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable long id){
        return orderService.getOrder(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        orderService.save(order);
        return ResponseEntity.created(URI.create("/" + order.getId())).build();
    }
}
