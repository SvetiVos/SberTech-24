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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long createClient(Client client, int cartId) {
        String insertSql = "INSERT INTO clients (name_client, login, password, email, cart_id) VALUES (?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.preparedStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getNameClient());
            preparedStatement.setString(2, client.getLogin());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setInt(5, cartId);
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().get("id_client");
    }

    public Optional<Client> read(int clientId) {
        String selectSql = "SELECT * FROM clients where id_client = ?";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, clientId);
            return preparedStatement;
        };

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int idClient = resultSet.getInt("id_client");
            String nameClient = resultSet.getString("name_client");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            int cartId = resultSet.getInt("cart_id");
            return new Client(idClient, nameClient, login, password, email, cartId);
        }
        List<Client> clients = jdbcTemplate.query(preparedStatementCreator, Client(idClient, nameClient, login, password, email, cartId));

        return clients.stream().findFirst();
    }
}
