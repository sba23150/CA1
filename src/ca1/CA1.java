/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tatiana Mota
 */
public class CA1 {

    
    public static void main(String[] args) throws IOException{
        // The program has a menu that lets the user decide between standard operation or adding (validated) data to the status.txt file via the console. (Invalid data should NOT be saved).
        //Asking the user to choose 1-Standart Operation or 2-To add data manually
        System.out.println("Please choose 1 to Standard Operation (use students.text) or 2 to add data to the status.txt file via the console");
        
        //Using Scanner to read user choice
        Scanner myScanner = new Scanner (System.in);
        int userChoice = 0;
        try{      
           userChoice = myScanner.nextInt();
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
        }
        
        //Checking userChoice to initializate program
        switch (userChoice) {
            case 1:
                //call choice1 method
                choice1();
                break;
            case 2:
                //call choice2 method
                choice2();
                break;
            default:
                System.out.println("Something went wrong.");
                break;
        }
    }
    
    public static void choice1() throws FileNotFoundException, IOException {
        //Using BufferedReader to read student.txt. 
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\CA1\\students.txt"))){
            System.out.println(br.readLine());
            String line = br.readLine();
            
            //Must check if the data is valid
            while (line != null) {
                if (studentValidData(line)){
                    System.out.println(line);
                    //data is valid, create another txt - usar outro methodo
                } else{
                    System.out.println("Invalid data");
                    //spicify what´s wrong. maybe bring the info from the method
                }
            }
        }catch (IOException e){
                System.out.println("Error reading file.");
        }    
         
        
       //Read the text and make it into an array
        //tem q 'return' algo no final
    
    //method to check if the data in student.txt is valid
    public static String studentValidData(String line) {
        //split the line into array
        String[] lineArray = line.split(" ");
        
        //we need at least two students, for each student we have 4 elements/words, therefore, we need at least 8 elements in the array
        if (lineArray.length <8){
            System.out.println("Not enough students info. Need at least two students info in the file.");
            
        }else{
            //validate First Name that must be letters only. loop starts 0 and every 4
            int i=0;
            for (i=0;i<lineArray.length;i=i+4){
                if(!lineArray[i].matches("^[a-zA-Z]+$")){
                    System.out.println("First Name must be letters only.");
                } else{
                    String[] firstNameArray = firstNameArray + lineArray[i];
                }
            }
            
            //validate Second Nname that must be letters only. loop starts 0 and every 4
            for (i=0;i<lineArray.length;i=i+4){
                if(!lineArray[i].matches("^[a-zA-Z]+$")){
                    System.out.println("First Name must be letters only.");
                }
            }
        }
    }

    public static void choice2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}    
