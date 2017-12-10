package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.sql.*;
import static Retirement.DataProcessor.Proc;

//delete statement
//call 'preparedstatement()' on 'connection'
//use set-methods of 'preparedStatement' object, like 'setint()', 'setString()'
//to delete: 'executeUpdate()' method of 'PreparedSTatemett' object.

class DB {

//Method to connect to database
    Connection DatabaseConnector() {
//I want 'optional' methods when responses aren't definite like if a connection fails.
        try {
            return DriverManager.getConnection(Proc.getSQLitePath());
//later, Ill separate path from database for creating multiple databases and
        } catch (SQLException e) {
            Proc.alertUser("Communication with the database is unavailable. Currently, files can't be transferred.", e.getMessage(), 0);
            return null;
        }
    }

//    Connection doppleganger(Statement line) {
//        try {
//            return DriverManager.getConnection(Proc.getSQLitePath());
//        } catch (SQLException e) {
//            Proc.alertUser("Communication with the database is unavailable. Currently, files can't be transferred.", e.getMessage(), 0);
//            return null;
//        }
//    }



    void DBTableMaker() {

        String sql = "CREATE TABLE IF NOT EXISTS Jackedindex (\n"
                + "Title TEXT PRIMARY KEY,\n"
                + ");";

        try{
            System.out.println(DatabaseConnector().createStatement().executeUpdate(sql));

        }catch(SQLException e){
            Proc.alertUser("Converting Connector to Statement went wrong.", e.getMessage(), 0);
        }

//        System.out.println(DatabaseConnector().createStatement().execute(sql));
//        DatabaseConnector().createStatement();

//        CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (
//                column_1 data_type PRIMARY KEY,
//                column_2 data_type NOT NULL,
//                column_3 data_type DEFAULT 0,
//                table_constraint
//        ) [WITHOUT ROWID];
//KEEPING THIS AS AN ALTERNATIVE IN CASE ROWS ARE EASIER THAN COLUMNS.
        //I think this has a formatting error.
//        String sql = "CREATE TABLE IF NOT EXISTS Jackedindex (\n"
//                + "Title TEXT PRIMARY KEY,\n"
//                + "Age TEXT NOT NULL,\n"
//                + "Life TEXT NOT NULL,\n"
//                + "Increment TEXT NOT NULL,\n"
//                + "Savings TEXT NOT NULL,\n"
//                + "Income TEXT NOT NULL,\n"
//                + "Annual TEXT NOT NULL,\n"
//                + "Retirement TEXT NOT NULL,\n"
//                + "Debt TEXT NOT NULL\n"
//                + ");";
    }


    private static void delete(String tableTitle) {
        String sql = "DELETE FROM warehouses WHERE id = ?";

//        try (Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();

//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }


//        BEGIN TRANSACTION;
//        CREATE TEMPORARY TABLE t1_backup(a,b);
//        INSERT INTO t1_backup SELECT a,b FROM t1;
//        DROP TABLE t1;
//        CREATE TABLE t1(a,b);
//        INSERT INTO t1 SELECT a,b FROM t1_backup;
//        DROP TABLE t1_backup;
//        COMMIT;
    }
}