package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import static Retirement.DataProcessor.Proc;

public class DatabaseIO {
    //keep track of number of databases for naming scheme(name followed by number of databases)(only saves 10)
    private static int databaseQuant = 0;

    static String nameDatabase() {
        String name = String.format("%s_database"+databaseQuant, Proc.getTitle());
        databaseQuant++;
        return name;
    }


    static boolean writeToDatabase(String DBName, String[][] data) {
//
//        try (callDatabase(nameNewTableInDatabase(databaseAddress, DBName))) {
//
//            write(data);
//            closeDatabase();
//            return true;
//
//        } catch (IOException e) {
//            System.out.println("Unable to write to database " + DBName + ". Error message:\n" + e.getMessage());
            return false;
//        }

    }
    public String[][] getTableData(String Title) {
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
