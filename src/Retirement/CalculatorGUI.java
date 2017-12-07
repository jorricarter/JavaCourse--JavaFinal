package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Retirement.DataProcessor.Proc;

public class CalculatorGUI extends JFrame{

    private JPanel mainPanel;

    JPanel dataEntryPanel;
    private JTextField ageField;
    private JTextField lifeField;
    private JTextField incrementField;
    private JTextField savingsField;
    private JTextField incomeField;
    private JTextField annualField;
    private JTextField retirementField;
    private JTextField mortgageField;
    private JButton loadButton;
    private JButton generateButton;

    JPanel tableViewPanel;
    private JTable retirementTable;
    private JButton saveButton;

    //Title that appears on top of form's program-window. has a get method as well.
    private static final String Title = "Retirement Calculator";
    //FINAL column headings
    private static final String[] ColumnHeadings = {"Age", "Required", "Savings", "Needed", "Percent"};
//    //making this global so if one method puts it together, I don't need to repeat checking the same 8 inputs in other methods. That could also create errors
    private String[][] Retirement2dData = new String[100][ColumnHeadings.length];

    //THIS DOUBLES AS AN OVERRIDE AND A GET METHOD. THE OVERRIDE NAMES THE JFRAME AND WHEN THE METHOD IS CALLED BY OTHER CLASSES, IT WILL RETURN THE NAME OF THE CALCULATOR.
    @Override
    public String getTitle() {
        return Title;
    }


    CalculatorGUI() {
        //formatter to align numbers to the right. Makes more sense for this kind of app
        DefaultTableCellRenderer jTableAlignment = new DefaultTableCellRenderer();
        jTableAlignment.setHorizontalAlignment(JLabel.RIGHT);
        //creates empty table so form isn't blank
        createJTable(Retirement2dData, jTableAlignment);
        //sets up grid because grid doesn't appear properly with this style
        retirementTable.setShowGrid(true);
        //start the actual GUI.
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(800, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //what to do when 'Load Previous Data' is clicked.
        loadButton.addActionListener((ActionEvent e) -> {
                //if (database exists) {display table} else {display message};
//                if (Process.dataExists(Title)) createJTable(Process.loadPrevious(Title));
//                else
            alertUser("I cannot find a saved configuration for you.", "File not found.", 1);
        });

        //when this is clicked, calculate all the data
        generateButton.addActionListener((ActionEvent e) -> {
                //get all data from form and convert it to list of doubles without '$' or ','
                Retirement2dData = retirementDataGenerator(Proc.accountInputArrayToDoubleArray(getAllTextFields()));
                createJTable(Retirement2dData, jTableAlignment);
        });

        //what to do when 'saveInvoice' button is clicked
        saveButton.addActionListener((ActionEvent e) -> {
//SOME EASY FIXES WERE LEFT OUT: USER TRIES TO SAVE TABLE WITH AN EMPTY COLUMN.(THAT'S THEIR CHOICE)
//                if (retirementTable.getRowCount()==100) alertUser("Please populate the table to save it.", "Table is empty.", 0);
//                else {
//                    DatabaseIO.writeToDatabase(DatabaseIO.nameDatabase(), retirement2dData);
//                }
        });
    }


    void alertUser(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }


    private String[] getAllTextFields() {

        return new String[] {ageField.getText(), lifeField.getText(), incrementField.getText(), savingsField.getText(),
                            incomeField.getText(), annualField.getText(), retirementField.getText(), mortgageField.getText()
        };
    }


    private String[][] retirementDataGenerator(double[] doubleInputs) {
        //ONLY IN HERE TO HELP TEACHER TRACE FORMULAS WHEN DECIPHERING WHICH INDEXES LEAD TO WHICH INPUT BOXES.
        double age = doubleInputs[0], life = doubleInputs[1], inc = doubleInputs[2], save = doubleInputs[3], annual = doubleInputs[5], retire = doubleInputs[6], mort = doubleInputs[7];
        //if input is invalid, this array will calculate as requiring 0 rows(blank table with columns and design)
        if (!validateInput(age, life, inc, annual, retire)) life=inc=age=1;
        //I KNOW THIS PART MIGHT BE DIFFICULT TO FOLLOW, BUT I TRIED TO MAKE IT LOOK ORGANIZED
        Retirement2dData = new String[(int)((life-age)/inc)][ColumnHeadings.length];
        //FOR LOOP BASED ON VARIABLES INPUT INTO TEXTFIELDS.
        for (int i = 0; i < Retirement2dData.length; age += inc, i++) {
            String[] currentData = Retirement2dData[i];
            currentData[0] = Proc.doubleToString(2, age);
            currentData[1] = Proc.doubleToAccountString(retire*(life-age)+mort);
            currentData[2] = String.format ("%.2f", age);
            currentData[3] = String.format ("%.2f", age);
            currentData[4] = String.format ("%.2f", age);
        }
        return Retirement2dData;
    }


    private Boolean validateInput(double age, double life, double inc, double annual, double retire){
        //if (valid) {return true;}
        if (age < life && inc > 0 && annual > 0 && retire > 0) return true;

        //if input is impossible to calculate, alert user
        alertUser("The data you provided is impossible to calculate into a retirement plan.", "Unable to calculate impossible equations!", 0);
        return false;

    }


    private void createJTable(String[][] tableData, DefaultTableCellRenderer jTableAlignment) {
        retirementTable.setModel(new DefaultTableModel(tableData, ColumnHeadings));
        for (int i = 0; i < ColumnHeadings.length; i++) {
//            retirementTable.getColumnModel().getColumn(i).setCellRenderer( jTableAlignment );
        }
    }
}
