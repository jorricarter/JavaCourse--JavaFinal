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
        
        try (callDatabase(nameNewTableInDatabase(databaseAddress, DBName))) {
            
            write(data);
            closeDatabase();
            return true;
            
        } catch (IOException e) {
            System.out.println("Unable to write to database " + DBName + ". Error message:\n" + e.getMessage());
            return false;
        }
    }
}
