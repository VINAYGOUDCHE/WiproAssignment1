package com.springlab7.SpringLab7;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product getProductDetails(int product_code) {
        String sql = "SELECT * FROM product WHERE product_code = ?";
        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Product p = new Product();
            p.setProduct_code(rs.getInt("product_code"));
            p.setProduct_name(rs.getString("product_name"));
            p.setProduct_category(rs.getString("product_category"));
            p.setProduct_description(rs.getString("product_description"));
            p.setProduct_price(rs.getDouble("product_price"));
            return p;
        }, product_code);
    }

    // Insert initial records if not present
    public void initializeSampleData() {
        String sql = "INSERT INTO product (product_code, product_name, product_category, product_description, product_price) VALUES (?, ?, ?, ?, ?)";

        List<Integer> existingCodes = jdbcTemplate.query("SELECT product_code FROM product",
            (ResultSet rs, int rowNum) -> rs.getInt("product_code"));

        if (!existingCodes.contains(1001))
            jdbcTemplate.update(sql, 1001, "Washing Machine", "electronics", "Semi Automatic", 18000);
        if (!existingCodes.contains(1002))
            jdbcTemplate.update(sql, 1002, "LEDTV", "electronics", "TV", 45000);
        if (!existingCodes.contains(1003))
            jdbcTemplate.update(sql, 1003, "Rice Bag", "groceries", "25kg pack", 1250);
    }

    // 📦 Fetch all products for hint display
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Product p = new Product();
            p.setProduct_code(rs.getInt("product_code"));
            p.setProduct_name(rs.getString("product_name"));
            p.setProduct_category(rs.getString("product_category"));
            p.setProduct_description(rs.getString("product_description"));
            p.setProduct_price(rs.getDouble("product_price"));
            return p;
        });
    }
}