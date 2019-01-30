package br.com.bb.controller;

import br.com.bb.repository.ProductRepository;
import br.com.bb.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivasch
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/listByCategory/{categoryId}")
    public ResponseEntity<List<Product>> listByCategory(@PathVariable Integer categoryId) {

        List<Product> products = productRepository.findProductByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

}
