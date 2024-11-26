<<<<<<< HEAD
package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection dbLink;

    public Connection getConnection() {
        String dbName = "login";
        String dbUser = "root";
        String dbPassword = "1389";
        String url = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dbLink;
    }
}
=======
package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection dbLink;

    public Connection getConnection() {
        String dbName = "login";
        String dbUser = "root";
        String dbPassword = "1389";
        String url = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dbLink;
    }
}
>>>>>>> master
