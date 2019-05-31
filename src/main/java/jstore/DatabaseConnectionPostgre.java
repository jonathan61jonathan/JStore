package jstore;

import java.sql.*;

/**
 * Class untuk dapat berinterkasi dengen server PostgreSQL menggunakan jdbc
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class DatabaseConnectionPostgre {

    private Connection conn = null;

    /**
     * method yang digunakan untuk membuat koneksi degan PostgreSQL
     */
    public void connect(){
        try {
            String jdbURL = "jdbc:postgresql://localhost:5432/jstore";
            String username = "postgres";
            String password = "";

            conn = DriverManager.getConnection(jdbURL, username, password);
            System.out.println("Database Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    /**
     * method yang digunakan untuk memutuskan koneksi dengan PostgreSQL
     */
    public void disconnect(){
        try {
            if(conn != null){
                conn.close();
            }
            System.out.println("Database Connection Terminated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method yang digunakan untuk mendapatkan objeck connection jdbc
     *
     * @return objek connection
     */
    public Connection getConn() {
        return conn;
    }

}
