package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import java.text.DecimalFormat;
import java.util.Locale;

class ToGenerator {


    double[] accountInputArrayToDoubleArray(String[] accountInputs) {
//HAD TO CHECK FOR LETTERS, SYMBOLS, WHICH DECIMALS WERE OKAY, BLANKS, TYPOS AND IT RUNS ANYWAY.
        double[] doubleArray = new double[accountInputs.length];
        for (int i = 0; i < accountInputs.length; i++){
            doubleArray[i] = accountInputToDouble(accountInputs[i]);
        }
        return doubleArray;
    }


    private double accountInputToDouble(String accountInput) {
//'0+' avoids error(conversion to double). "+." avoids out of bounds(ensures at least 2 array indexes before joining)
        String digitString = parseDoubleCharacters(0+accountInput+".");
        //remove second decimal and all following characters
        String[] digitSplit = digitString.split("\\.", -3);
        return Double.parseDouble(digitSplit[0]+"."+digitSplit[1]);
    }


    private static String parseDoubleCharacters(String st) {return st.replaceAll("[^\\d.]", "");}


    String doubleToString(int decimalPlaces, double value) {return String.format("%."+decimalPlaces+"f", value);}


    String doubleToAccountString(double value){
        return DecimalFormat.getCurrencyInstance(Locale.US).format(value);
    }
}

