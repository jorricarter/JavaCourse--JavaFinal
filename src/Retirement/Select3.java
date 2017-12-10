package Retirement;

import java.sql.*;

public class Select3 {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Program Files/sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
//* gets all columns, but it's not smart if app shares the database.
        String sql = "SELECT name, capacity FROM warehouses;";
//                "SELECT Age, Required, Savings, Needed, Percent FROM Jackedindex";
//        SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name != 'android_metadata' AND name != 'sqlite_sequence';
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

//while there is another row, uniterated
            while (rs.next()) {
                System.out.println(
//gets the column by title or index(I think index starts at one for sqlite)
//                        rs.getString("Title") +  "\t" +
//.getstring or .getdouble or .getinteger for column values.
//                        rs.getString("ReportsTo") +  "\t" +
//i can loop through to get the data. (should only save textfields)
                );for (int i = 1; i<4; i++) System.out.println( rs.getString(i));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select3 app = new Select3();
        app.selectAll();
    }

}