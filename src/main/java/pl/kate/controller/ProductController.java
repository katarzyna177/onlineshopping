package pl.kate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kate.entity.Product;
import pl.kate.service.ProductService;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> readAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*@PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updateProduct){
        if(!productService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updateProduct.setId(id);
        productService.save(updateProduct);
        return ResponseEntity.noContent().build();
    }*/

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.created(URI.create("/" + product.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
