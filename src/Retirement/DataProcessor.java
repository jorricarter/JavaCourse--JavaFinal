package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import javax.swing.*;
import java.awt.*;
import java.util.Date;

class DataProcessor {
    //grant all classes access to dataProcessor. Only way classes communicate with each other.(modular structure)
    final static DataProcessor Proc = new DataProcessor();
    //for accessing other classes
    private final DatabaseIO IO = new DatabaseIO();
    private final ToGenerator To = new ToGenerator();
    //can't initialize gui yet or styles wont work
    private CalculatorGUI gui;
    //what style the GUI will use
    private final static String GUIStyle = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private final static String WritePath = "c://Program Files//sqlite//db//Calculator//";

    //styles the gui and starts it
    void startProgram() {
        IO.connect();
        styleGUI();
        final CalculatorGUI gui = new CalculatorGUI();
    }

    //styles the gui
    private void styleGUI() {
        //COPIED FROM JAVA DOCS ON HOW TO CHANGE GUI STYLE. USE TRY STATEMENT SO IF STYLE DOESN'T EXIST, ENTIRE PROGRAM STILL RUNS.
        try {
            //Set it as nimbus
            UIManager.setLookAndFeel(GUIStyle);
            //color for items that don't update properly after Nimbus theme is applied
            final Color ToolTipColor = new Color(20, 80, 120);
            final Color RowColor = new Color(90, 150, 250);
//FOUND THESE FROM EXPERIMENTING AND PURE LUCK. They only work on some computers..?
            UIManager.put("ToolTip[Enabled].background", ToolTipColor);
            UIManager.put("Table.alternateRowColor", RowColor);

            //if nimbus isn't found, don't crash. Let me know why my program now looks strange.
        } catch (Exception e) {
            gui.alertUser("Nimbus style could not be loaded. App may look strange, but should function normally.", "Default style could not be found.", 1);
        }
    }


    double[] accountInputArrayToDoubleArray(String[] accountInputArray) {return To.accountInputArrayToDoubleArray(accountInputArray);}


    String doubleToAccountString(double value) {return To.doubleToAccountString(value);}


    String getTitle() {return gui.getTitle();}


    String doubleToString(int decimalPlaces, double value) {return To.doubleToString(decimalPlaces, value);}



//In future implementation, I will overload this method to optionally accept filepath and name;
    void writeDatabase(String[][] table) {IO.writeDatabase(WritePath, nameDatabaseUnique(), table);}


//future implementations would allow users to choose the name.
    private String nameDatabaseUnique() {return Proc.getTitle()+new Date()+".db";}


//    public Boolean dataExists() {
//        if (DatabaseIO.DatabaseExists(Proc.getTitle()));
//    }
}
