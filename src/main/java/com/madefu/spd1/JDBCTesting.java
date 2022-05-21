package com.madefu.spd1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import org.postgresql.Driver;

public class JDBCTesting{
    public static void main(String []args){
        System.out.println("PostgreSQL JDBC...");
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("could not find postgreSQL JDBC Driver");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql:///postgres",
//                    "defu_ma",
//                    "sasa");
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/postgres",
//                    "madefu",
//                    "sasa");
            /*
            URL: tripalink-postgresql-dev.chrusssv7kt6.us-west-1.rds.amazonaws.com
Username: tripalink_architect
Password: 9hKYLEvx-ur-eutG9c2@k3QWhzYwpuiD
             */
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://tripalink-postgresql-dev.chrusssv7kt6.us-west-1.rds.amazonaws.com/tripalink",
//                    "backend_service",
//                    "Y]5hE]2]bJ(7?6-Y.tscb]#q#>f$\"uyr");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://tripalink-postgresql-prod.chrusssv7kt6.us-west-1.rds.amazonaws.com/tripalink",
                    "backend_service",
                    "P-gA*VEYDXCRKqs6ctZW8.uy3YMrpoFd");
            
            /*
            * backend_service
            * Y]5hE]2]bJ(7?6-Y.tscb]#q#>f$“uyr
            * */
        }catch (SQLException e){
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null){
            System.out.println("connect db successful!");
        }else {
            System.out.println("Failed to make conn!");
        }
        try {
            Statement  stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1 AS A");
            if(rs!=null){
                rs.next();  // 必须添加
                System.out.println(rs.getInt("a"));
            }else {
                System.out.println("null");
            }
            rs.close();
            stmt.close();
            connection.close();
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}