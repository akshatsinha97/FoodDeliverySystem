package com.foodDelivery.demo.Exception;

public class CartItemNotExistException extends IllegalArgumentException{
    public CartItemNotExistException(String msg) {
        super(msg);
    }
}
