package Retirement;

/**Created by Jorri on 12/3/17. This is the final project for Java Programming class with Clara James.*/

public class DataProcessor {
    //grant all classes access to dataProcessor. Only way classes communicate with each other.(modular structure)
    final static DataProcessor Process = new DataProcessor();
    //for accessing other classes
    private final DatabaseIO IO = new DatabaseIO();
    private final RetirementCalculatorProgram Program = new RetirementCalculatorProgram();
    private final TableGenerator Generate = new TableGenerator();

//    private String storageName = CalculatorGUI.getTitle();
//
//    public Boolean dataExists() {
//        if (DatabaseIO.DatabaseExists(CalculatorGUI.getTitle()));
//    }
}
