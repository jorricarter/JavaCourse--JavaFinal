package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Retirement.DataProcessor.Proc;
//connect
//delete statement
//call 'preparedstatement()' on 'connection'
//use set-methods of 'preparedStatement' object, like 'setint()', 'setString()'
//to delete: 'executeUpdate()' method of 'PreparedSTatemett' object.

class DB {

//Method to connect to database
    public static DatabaseMetaData DatabaseConnector() {

        try {
//later, Ill separate path from database for creating multiple databases and
            return DriverManager.getConnection(Proc.getSQLitePath()).getMetaData();

        } catch (SQLException e) {
            Proc.alertUser("Communication with the database is unavailable. Currently, files can't be transferred.", e.getMessage(), 0);
            return null;
        }
    }


    private static void delete(String SaveTitle) {
        String sql = "DELETE FROM warehouses WHERE id = ?";

//        try (Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();

//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

}