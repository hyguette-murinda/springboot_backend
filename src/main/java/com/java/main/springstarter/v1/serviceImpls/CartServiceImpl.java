package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.models.Cart;
import com.java.main.springstarter.v1.repositories.ICartRepository;
import com.java.main.springstarter.v1.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ICartRepository cartRepository;
    @Override
    public Cart addCart(CreateCartDto cart){
        Cart cart1 = new Cart();
        cart1.setUser(cart.getUser());
        return cartRepository.save(cart1);
    }
    @Override
    public void removeCartWithId(Long cartId){
        cartRepository.deleteById(cartId);
    }
    @Override
    public void removeAllCart(){
        cartRepository.deleteAll();
    }
}
