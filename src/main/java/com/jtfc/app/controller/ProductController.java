package com.jtfc.app.controller;

import com.jtfc.app.entity.Product;
import com.jtfc.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

   @Autowired
   ProductService service;

    @PostMapping(value = "/save-product")
    public String saveProduct(@Valid @RequestBody Product product){
        Boolean res = service.saveProductInfoInDB(product);
        if(res){
            return "Data Successfully Saved";
        }else {
            return "Opps! Data not saved";
        }
    }

    @PostMapping(value = "/save-product-list")
    public String saveProductList(@RequestBody List<Product> productList){
        Boolean res = service.saveProductInfoListInDB(productList);
        if(res){
            return "Data Successfully Saved";
        }else {
            return "Opps! Data not saved";
        }
    }

    @PutMapping(value = "/update-product")
    public String updateProduct(@RequestBody Product Product){
        Boolean res = service.updateProductInfoInDB(Product);
        if(res){
            return "Data Successfully Update";
        }else {
            return "Opps! Data not Update";
        }
    }

    @DeleteMapping(value = "delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        Boolean res = service.deleteProductInfoInDB(id);
        if(res){
            return "Data Successfully Delete";
        }else {
            return "Opps! Data not Delete";
        }
    }

    @GetMapping(value = "get-product")
    public List<Product> getProduct(){
        return service.getProductInfoInDB();
    }

}

