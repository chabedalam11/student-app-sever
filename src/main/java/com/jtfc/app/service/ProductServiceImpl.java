package com.jtfc.app.service;

import com.jtfc.app.entity.Product;
import com.jtfc.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean saveProductInfoInDB(Product product) {
        System.out.println();
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean saveProductInfoListInDB(List<Product> productList) {
        productRepository.saveAll(productList);
        return true;
    }

    @Override
    public boolean updateProductInfoInDB(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteProductInfoInDB(Integer id) {
        Long l = Long.valueOf(id.longValue());
        Product product = new Product(l);
        productRepository.delete(product);
        return true;
    }

    @Override
    public List<Product> getProductInfoInDB() {
        return productRepository.findAll();
    }
}
