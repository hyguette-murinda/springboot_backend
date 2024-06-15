package com.java.main.springstarter.v1.models;

import com.java.main.springstarter.v1.audits.InitiatorAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code")
    private long id;

    @Column(name = "name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "price")
    private double price;

    private LocalDateTime inDate;

    private String image;

    @OneToOne
    private Quantity quantity;

    public Product(String productName, String productType, double price, Quantity quantity, String image) {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }
}