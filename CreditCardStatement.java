package com.romaintestard.lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardStatement {

    public static void main(String[] args){
        // This method will read data frm a CSV file
        List<String[]> transactions = new ArrayList<String[]>();
        String filename = "C:\\Users\\Romain\\Desktop\\Dev web\\JavaPrograms\\DataStructures\\src\\com\\romaintestard\\datacb.csv";
        String dataRow;
        try {
            // Open the file
            BufferedReader br = new BufferedReader(new FileReader(filename));

            // Read the data as long as it's not empty
            while ((dataRow = br.readLine()) != null) {
                // Parse the data by commas;
                String[] line = dataRow.split(",");
                // Add the data to collection
                transactions.add(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int balance = 0;
        for (String[] transaction : transactions) {
             String date = transaction[0];
             String type = transaction[1];
             String vendor = transaction[2];
             double amount = Double.parseDouble(transaction[3]);
                System.out.print(date + " " + type + " " + vendor + " " + amount);

            if (type.equalsIgnoreCase("credit")){
 /*               System.out.println("Add to balance");*/
                balance += amount;
            }
            else if (type.equalsIgnoreCase("debit")){
/*                System.out.println("Subtract from balance");*/
                balance -= amount;
            }
            else {
/*                System.out.println("Some other transaction");*/
            }
            System.out.println(" " + balance + "\n");
         }

         // Check the balance
        if (balance > 0){
            System.out.println("You have a balance of " + balance);
            System.out.println("You are charged a 10% fee of " + balance * .10);
            System.out.println("You new balance is: " + balance*1.1);
        }
        else if (balance < 0){
            System.out.println("Thanks for your payments.");
            System.out.println("You have a overpayment of -" + balance);
        }
        else {
            System.out.println("Thanks you for your payment");
        }

    }
}
