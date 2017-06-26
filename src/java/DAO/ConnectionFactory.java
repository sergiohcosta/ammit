package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Properties prop = new Properties();
            InputStream input = null;
            
            //input = new FileInputStream("DAO/db.properties");
            input = ConnectionFactory.class.getClassLoader().getResourceAsStream("ammit.properties");
            
            prop.load(input);
            
            String dbhost = prop.getProperty("dbhost","localhost");
            String dbname = prop.getProperty("dbname","ammit");
            String dbuser = prop.getProperty("dbuser","root");
            String dbpass = prop.getProperty("dbpass","");
            
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"
                    + dbhost + "/" + dbname, dbuser, dbpass);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
