package com.camping.camp.Controllers;

import com.camping.camp.dto.ProductDto;
import com.camping.camp.Exception.product.ProductExceptions;
import com.camping.camp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProduct() throws ProductExceptions {
            return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductById(@PathVariable Long productId) throws ProductExceptions{
            return new ResponseEntity<>(productService.getProductByID(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        productService.patchProduct(productDto , id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
