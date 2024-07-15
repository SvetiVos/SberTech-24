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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import com.example.models.Product;


@Repository
public class CartRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long createCart() {
        String insertSql = "INSERT INTO carts (promoCode) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.preparedStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "uuu555");
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().get("id_cart");
    }

    public int addProductToCart(int id, int cartId) {
        String insertSql = "INSERT INTO products_carts (id_cart, id_product, quantity) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.preparedStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, cartId);
            preparedStatement.setInt(3, 1);
            preparedStatement.executeUpdate();
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().get("id_products_cart");
    }

    public boolean removeProductFromCart(int cartId, int id) {
        String deleteSql = "DELETE FROM products_carts WHERE id_cart = ? AND id_product = ?";

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.preparedStatement(deleteSql);
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            return preparedStatement;
        };

        int rows = jdbcTemplate.update(preparedStatementCreator);
        return rows > 0;
    }

    public void pay(int cartId) {
        final String deleteSql = "DELETE FROM products_carts where id_cart = ?";
        jdbcTemplate.update(deleteSql, cartId);
    }

    public List<Product> getProductsInCart(int cartId) {
        String selectSql = "SELECT p.* " +
                "FROM products p " +
                "JOIN products_carts pc ON p.id_product = pc.id_product " +
                "WHERE pc.id_cart = ?";
        return jdbcTemplate.query(selectSql, new Object[]{cartId}, (rs, rowNum) -> {
            return new Product(
                    rs.getInt("id_product"),
                    rs.getString("name_product"),
                    rs.getInt("price"),
                    rs.getInt("quantity")
            );
        });
    }

    public void clearCart(int cartId) {
        String deleteSql = "DELETE FROM products_carts WHERE id_cart = ?";
        jdbcTemplate.update(deleteSql, cartId);
    }
}

