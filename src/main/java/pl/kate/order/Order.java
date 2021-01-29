package pl.kate.order;

import pl.kate.product.Product;
import pl.kate.notification.Observer;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private String paymentType;
    private String deliveryAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<Product> products;

    public Order() {
    }

    public Order(Long id, OrderStatus orderStatus, String paymentType, String deliveryAddress) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }

}
