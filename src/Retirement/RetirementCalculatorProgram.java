package Retirement;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/


import javax.swing.*;
//SWING DEFAULT CONSTRUCTOR
//
//TODO how to convert data from GUI inputs to JTable (ToGenerator)
//TODO install database
//TODO how to create database (can java do it or does it need to be prepped)
//TODO how to check for if a database exists (DatabaseIO.dataExists(title))
//TODO how to check number of databases to know which one to load and which number to save new one as (DatabaseIO)
//TODO processes in Process for determining naming convention (Process.loadPrevious(title))
//TODO how to create database table (DatabaseIO)
//TODO how to put data into database table (DatabaseIO)
//TODO how to get data from database table (DatabaseIO)
//TODO how to insert data into JTable (CalculatorGUI.createTable)
//TODO how to convert from database format to JTable format (ToGenerator)
//TODO have load button tell processor to extract data from database
//TODO validate user input to not be blank and to be within ranges; manage floats.
//TODO make sure parse ints work from text like $ and ,
//TODO add comments to complicated parts
//TODO include instructions on how to prep database for this application

class RetirementCalculatorProgram {
    //what style the GUI will use
    final static String GUIStyle = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    public static void main(String[] args) {
        GUIStyle();
        CalculatorGUI gui = new CalculatorGUI();
    }

    private static void GUIStyle() {
        //COPIED FROM JAVA DOCS ON HOW TO CHANGE GUI STYLE. USE TRY STATEMENT SO IF STYLE DOESN'T EXIST, ENTIRE PROGRAM STILL RUNS.
        try {
            //Set it as nimbus
            UIManager.setLookAndFeel(GUIStyle);
            //if nimbus isn't found, don't crash. Let me know why my program now looks strange.
        } catch (Exception e) {

            System.out.println("Nimbus style could not be loaded. App may look strange, but should function normally.");
        }
    }
}