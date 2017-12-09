package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.sql.*;

import static Retirement.DataProcessor.Proc;

class DatabaseIO {


    Connection writeDatabase(String databasePath, String databaseName, String[][] dataTable) {
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + " id integer PRIMARY KEY, \n"
                + " name text NOT NULL, \n"
                + " capacity real\n"
                + ");";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C://Program Files/sqlite/db"); Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            if (connection != null) {
//                DatabaseMetaData meta = connection.getMetaData();
                Proc.alertUser("A new database has been created.", "yay!", 1);
            }
            return connection;
        } catch(SQLException e) {
            Proc.alertUser("The program failed to connect to the database and was unable to save your data.", e.getMessage(), 0);
            return null;
        }
    }

    void DatabaseIO() {
        String sql = "SELECT id, name, capacity FROM warehouses";
        try (Connection connection = this.writeDatabase("FILLING", "IN", new String[0][0]); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            Proc.alertUser(e.getMessage(), "selectAll.catch", 0);
        }
    }


//    public static void main(String[] args) {
//        writeDatabase(Proc.getWritePath(), "HelloWorldDELETE.THIS");
//    }



    String[][] getTableData(String Title) {
//I might want to check database for number of rows and initialize 'tableData' as 'new String['databaseRows'][5];'
        String[][] tableData = new String[100][5];
//GET STRINGS FROM DATABASE
        String[][] database = new String[100][5];
        for (int i = 0; i < tableData.length; i++) {
            String[] row = new String[5];
            row[0] = database[i][1];
            row[1] = database[i][2];
            row[2] = database[i][3];
            row[3] = database[i][4];
            row[4] = database[i][5];
            tableData[i] = row;
        }
        return tableData;
    }
}
