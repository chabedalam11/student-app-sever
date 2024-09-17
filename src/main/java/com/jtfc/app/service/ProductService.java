package com.jtfc.app.service;

import com.jtfc.app.entity.Product;

import java.util.List;

public interface ProductService {
    boolean saveProductInfoInDB(Product product);
    boolean saveProductInfoListInDB(List<Product> productList);
    boolean updateProductInfoInDB(Product product);
    boolean deleteProductInfoInDB( Integer id);
    List<Product> getProductInfoInDB();
}
