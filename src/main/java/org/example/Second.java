package org.example;
import java.io.*;
import java.sql.*;
import java.util.*;
@SuppressWarnings("all")
public class Second {
    static final String filename="C:\\Users\\egorg\\IdeaProjects\\JDBC\\src\\main\\resources\\db.properties";
    static final  Scanner sc = new Scanner(System.in);

    public static Properties loadPropertiesFile() throws Exception {

        Properties prop = new Properties();
        InputStream in = new FileInputStream(filename);
        prop.load(in);
        in.close();
        return prop;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Hello 2 class");
        System.out.println("Choose:\n " +
                "1.insert \n " +
                "2.delete \n "

        );
        int flag = sc.nextInt();

        switch (flag) {
            case 1:
                insert();
                break;
            case 2:
                delete();
                break;
        }
        sc.close();
    }
    public static void insert() throws Exception {
        long m = System.currentTimeMillis();
        Properties prop ;
        prop = loadPropertiesFile();
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        Connection con = DriverManager.getConnection(url, prop);
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
        System.out.println(System.currentTimeMillis() - m+"ms");
    }

    public static void delete()throws Exception {
        long m = System.currentTimeMillis();
        Properties prop ;
        prop = loadPropertiesFile();
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        Connection con = DriverManager.getConnection(url, prop);
        System.out.println("enter id of row to delete: ");
        int id = sc.nextInt();
        String query = "DELETE FROM JDBC WHERE ID=?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        st.executeUpdate();
        System.out.println("deleted from table in given database...");
        System.out.println(System.currentTimeMillis() - m+"ms");
    }
}
