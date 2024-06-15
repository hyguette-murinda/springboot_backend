package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreateCartDto;
import com.java.main.springstarter.v1.exceptions.BadRequestException;
import com.java.main.springstarter.v1.exceptions.ResourceNotFoundException;
import com.java.main.springstarter.v1.models.*;
import com.java.main.springstarter.v1.repositories.ICartItemRepository;
import com.java.main.springstarter.v1.repositories.ICartRepository;
import com.java.main.springstarter.v1.repositories.IPurchaseRepository;
import com.java.main.springstarter.v1.services.CartService;
import com.java.main.springstarter.v1.services.IUserService;
import com.java.main.springstarter.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ICartRepository cartRepository;
    private final IUserService userService;
    private final ProductService productService;
    private final ICartItemRepository cartItemRepository;
    private final IPurchaseRepository purchasedRepository;
    @Override
    public Cart save() {
        User user = this.userService.getLoggedInUser();
        System.out.println(user.getFirstName());
       return this.cartRepository.save( new Cart(user));
    }
    @Override
    public CartItem addProductToCart(Long productId, int quantity) {
        System.out.println("here");
        User user = this.userService.getLoggedInUser();
        System.out.println(user.getEmail());
        Cart cart = this.cartRepository.findByUser_Id(user.getId()).orElseThrow(() -> new BadRequestException("Cart with user id [" + user.getId() + "] not found"));
        Product product = this.productService.findById(productId);
        CartItem cartItem= new CartItem(cart,product,quantity,product.getPrice()*quantity);
        cartItemRepository.save(cartItem);
        return cartItem;
    }
    @Override
    public Cart emptyCart() {
        User user = this.userService.getLoggedInUser();
        Cart cart = this.cartRepository.findByUser_Id(user.getId()).orElseThrow(() -> new BadRequestException("Cart not found"));
        cart.setItems(new ArrayList<>());
        return this.cartRepository.save(cart);
    }

    @Override
    public List<CartItem> allCartItems(Long cartId) {
        try{
            Cart cart =cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", cartId));
            return cartItemRepository.findAllByCart(cart);

        }catch (Exception e){
            throw  e;
        }



    }

    @Override
    public Purchase purchaseItems() {
        User user = this.userService.getLoggedInUser();
        Cart cart = this.cartRepository.findByUser_Id(user.getId()).orElseThrow(() -> new BadRequestException("Cart not found"));
        if (cart.getItems().isEmpty()) {
            throw new BadRequestException("No items in cart");
        }
        Purchase purchased = new Purchase();
        double total = cart.getItems().stream()
                .mapToDouble(CartItem::getTotalForProduct)
                .sum();
        purchased.setPurchasedProducts(cart.getItems());
        purchased.setTotal(total);
        this.purchasedRepository.save(purchased);
        this.cartItemRepository.deleteAll(cart.getItems());
        return purchased;
    }
}
