package pl.kate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kate.entity.Product;
import pl.kate.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

    public boolean productExistsById(int id) {
        if(productRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //TODO: public Product saveExistingProduct

}

