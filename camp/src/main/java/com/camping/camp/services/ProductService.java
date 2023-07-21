package com.camping.camp.services;

import com.camping.camp.dto.ProductDto;
import com.camping.camp.entities.Product;
import com.camping.camp.Exception.product.ProductExceptions;
import com.camping.camp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    @Autowired
    private static ProductRepository productRepository;

    public List<ProductDto> getAllProduct() throws ProductExceptions {
        List<Product> com = productRepository.findAll();
        return com.stream().map(this::mapProductToDto).collect(toList());
    }

    public Product getProductByID(Long id) throws ProductExceptions {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else
            throw new ProductExceptions("the product with id: " + id + "NotExist");

    }

    public void createProduct(ProductDto productDto) {
        Product product = mapFromDtoToProduct(productDto);
        productRepository.save(product);
    }

    public void patchProduct(ProductDto productDto, Long id) {
        Optional<Product> updateProduct = productRepository.findById(id);
        updateProduct = Optional.of(mapFromDtoToProduct(productDto));
        productRepository.save(updateProduct.get());
    }

    private ProductDto mapProductToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setIdProduct(product.getIdProduct());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setImage(product.getImage());
        productDto.setRate(product.getRate());

        return productDto;
    }

    private Product mapFromDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setIdProduct(productDto.getIdProduct());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setRate(productDto.getRate());

        return product;
    }
}
