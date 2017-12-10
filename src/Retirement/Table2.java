package Retirement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Table2 {
//  SQLCode
//  Connection || hold on to metadata?
//    get statement class from connection
//    create table

    public static void createNewTable() {
        // SQLite DatabaseConnector string
        String url = "jdbc:sqlite:C://Program Files/sqlite/db/test.db";

//        CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (
//                column_1 data_type PRIMARY KEY,
//                column_2 data_type NOT NULL,
//                column_3 data_type DEFAULT 0,
//                table_constraint
//        ) [WITHOUT ROWID];

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Jackedindex (\n"
                    + "Age TEXT NOT NULL,\n"
                    + "Required TEXT NOT NULL,\n"
                    + "Savings TEXT NOT NULL,\n"
                    + "Needed TEXT PRIMARY KEY,\n"
                    + "Percent TEXT NOT NULL\n"
                    + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            System.out.println(stmt.executeUpdate(sql));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        createNewTable();
    }

}