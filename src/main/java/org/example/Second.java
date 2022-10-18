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

        Properties prop = loadPropertiesFile();

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println(url+"\n"+driver+"\n"+user+"\n"+password);
    }
}
