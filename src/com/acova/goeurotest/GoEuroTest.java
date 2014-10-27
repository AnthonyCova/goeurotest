package com.acova.goeurotest;

/**
 *
 * @author Anthony
 */
public class GoEuroTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length > 0 && args[0] != null && !args[0].equalsIgnoreCase("")) {
            JsonToCsv.getCsv(args[0]);
        } else {
            System.out.println("Please Enter a String.");
        }
    }

}
