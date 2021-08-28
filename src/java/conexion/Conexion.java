package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String user = "root";
    private static String pass = "";
    private static String db = "escuela";
    private static String url = "jdbc:mysql://localhost:3306/" + db;

    private Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Conexion Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar :c  " + e);
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
