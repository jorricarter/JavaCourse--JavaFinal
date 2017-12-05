package Retirement;

import javax.swing.*;
//todo create methods for gui.createTable, Process.dataExists(title), Process.loadPrevious(title).
//todo give loadButton if statement to display warning popup if no load data found
//todo have load button tell processor to extract data from database
//todo parse ints from text like $ and ,
//todo make sure table works
//todo refactor DatabaseIO
//todo remove old comments
//todo comment code

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

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