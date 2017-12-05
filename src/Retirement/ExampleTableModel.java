package Retirement;

import javax.swing.table.AbstractTableModel;

class ExampleTableModel extends AbstractTableModel {

    String[] columnNames = {"First Name", "Surname", "Country"
            , "Event", "Place", "Time", "World Record" };

    Object[][] data = {
            {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false },
            {"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45", false },
            {"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32", false },
            {"Michael", "Phelps", "USA", "200m freestyle", 1, "1:42.96", false },
            {"Larsen", "Jensen", "USA", "400m freestyle", 3, "3:42.78", false },
    };

    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        return data[row][column];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];

    }@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();

    }@Override
    public boolean isCellEditable(int row, int column)
    {
        if (column == 1 || column == 2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
