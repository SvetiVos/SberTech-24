package com.example.repositories;

import com.example.models.Client;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class ClientRepository {
    private static final String JDBC = "jdbc:postgresql://localhost:8085/postgres?currentSchema=jdbc_sch&user=postgres&password=root";

    public long createClient(Client client, int cartId) {
        var insertSql = "INSERT INTO clients (name_client, login, password, email, cart_id) VALUES (?,?,?,?,?);";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, client.getNameClient());
            prepareStatement.setString(2, client.getLogin());
            prepareStatement.setString(3, client.getPassword());
            prepareStatement.setString(4, client.getEmail());
            prepareStatement.setInt(5, cartId);
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

    public Optional<Client> read(int clientId) {
        var selectSql = "SELECT * FROM clients where id_client = ?";

        try (var connection = DriverManager.getConnection(JDBC);
             var prepareStatement = connection.prepareStatement(selectSql)) {
            prepareStatement.setInt(1, id);

            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                int idClient = resultSet.getInt("id_client");
                String nameClient = resultSet.getString("name_client");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int cartId = resultSet.getInt("cart_id");

                Client client = new Client(idClient, nameClient, login, password, email, cartId);
                return Optional.of(client);
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
