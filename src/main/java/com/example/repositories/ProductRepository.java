package com.example.repositories;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Optional;
import lombok.var;
import com.example.models.Product;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long createProduct(Product product) {
        String insertSql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().get("id_product");
    }

    public boolean deleteProduct(int id) {
        String deleteSql = "DELETE FROM products WHERE id_product = ?";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var preparedStatement = connection.preparedStatement(deleteSql);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };

        int rows = jdbcTemplate.update(preparedStatementCreator);
        return rows > 0;
    }

    public Optional<Product> search(int id) {
        String selectSql = "SELECT * FROM products WHERE id_product = ?";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.preparedStatement(selectSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("id_product");
            String name = resultSet.getString("name_product");
            int price = resultSet.getInt("price");
            int quantity = resultSet.getInt("quantity");
            String email = resultSet.getString("email");
            return new Product(id, name, price, quantity);
        }
        List<Product> products = jdbcTemplate.query(preparedStatementCreator, Product(id, name, price, quantity));

        return products.stream().findFirst();
    }

    public boolean updateProductQuantity(int id, int quantity) {
        String updateSql = "UPDATE products SET quantity = ? WHERE id_product = ?";
        return jdbcTemplate.update(updateSql, quantity, id) > 0;
    }

}

