package pl.kate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kate.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
    boolean existsById(Integer integer);

}
