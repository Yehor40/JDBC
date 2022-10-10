package org.example;
import java.io.*;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       // System.out.println("Hello world!");
        String url="jdbc:mysql://localhost:3306/JDBC";
        String user = "root";
        String pass = "";
        String query="select * from JDBC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString("text");
        System.out.println(name);
    st.close();
    con.close();}
}