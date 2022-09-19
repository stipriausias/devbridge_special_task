package javaapplication1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                filter(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void filter(String line) {

        for (int i = 0; i < line.length() - 1; i++) {
            Boolean isDigit1 = Character.isDigit(line.charAt(i));
            Boolean isDigit2 = Character.isDigit(line.charAt(i + 1));

            if (isDigit1 && isDigit2) {
                int num1 = Character.getNumericValue(line.charAt(i));
                int num2 = Character.getNumericValue(line.charAt(i + 1));
                int num = num1 * 10 + num2;

                if (isDigit1 && isDigit2 && num >= 10) {
                    System.out.println(line);
                    break;
                }
            }
        }
    }

}