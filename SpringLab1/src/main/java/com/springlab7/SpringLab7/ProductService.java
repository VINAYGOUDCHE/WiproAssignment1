package com.springlab7.SpringLab7;

public class ProductService {
    private ProductDao dao;

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public Product getProductDetails(int product_code) {
        return dao.getProductDetails(product_code);
    }

    public double calculatePrice(int quantity, double price) {
        return quantity * price;
    }

    public boolean validateProductCode(int code) {
        return code > 0 && String.valueOf(code).length() == 4;
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}