package data;

import java.sql.*;

public class DatabaseEditor {

    public DatabaseEditor(){

    }

    public void insert() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test");

        PreparedStatement p = conn.prepareStatement("INSERT INTO parts(ID, Name, Type) VALUES(0, 'Dog_Leg', 'Leg') ");
        p.executeUpdate();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM parts");
        while(result.next())
            System.out.println(result.getString("Name") + " " + result.getString("Type"));
    }
}
