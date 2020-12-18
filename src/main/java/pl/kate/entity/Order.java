package pl.kate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;
    private String PaymentType;
    private String deliveryAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<Product> products;

    public Order() {
    }

    public Order(int id, String paymentType, String deliveryAddress) {
        this.id = id;
        PaymentType = paymentType;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
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
                ", PaymentType='" + PaymentType + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}
