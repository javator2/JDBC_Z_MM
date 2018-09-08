package pl.sdacademy.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    private static final String URL = "jdbc:mysql://localhost";
    private static final String username = "root";
    private static final String password = "";
    private static final String PORT = "3306";
    private static final String DATABASE = "ksiegarnia";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PARMS = "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static Connection connection = null;

    public static String getFormatedURL(){
        return URL + ":" + PORT + "/" + DATABASE + "?" + PARMS;
    }

    private static void loadDriver(){

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean loadConnection() {
        try {
            connection = DriverManager.getConnection(getFormatedURL(), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection != null;
        // if(connection == null) { return false;} return true;
    }

    public static Connection getConnection(){
        if(connection==null){
            loadDriver();
            loadConnection();
        } return connection;
    }
    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } connection = null;
        }
    }
}
