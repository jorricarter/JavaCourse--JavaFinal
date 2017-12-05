package Retirement;

import java.io.IOException;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

public class DatabaseIO {
    
    public static String createDatabaseName(String name) {
        name = parseNumbers(name);
        return String.format("%s_database", name);
    }

    protected static String parseNumbers(String st) {
        return st.replaceAll("[^0-9]", "");
    }
    
    public static boolean writeToDatabase(String DBName, String data) {
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
