package com.example.lesson26ht.DB;

import com.example.lesson26ht.Entities.User;

import java.sql.*;

public class UserRepository {
    public UserRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUser(String login) {
        String loginFromDB = null;
        String passwordFromDB = null;
        try (Connection conn = DriverManager.getConnection(
                DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery
                    ("SELECT login, password " +
                            "from users " +
                            "where login = '" + login + "';");
            while (rs.next()) {
                loginFromDB = rs.getString("login");
                passwordFromDB = rs.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loginFromDB + passwordFromDB;
    }


    public String findUser(String login) {
        String loginFromDB = null;
        try (Connection conn = DriverManager.getConnection(
                DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery
                    ("SELECT login " +
                            "from users " +
                            "where login = '" + login + "';");
            while (rs.next()) {
                loginFromDB = rs.getString("login");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loginFromDB;


    }

    public boolean addUser(String login, String password) {
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(
                DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
             Statement stmt = conn.createStatement()) {
            if (login.equals(findUser(login))) {
                result = false;
            } else {
                stmt.executeUpdate("insert into users (login, password) " +
                        "VALUES ('" + login + "', '" + password + "');");
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
