package Retirement;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    //color for items that don't update properly after Nimbus theme is applied
    final static Color ToolTipColor = new Color(20, 80, 120);
    final static Color RowColor = new Color(90, 150, 250);
    //Title that appears on top of form's program-window. has a get method as well.
    private final String Title = "Retirement Calculator";
    //create list to store current settings and send to method for creating table.
    private ArrayList<String> calculatorData = new ArrayList<>();
    //data for initializing blank-ish table
    private final String[] ColumnHeadings = {"Age", "Required", "Savings", "Needed", "Percent"};
    //edit this model to update table
    DefaultTableModel tableModel = new DefaultTableModel(ColumnHeadings,100);

    //get/set methods for getting or setting values. Only provide what's necessary
//THIS DOUBLES AS AN OVERRIDE AND A GET METHOD. THE OVERRIDE NAMES THE JFRAME AND WHEN THE METHOD IS CALLED BY OTHER CLASSES, IT WILL RETURN THE NAME OF THE CALCULATOR.
    @Override
    public String getTitle() {
        return Title;
    }

    CalculatorGUI() {
        retirementTable.setModel(tableModel);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(800, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
//ONLY KIND-OF WORKING, BUT AT LEAST TOOLTIP ISN'T YELLOW ANYMORE
        UIManager.put("ToolTip[Enabled].backgroundPainter", ToolTipColor);
        UIManager.put("ToolTip[Enabled].background", ToolTipColor);
        UIManager.put("Table.alternateRowColor", RowColor);

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
                //if (a field is blank) {alert user;}
                if (lifeField.getText().isEmpty()|| incrementField.getText().isEmpty() || ageField.getText().isEmpty()|| savingsField.getText().isEmpty() || incomeField.getText().isEmpty() || annualField.getText().isEmpty() || retirementField.getText().isEmpty() || mortgageField.getText().isEmpty()){
                    //display alert to notify user of error
                    showMessage("Please input a value for each category.", "Empty field", 1);
                //necessary data isn't blank {display table}
                }else {
                    //put data from calculator into a list to be sent to DataProcessor for processing.
                    calculatorData.add(ageField.getText());
                    calculatorData.add(lifeField.getText());
                    calculatorData.add(incrementField.getText());
                    calculatorData.add(savingsField.getText());
                    calculatorData.add(incomeField.getText());
                    calculatorData.add(annualField.getText());
                    calculatorData.add(retirementField.getText());
                    calculatorData.add(mortgageField.getText());
                    //feed calculatorData to processor to get table of what will fill retirementTable
//                    String dataString = (calculatorData);
                    //display string in preview
//                    retirementTable.setText(dataString);
                }
            }
        });

        //what to do when 'saveInvoice' button is clicked
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (retirementTable.getRowCount()<100) showMessage("Please populate the table to save it.", "Table is empty.", 0);
                else {
                    DatabaseIO.writeToDatabase(DatabaseIO.createDatabaseName(lifeField.getText()), incrementField.getText());
                }
            }
        });
    }

    private void createTable(String[][] tableData) {
        tableModel = new DefaultTableModel(tableData, ColumnHeadings);
    }
    private void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}
