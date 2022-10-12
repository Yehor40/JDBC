package org.example;
import java.sql.*;
public class Main {
    static final String url="jdbc:mysql://localhost:3306/JDBC";
    static final String user = "root";
    static final String pass = "";
    public static void createTable(){
        try(Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
        ) {
            String sql = "CREATE TABLE REGISTRATION " +
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       // System.out.println("Hello world!");
            createTable();


        String query=" select * from JDBC ";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,user,pass);



        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();


        String id = rs.getString("id");

        String name = rs.getString("text");
        String num = rs.getString("integer");

        System.out.println(id+"\t"+name+"\t"+num);

    st.close();
    con.close();}
}