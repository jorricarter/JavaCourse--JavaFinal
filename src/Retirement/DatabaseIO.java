package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.sql.*;

import static Retirement.DataProcessor.Proc;

class DatabaseIO {

//    public static void createNewDatabase(String fileName) {
//
//        String url = "jdbc:sqlite:C://Program Files/sqlite/db/" + fileName;
//
//        try (Connection conn = DriverManager.getConnection(url)) {
//            if (conn != null) {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void createNewTable() {
//        // SQLite DatabaseConnector string
//        String url = "jdbc:sqlite:C://Program Files/sqlite/db/test.db";
//
//        // SQL statement for creating a new table
//        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
//                + "	id integer PRIMARY KEY,\n"
//                + "	name text NOT NULL,\n"
//                + "	capacity real\n"
//                + ");";
//
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement()) {
//            // create a new table
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//     Connect to database
//     return Connection object
//private Connection connect() {
//    // SQLite DatabaseConnector string
//    String url = "jdbc:sqlite:C://Program Files/sqlite/db/test.db";
//    Connection conn = null;
//    try {
//        conn = DriverManager.getConnection(url);
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//    }
//    return conn;
//}
//
//
//    /**
//     * select all rows in the warehouses table
//     */
//    public void selectAll(){
//        String sql = "SELECT id, name, capacity FROM warehouses";
//
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") +  "\t" +
//                        rs.getString("name") + "\t" +
//                        rs.getDouble("capacity"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
//        try (Connection DatabaseConnector = DriverManager.getConnection("jdbc:sqlite:C://Program Files/sqlite/db")
////             Statement stmt = DatabaseConnector.createStatement())
//                ){
////            stmt.execute(sql);
//            if (DatabaseConnector != null) {
//                Proc.alertUser("A new database has been created.", "yay!", 1);
//            }
//            return DatabaseConnector;
//        } catch(SQLException e) {
//            Proc.alertUser("The program failed to connect to the database and was unable to save your data.", e.getMessage(), 0);
//            return null;
//        }
//    }
//
//    void DatabaseIO() {
//        String sql = "SELECT id, name, capacity FROM warehouses";
//        try (Connection DatabaseConnector = this.writeDatabase("FILLING", "IN", new String[0][0]); Statement stmt = DatabaseConnector.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + rs.getDouble("capacity"));
//            }
//        } catch (SQLException e) {
//            Proc.alertUser(e.getMessage(), "selectAll.catch", 0);
//        }
//    }
//
//
////    public static void main(String[] args) {
////        writeDatabase(Proc.getWritePath(), "HelloWorldDELETE.THIS");
////    }
//
//
//
//    String[][] getTableData(String Title) {
////I might want to check database for number of rows and initialize 'tableData' as 'new String['databaseRows'][5];'
//        String[][] tableData = new String[100][5];
////GET STRINGS FROM DATABASE
//        String[][] database = new String[100][5];
//        for (int i = 0; i < tableData.length; i++) {
//            String[] row = new String[5];
//            row[0] = database[i][1];
//            row[1] = database[i][2];
//            row[2] = database[i][3];
//            row[3] = database[i][4];
//            row[4] = database[i][5];
//            tableData[i] = row;
//        }
//        return tableData;
//    }
//}
