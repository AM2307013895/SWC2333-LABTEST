/*
 * File Name    : employeeSalaries.java
 * Programmer   : Kimmy
 * Purpose      : Lab Test
 * Date         : 14 March 2024 
*/

import java.io.*;
import javax.swing.JOptionPane;

public class employeeSalaries{
    public static void main(String[] args) throws IOException{
        File inFile = new File ("employeeSalaries.txt");
        FileReader fRead = new FileReader(inFile);
        BufferedReader bRead = new BufferedReader(fRead);

        File outFile = new File ("Report.txt");
        FileWriter fWriter = new FileWriter(outFile);
        PrintWriter outStream = new PrintWriter(fWriter);

        String strName = "";
        String strSalary = "";
        String strService = "";
        int salary, max = 0;
        int service, yos = 0;

        try{
            while(strName != null){
                strName = bRead.readLine();
                
                if(strName != null){
                    strSalary = bRead.readLine();
                    outStream.println(strName + " RM" + strSalary + " " + "\n");
                    salary = Integer.parseInt(strSalary);

                    if(salary > max){
                        max = salary;
                    }
                }
            }
        }   finally{
            bRead.close();
        }
         
        try{
            while(strService != null){
                strService = bRead.readLine();

                if(strService != null){
                    strService =bRead.readLine();
                    outStream.println(strService + " Year(s) of Service" + "\n");
                    service = Integer.parseInt(strService);

                    if(service > yos){
                        yos = service;
                    }
                }
            }
        }

        catch(FileNotFoundException ex){
            String output = "File not found";
            JOptionPane.showMessageDialog(null, output);
        }

        outStream.println("Top Performing Employee = " +max);
        outStream.println("Least year(s) of service = " +yos);

        bRead.close();
        outStream.close();
        System.exit(0);
    }
}