package Retirement;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

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
    private JScrollPane scrollTableField;

    //Title that appears on top of form's program-window. has a get method as well.
    private final String Title = "Retirement Calculator";
    //FINAL column headings
    private final String[] ColumnHeadings = {"Age", "Required", "Savings", "Needed", "Percent"};
    //making this global so if one method puts it together, I don't need to repeat adding the same 8 items in other methods.
    private String[][] jTableData;

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
        createTable(new String[100][5], jTableAlignment);
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
//                if (Process.dataExists(Title)) createTable(Process.loadPrevious(Title));
//                else showMessage("I cannot find a saved configuration for you.", "File not found.", 1);
            }
        });
        //when this is clicked, calculate all the data
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //store data so data doesn't need to be collected again. Reducing collecting also reduces errors in case text changes in between checks.
                String[] allJText = getAllTextFields();
                //if (a field is blank) {alert user;}
                for (in i = )
                if (lifeField.getText().isEmpty()|| incrementField.getText().isEmpty() || ageField.getText().isEmpty()|| savingsField.getText().isEmpty() || incomeField.getText().isEmpty() || annualField.getText().isEmpty() || retirementField.getText().isEmpty() || mortgageField.getText().isEmpty()){
                    //display alert to notify user of error
                    showMessage("Please input a value for each category.", "Empty field", 1);
                //necessary data isn't blank {display table}
                }else {
                    //get all data from form and convert it to list of doubles without '$' or ','
                    doubleArrayToJTableData(Proc.accountStringArrayToDoubleArray(getAllTextFields()));
                    jTableDat
                    createTable(jTableData, jTableAlignment);
                }
            }
        });
        //what to do when 'saveInvoice' button is clicked
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (retirementTable.getRowCount()<100) showMessage("Please populate the table to save it.", "Table is empty.", 0);
                else {
                    DatabaseIO.writeToDatabase(DatabaseIO.nameDatabase(), jTableData);
                }
            }
        });
    }

    private String[] getAllTextFields() {
        return new String[] {ageField.getText(), lifeField.getText(), incrementField.getText(), savingsField.getText(),
                            incomeField.getText(), annualField.getText(), retirementField.getText(), mortgageField.getText()
        };
    }

    private String[][] doubleArrayToJTableData (double[] allTextFields) {
        jTableData = new String[10][5];
        return jTableData;
    }

    private void createTable(String[][] tableData, DefaultTableCellRenderer jTableAlignment) {
        retirementTable.setModel(new DefaultTableModel(tableData, ColumnHeadings));
        for (int i = 0; i < ColumnHeadings.length; i++) {
            retirementTable.getColumnModel().getColumn(i).setCellRenderer( jTableAlignment );
        }
    }

    private void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}
