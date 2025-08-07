package com.springlab7.SpringLab7;

//DAO interface to fetch data
public interface ProductDao {
    Product getProductDetails(int product_code);
}