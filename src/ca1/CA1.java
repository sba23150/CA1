/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tatiana Mota
 */
public class CA1 {

    
    public static void main(String[] args) throws IOException{
        /*GitHub link:
        https://github.com/sba23150/CA1
        */
                
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
    
    public static ArrayList<String> choice1() throws FileNotFoundException, IOException {
        //Using BufferedReader to read student.txt. 
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\CA1\\students.txt"))){
           System.out.println("Read successfully");   
           
        //we need at least two students, for each student we have 3 lines or 4 elements/words, therefore, we need at least 6lines or 8 elements in the array
        // Count the number of lines
            int lineCount = 0;
            while (br.readLine() != null) {
                lineCount++;
            }
            if (lineCount <6){
                System.out.println("Not enough students info. Need at least two students info in the file.");

            }else{
                //validating student.txt

                //reading line with the First and Last Name. -> first line of every 3
                ArrayList<String> firstName = new ArrayList<String>();
                ArrayList<String> secondName = new ArrayList<String>();
                
                for (int i=0;i<lineCount;i=i+3){
                    String name = br.readLine();
                    String[] fullName = name.split(" ");

                    //separating First of Last Name into two arrays.
                    
                    firstName.add(fullName[0]);
                    secondName.add(fullName[1]);

                    //validate First Name that must be letters only. 
                    if(!firstName.get(i).matches("^[a-zA-Z]+$")){
                        System.out.println("First Name must be letters only.");
                    } else{
                        firstName=null;
                    }

                    //The second name can be letters and/or numbers and must be separated from the first name by a single space; loop starts 1 and every 4
                    if(!secondName.get(i).matches("^[a-zA-Z0-9]+$")){
                        System.out.println("First Name must be letters and/or numbers only.");
                    } else {
                        secondName=null;
                    }
                }

                //The number of classes must be an integer value between 1 and 8 (inclusive) 
                ArrayList<String> numberClasses = new ArrayList<String>();
                for (int i=1;i<lineCount;i=i+3){
                    String nClasses = br.readLine();
                    
                    if(Integer.parseInt(nClasses)<1 && Integer.parseInt(nClasses)>8){
                        System.out.println("First Name must be letters only.");
                    } else{
                        numberClasses.add(nClasses);
                    }
                }

                //The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number.
                ArrayList<String> studentNoArray = new ArrayList<String>();
                for (int i=2;i<lineCount;i=i+3){
                    String studentNo = br.readLine();
                    
                    if(!studentNo.matches("^\\d{2}[a-zA-Z]{1,2}\\d{6,}$")){
                        System.out.println("The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number.");
                    } else{
                        studentNoArray.add(studentNo);
                    }
                }
                
                //considering all arguments are true, criate new file status.txt
                //if the size of the arrays are 0, that means that the was a problem on the verification above.
                if (firstName.length==0 || secondName.length==0 ||  numberClasses.length==0 || studentNoArray.length==0){
                    System.out.println("Error. Please see above problem with students info.");
                } else{
                    
                }
                
            }
        }catch (IOException e){
            System.out.println("Error reading file.");
        }    
        //return new file status.txt
        return null;
    }     

    private static void choice2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
