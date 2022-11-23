package com.foodDelivery.demo.Exception;

class CategoryNotFoundException extends RuntimeException {

    CategoryNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
