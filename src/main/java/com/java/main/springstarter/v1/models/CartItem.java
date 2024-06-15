package com.java.main.springstarter.v1.models;

import javax.persistence.*;

import com.java.main.springstarter.v1.audits.TimestampAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart_items")
public class CartItem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private Cart cart;

    @OneToOne()
    @JoinColumn(name = "product_code")
    private Product product;

    private int quantity;

    @Column(name = "total_for_product")
    private double totalForProduct;

    public CartItem(Cart cart,Product product,int quantity,double totalForProduct){
        this.cart=cart;
        this.product=product;
        this.quantity=quantity;
        this.totalForProduct=totalForProduct;
    }

}
