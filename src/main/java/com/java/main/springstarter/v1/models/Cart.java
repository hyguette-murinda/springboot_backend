package com.java.main.springstarter.v1.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    private User user;
//    @OneToMany(mappedBy = "cart")
//    private List<CartItem> cartItems = new ArrayList<>();

}

