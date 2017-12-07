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
import java.awt.event.ActionListener;

import static Retirement.DataProcessor.Proc;

public class CalculatorGUI extends JFrame{
    private JPanel mainPanel;
    JPanel dataEntryPanel;
    JPanel tableViewPanel;

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
    private JTable retirementTable;
    private JButton saveButton;

    //Title that appears on top of form's program-window. has a get method as well.
    private static final String Title = "Retirement Calculator";
    //FINAL column headings
    private static final String[] ColumnHeadings = {"Age", "Required", "Savings", "Needed", "Percent"};
    //making this global so if one method puts it together, I don't need to repeat checking the same 8 inputs in other methods. That could also create errors
    private String[][] retirement2dData;

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
        createJTable(new String[100][5], jTableAlignment);
        //sets up grid because grid doesn't appear properly with this style
        retirementTable.setShowGrid(true);
        //start the actual GUI.
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(800, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //what to do when 'Load Previous Data' is clicked.
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if (database exists) {display table} else {display message};
//                if (Process.dataExists(Title)) createJTable(Process.loadPrevious(Title));
//                else showMessage("I cannot find a saved configuration for you.", "File not found.", 1);
            }
        });
        //when this is clicked, calculate all the data
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get all data from form and convert it to list of doubles without '$' or ','
                retirement2dData = retirementDataGenerator(Proc.accountInputArrayToDoubleArray(getAllTextFields()));
                createJTable(retirement2dData, jTableAlignment);
            }
        });

        //what to do when 'saveInvoice' button is clicked
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//SOME EASY FIXES WERE LEFT OUT: USER TRIES TO SAVE TABLE WITH AN EMPTY COLUMN.(THAT'S THEIR CHOICE)
                if (retirementTable.getRowCount()==100) showMessage("Please populate the table to save it.", "Table is empty.", 0);
                else {
                    DatabaseIO.writeToDatabase(DatabaseIO.nameDatabase(), retirement2dData);
                }
            }
        });
    }

    private String[] getAllTextFields() {
        return new String[] {ageField.getText(), lifeField.getText(), incrementField.getText(), savingsField.getText(),
                            incomeField.getText(), annualField.getText(), retirementField.getText(), mortgageField.getText()
        };
    }

    private String[][] retirementDataGenerator(double[] allTextFields) {

//        String[] x = new String[allTextFields.length];
//        for (l)
//        retirement2dData = {allTextFields, allTextFields, all};
        return retirement2dData;
    }

    private void createJTable(String[][] tableData, DefaultTableCellRenderer jTableAlignment) {
        retirementTable.setModel(new DefaultTableModel(tableData, ColumnHeadings));
        for (int i = 0; i < ColumnHeadings.length; i++) {
            retirementTable.getColumnModel().getColumn(i).setCellRenderer( jTableAlignment );
        }
    }

    void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}
