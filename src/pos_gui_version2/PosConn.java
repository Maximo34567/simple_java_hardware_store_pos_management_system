package pos_gui_version2;

import java.sql.*;
import javax.swing.JOptionPane;

public class PosConn {

    public static Connection DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection DBCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_db", "root", "");
            return DBCon;

        } catch (ClassNotFoundException | SQLException e) {
            // Log the exception (consider using a logging framework)
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + e.getMessage());
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing the database connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
