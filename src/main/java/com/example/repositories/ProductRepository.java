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

@Repository
public class ProductRepository {

    public static final String JDBC = "jdbc:h2://localhost:8085/SCHEMA=jdbc_sch;USER=admin;PASSWORD=root";

    public long createProduct(Product product) {
        var insertSql = "INSERT INTO products (name, price, quantity) VALUES (?,?,?);";
        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setString(1, product.getName());
            prepareStatement.setInt(2, product.getPrice());
            prepareStatement.setInt(3, product.getQuantity());
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


    public boolean deleteProduct(int id) {
        var selectSql = "DELETE FROM products where id_product = ?";
        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(selectSql)) {
            prepareStatement.setInt(1, id);

            int rows = prepareStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> search(int id) {
        var selectSql = "SELECT * FROM products where id_product = ?";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(selectSql)) {
            prepareStatement.setInt(1, id);

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                int idProduct = rs.getInt("id_product");
                String name = rs.getString("name_product");
                int price = rs.getInt("pricet");
                int quantity = rs.getInt("quantity");
                Product product = new Product(idProduct, name, price, quantity);

                return Optional.of(product);
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

