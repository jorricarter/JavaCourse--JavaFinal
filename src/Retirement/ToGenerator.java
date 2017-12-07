package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

class ToGenerator {

    double[] accountInputArrayToDoubleArray(String[] accountInputs) {
//HAD TO CHECK FOR LETTERS, SYMBOLS, WHICH DECIMALS WERE OKAY, BLANKS, TYPOS AND IT RUNS ANYWAY.
        double[] doubleArray = new double[accountInputs.length];
        for (int i = 0; i < accountInputs.length; i++){
//'0+' avoids error(conversion to double). "+." avoids out of bounds(ensures at least 2 array indexes before joining)
            String digitString = parseDoubleCharacters(0+accountInputs[i]+".");
            //remove second decimal and all following characters
            String[] digitSplit = digitString.split("\\.", 3);
            doubleArray[i] = Double.parseDouble(digitSplit[0]+"."+digitSplit[1]);
        }
        return doubleArray;
    }

    private static String parseDoubleCharacters(String st) {return st.replaceAll("[^\\d.]", "");}
}

