package ma.enset.inventoryservice.web;


import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository ) {
        this.productRepository = productRepository;

    }
    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Product getProductById(@PathVariable String id) {

        return productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("product not found")
        );
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }

}
