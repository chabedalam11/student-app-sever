package com.jtfc.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "product_name", length = 40)
    String productName;

    @Column(name = "description") //255
    String description;


}
