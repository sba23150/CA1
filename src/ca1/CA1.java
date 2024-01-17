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
        //should i start asking or kknowing how many students there is in the file or just read how many lines there is in the text and just with a loop?
        //Using BufferedReader to read student.txt. 
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\CA1\\students.txt"));
 
        //System.out.println(br.readLine());
        String line = br.readLine();
	while (line != null) {
            System.out.println(line);
            // read next line
            line = br.readLine();
	}

	br.close();
       //Read the text and make it into an array
        
    }
    
    public static void choice2() {
        System.out.println("Choice 2");
    }
}
