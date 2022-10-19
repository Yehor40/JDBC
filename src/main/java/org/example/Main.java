package org.example;
import java.sql.*;
import  java.util.*;


// stored procedure:selectAll()

/*
-Statement:
The Statement interface represents the static SQL statement.
It helps you to create a general purpose SQL statements using Java.

-Prepared Statement
The PreparedStatement interface extends the Statement interface.
It represents a precompiled SQL statement which can be executed multiple times.
This accepts parameterized SQL quires and you can pass 0 or more parameters to this query.

-The CallableStatement
Interface provides methods to execute stored procedures.
Since the JDBC API provides a stored procedure SQL escape syntax,you can call stored procedures of all RDBMS in a single standard way.
*/


public class Main {
    static  Scanner sc = new Scanner(System.in);
    static final String url = "jdbc:mysql://localhost:3306/JDBC";
    static final String user = "root";
    static final String pass = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // System.out.println("Hello world!");
        System.out.println("Choose:\n " +
                "1:create \n " +
                "2:select \n " +
                "3:insert\n" +
                "4:call\n"
        );
        int flag = sc.nextInt();

        switch (flag) {
            case 1:
                createTable();
                break;
            case 2:
                select();
                break;
            case 3:
                insert();
                break;
            case 4:
                call();
                break;
        }
        sc.close();
    }


    public static void call() throws ClassNotFoundException, SQLException {
        //callable statement to call stored procedure
        long m = System.currentTimeMillis();
        String query = "{CALL selectAll()}";
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        CallableStatement st = con.prepareCall(query);
        rs = st.executeQuery();
        while(rs.next()){
            System.out.println(
                            rs.getString("id")+"\t"+
                            rs.getString("text")+"\t"+
                            rs.getString("integr")
           );}
        System.out.println("procedure called");
        System.out.println(System.currentTimeMillis() - m);
        st.close();
        con.close();
    }

    public static void insert() throws ClassNotFoundException, SQLException {
        //prepared statement to insert data into a table
        long m = System.currentTimeMillis();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        String query = "INSERT INTO JDBC(id, text,integr)VALUES(?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, 1);
        st.setString(2, "integer");
        st.setInt(3, 222);
        st.executeUpdate();
        System.out.println("inserted in table in given database...");
        System.out.println(System.currentTimeMillis() - m);
       // timeTrack();
    }

    public static void createTable() {
        //simple statement to create table
        long m = System.currentTimeMillis();
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement()
        ) {
            String sql = "CREATE TABLE IF NOT EXISTS REGISTR " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            st.executeUpdate(sql);
            System.out.println("Created table in given database...");
            //timeTrack();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - m+"ms");
    }

    public static void select() throws ClassNotFoundException, SQLException {
        //simple statement to select all from table
        long m = System.currentTimeMillis();
        String query = " select * from JDBC ";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String id = rs.getString("id");
        String name = rs.getString("text");
        String num = rs.getString("integr");
        System.out.println(id + "\t" + name + "\t" + num);
        st.close();
        con.close();
        System.out.println(System.currentTimeMillis() - m+"ms");

    }
}
