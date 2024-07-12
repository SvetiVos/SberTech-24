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

@Repository
public class CartRepository {

    public static final String JDBC = "jdbc:postgresql://localhost:8085/postgres?currentSchema=jdbc_sch&user=postgres&password=root";

    public long createCart() {
        var insertSql = "INSERT INTO cart (promoCode) VALUES (?);";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, "555uuu");
            prepareStatement.executeUpdate();

            ResultSet rs = prepareStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new RuntimeException("Ошибка при получении идентификатора");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addProductToCart(int id, int cartId) {
        var insertSql = "INSERT INTO products_carts (id_cart, id_product, quantity) VALUES (?,?,?);";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, id);
            prepareStatement.setInt(2, cartId);
            prepareStatement.setInt(3, 1);
            prepareStatement.executeUpdate();

            ResultSet rs = prepareStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new RuntimeException("Ошибка при получении идентификатора");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeProductFromCart(int cartId, int id) {
        var selectSql = "DELETE FROM products where (id_cart = ?, id_product = ?)";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(selectSql)) {
            prepareStatement.setInt(1, cartId);
            prepareStatement.setInt(2, id);

            var rows = prepareStatement.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

