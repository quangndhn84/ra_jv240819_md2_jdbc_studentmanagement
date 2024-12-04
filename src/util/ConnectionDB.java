package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jv240819_student_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234$";

    public static Connection openConnection() {
        //1. Khởi tạo đối tượng Connection
        Connection conn = null;
        try {
            //2. set Driver kết với với CSDL MySQl cho Driver Manager
            Class.forName(DRIVER);
            //3. Tạo đối tượng conn từ Driver Manager
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnecction(Connection conn, CallableStatement callSt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
