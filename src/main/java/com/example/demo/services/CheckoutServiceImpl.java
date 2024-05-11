package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartRepository cartRepository;

    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
//        Customer customer = purchaseData.getCustomer();

        cart.setStatus(StatusType.ordered);
        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cartItem.setCart(cart));

        cartRepository.save(cart);
        final Cart cart2 ;
        cart2 = cartRepository.findAll().get(cartRepository.findAll().size()-1);
        cartItems.forEach(cartItem -> cartItem.setCart(cart2));
        cartItems.forEach(cartItem -> cartItemRepository.save(cartItem));
        return new PurchaseResponse(orderTrackingNumber);

    }

}

