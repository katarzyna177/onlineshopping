package pl.kate.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(long id){
        productRepository.deleteById(id);
    }

    public boolean productExistsById(long id) {
        if(productRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //TODO: public Product saveExistingProduct

}

