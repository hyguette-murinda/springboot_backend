package com.java.main.springstarter.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "carts")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "cart", orphanRemoval = true)
    @JsonIgnore
    private List<CartItem> items = new ArrayList<>();
    public  Cart(User user){
        this.user=user;
    }

}
