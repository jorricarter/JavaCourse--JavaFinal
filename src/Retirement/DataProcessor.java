package Retirement;

import javax.swing.*;
import java.awt.*;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

public class DataProcessor {
    //grant all classes access to dataProcessor. Only way classes communicate with each other.(modular structure)
    public final static DataProcessor Proc = new DataProcessor();
    //for accessing other classes
    private final DatabaseIO IO = new DatabaseIO();
    private final RetirementCalculatorProgram Program = new RetirementCalculatorProgram();
    private final ToGenerator To = new ToGenerator();
    //can't initialize gui yet or styles wont work
    private CalculatorGUI gui;
    //what style the GUI will use
    final static String GUIStyle = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    public void startProgram() {
        GUIStyle();
        gui = new CalculatorGUI();
        //color for items that don't update properly after Nimbus theme is applied
        final Color ToolTipColor = new Color(20, 80, 120);
        final Color RowColor = new Color(90, 150, 250);
//FOUND THESE FROM EXPERIMENTING AND PURE LUCK
        UIManager.put("ToolTip[Enabled].background", ToolTipColor);
        UIManager.put("Table.alternateRowColor", RowColor);
        UIManager.put("Table.gridColor", Color.BLACK);
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

    public double[] accountStringArrayToDoubleArray(String[] accountStringArray) {
            return To.accountStringArrayToDoubleArray(accountStringArray);
    }

    public String getTitle() {
       return gui.getTitle();
    }

//    private String storageName = CalculatorGUI.getTitle();
//
//    public Boolean dataExists() {
//        if (DatabaseIO.DatabaseExists(CalculatorGUI.getTitle()));
//    }
}
