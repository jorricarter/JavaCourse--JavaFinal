package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Retirement.DataProcessor.Proc;

class DatabaseIO {
    private static final String DatabaseUrl = "jdbc:sqlite:C:/Program Files/SQLite/HelloWorld.db";


    void writeDatabase(String databasePath, String databaseName, String[][] dataTable) {
//KEEPING THIS IN CASE I NEED TO USE IT AGAIN TO FIX MY CONNECTION TO THE DATABASE!!!
        //Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection(DatabaseUrl)) {
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("A new database has been created.");
            }
        } catch(SQLException e) {
            Proc.alertUser(e.getMessage(), "Failed Connection", 0);
        }
    }



//    void writeDatabase(String writePath, String writeName, String[][] table) {
//
//        try (callDatabase(nameNewTableInDatabase(writePath+writeName, table))) {
//
//            write(data);
//            closeDatabase();
//            return true;
//
//        } catch (IOException e) {
//            System.out.println("Unable to write to database " + DBName + ". Error message:\n" + e.getMessage());
//        }
//
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
