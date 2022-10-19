package org.example;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Second {
    static final String filename="C:\\Users\\egorg\\IdeaProjects\\JDBC\\src\\main\\resources\\db.properties";
    public static Properties loadPropertiesFile() throws Exception {

        Properties prop = new Properties();
        InputStream in = new FileInputStream(filename);
        prop.load(in);
        in.close();
        return prop;
    }

    public static void main(String[] args) throws Exception,SQLException{
        System.out.println("Hello 2 class");
/*
Properties prop = loadPropertiesFile();

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println(url+"\n"+driver+"\n"+user+"\n"+password);
        Connection con = DriverManager.getConnection(url, prop);
        System.out.println("Connection established: "+ con);
 */
insert();
    }

    public static void insert() throws Exception,SQLException {
        Properties prop = null;
        Scanner sc = new Scanner(System.in);
        prop = loadPropertiesFile();
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        // System.out.println(url+"\n"+driver+"\n"+user+"\n"+password);
        Connection con = DriverManager.getConnection(url, prop);
        // System.out.println("Connection established: "+ con);
        System.out.println("Enter id:");
        int id = sc.nextInt();
        System.out.println("Enter text:");
        String text = sc.next();
        System.out.println("Enter integer:");
        int dec = sc.nextInt();

            String query = "INSERT INTO JDBC(id, text,integr)VALUES(?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, text);
            st.setInt(3, dec);
            st.executeUpdate();
            System.out.println("inserted in table in given database...");

    }
}
