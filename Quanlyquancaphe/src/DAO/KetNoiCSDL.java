/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author DELL
 */
public class KetNoiCSDL {
     public static Connection openConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Loaded...");
        //
        String url ="jdbc:sqlserver://localhost:1433;databaseName=ql_quancaphe;encrypt=false";
        String user = "sa";
        String password = "123";
        
        Connection con = DriverManager.getConnection(url,user,password);
        System.out.println("Connected...");
        return con;
    }
     public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        // Thực hiện đóng kết nối, câu lệnh chuẩn bị và tập kết quả ở đây
        // Ví dụ:
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
