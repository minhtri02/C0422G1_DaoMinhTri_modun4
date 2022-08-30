package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService implements ICartService {
    private Map<Product,Integer> products = new HashMap<>();

    @Override
    public void addProduct(Map<Product, Integer> cart, Product product, String expression) {
        if (cart.containsKey(product)) {
            if (expression.equals("+"))
                cart.put(product, cart.get(product) + 1);
            else {
                if(cart.get(product)>0)
                    cart.put(product, cart.get(product) - 1);
                else cart.remove(product);
            }
        } else cart.put(product, 1);
    }

    @Override
    public double getTotal(Map<Product, Integer> cart) {
        double total = 0;
        for (Product p : cart.keySet()){
            total += p.getPrice()*cart.get(p);
        }
        return total;
    }
}
