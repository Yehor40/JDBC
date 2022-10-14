package org.example;
import java.sql.*;
import  java.util.*;
// stored procedure:selectAll()

/*
-execute(): This method is used to execute SQL DDL statements, it returns a boolean value specifying whether the ResultSet object can be retrieved.

-executeUpdate(): This method is used to execute statements such as insert, update, delete. It returns an integer value representing the number of rows affected.

-executeQuery(): This method is used to execute statements that returns tabular data (example SELECT statement). It returns an object of the class ResultSet.
*/
public class Main {
    static Scanner sc = new Scanner(System.in);
    static final String url="jdbc:mysql://localhost:3306/JDBC";
    static final String user = "root";
    static final String pass = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       // System.out.println("Hello world!");
        System.out.println("Choose:\n " +
                "1:create \n " +
                "2:select \n " +
                "3:insert\n"+
                 "4:call\n"
        );
        int flag = sc.nextInt() ;

        switch (flag){
            case  1:
                createTable();
                break;
            case  2:
                select();
                break;
            case  3:
                insert();
                break;
            case  4:
                call();
                break;
        }





       }

    public static void call()throws ClassNotFoundException,SQLException {
        //callable statement
        String query = "{CALL selectAll(?)}";
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        CallableStatement st = con.prepareCall(query);
        //
        //
        st.setInt(1,1);
        rs = st.executeQuery();

        String id = rs.getString("id");

        String name = rs.getString("text");
        String num = rs.getString("integr");

        System.out.println(id+"\t"+name+"\t"+num);
        System.out.println("procedure called");
        st.close();
        con.close();

    }
    public static void insert() throws ClassNotFoundException,SQLException {
        //prepared statement
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

      String query = "INSERT INTO JDBC(id, text,integr)VALUES(?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,1);
            st.setString(2,"integer");
            st.setInt(3,222);
        st.executeUpdate();
        System.out.println("inserted in table in given database...");
        }
    public static void createTable(){
        //statement
        try(Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement()
        ) {
            String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            st.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    public static void select() throws ClassNotFoundException,SQLException {
        String query=" select * from JDBC ";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,user,pass);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();

        String id = rs.getString("id");

        String name = rs.getString("text");
        String num = rs.getString("integr");

        System.out.println(id+"\t"+name+"\t"+num);

        st.close();
        con.close();
    }
}