package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JavaMySQLService {
    
    private Connection connect;
    private String url;
    private String user;
    private String password;

    public JavaMySQLService() {
        super();
        getDBProperties();
        connectDB();
    }

    public Connection getConnect() {
        return connect;
    }

    public void getDBProperties() {        
        try {
            InputStream ins = new FileInputStream("./data/db.properties");
            Properties prop = new Properties();
            prop.load(ins);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void connectDB() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            boolean valid = connect.isValid(50000);
            System.out.println(valid ? "Connected":"Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String nombre) {
        String sql = "INSERT INTO `users`(`name`, `user_status`) VALUES ('"+nombre+"',1)";
        executeInsertStatement(sql);
        insertWallet();
    }

    public void insertWallet() {
        String sql = "INSERT INTO `wallets`(`user_id`) SELECT MAX(id) FROM `users`";
        executeInsertStatement(sql);
    }

    public ResultSet getUsersDB() {
        String sql = "SELECT * FROM users";
        return executeQueryStatment(sql);
    }

    public ResultSet getWalletUser(int id) {
        String sql = "SELECT * FROM `wallets` WHERE `user_id` = " + id;
        return executeQueryStatment(sql);
    }

    public ResultSet getTransactionsWallet(int id) {
        String sql = "SELECT * FROM transactions WHERE wallet_id = "+ id;
        return executeQueryStatment(sql);
    }

    public ResultSet executeQueryStatment(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeInsertStatement(String sql) {
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
