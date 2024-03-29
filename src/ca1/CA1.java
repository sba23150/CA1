/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * GitHub Repo: https://github.com/sba23150/CA1.git
 * 
 * @author Tatiana Mota - sba23150
 * 
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The program has a menu that lets the user decide between standard operation (option 1) or adding (validated) data to the status.txt file via the console (option 2). 
        BufferedReader myBufReader = new BufferedReader (new InputStreamReader(System.in));
        try{
            System.out.println("Please choose 1 for Standard Operation or 2 to add the data via console");
            int userOption = Integer.parseInt(myBufReader.readLine());
            switch(userOption){
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                default:
                    System.out.println("Something went wrong.");
            }
            
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
        
               
    }
    
    public static void option1() {
        //create an array list to storage the student.text data
        ArrayList<String> studentsTxtArray = new ArrayList<String>();
        
        //read students.txt using Scanner
        try {
            Scanner myReader = new Scanner(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\CA1\\students.txt"));
            while (myReader.hasNextLine()) {
                String studentsTxt = myReader.nextLine();
                studentsTxtArray.add(studentsTxt);
            }
        }catch (Exception e){
            System.out.println("File access error!");
        }
        int studentsTxtArraySize = studentsTxtArray.size();
        
        //Validating the students.txt
        
        //a)The first name must be letters only;
        //b)The second name can be letters and/or numbers and must be separated from the first name by a single space;
        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> secondName = new ArrayList<String>();
        String [] fullName;

        for (int i=0;i<studentsTxtArraySize;i=i+3){
            String name = studentsTxtArray.get(i);

            fullName = name.split(" ");
            if (fullName.length==2){
                //separating First of Last Name into two arrays.
                firstName.add(fullName[0]);
                secondName.add(fullName[1]);    
            } else {
                System.out.println("Something went wrong with the name in the line "+ i+1);
            }
        }
        
        for (int i=0;i<firstName.size();i++){
            
                //validate First Name that must be letters only. 
                if(!firstName.get(i).matches("^[a-zA-Z]+$")){
                    System.out.println("First Name must be letters only. Something went wrong with the name in the line "+ (i+1));
                }

                //The second name can be letters and/or numbers and must be separated from the first name by a single space; loop starts 1 and every 4
                if(!secondName.get(i).matches("^[a-zA-Z0-9]+$")){
                    System.out.println("Second Name must be letters and/or numbers only. Something went wrong with the name in the line "+ (i+1));
                }
        }
        
        
        //c)The number of classes must be an integer value between 1 and 8 (inclusive) 
         //define workload: 
        //nClasses = 1 = Very Light; nClasses = 2 = Light; nClasses = 3,4,5 = Part Time; nClasses >=6 = Full Time;
        ArrayList<String> workload = new ArrayList<String>();
        
        for (int i=1;i<studentsTxtArraySize;i=i+3){
            String nClasses = studentsTxtArray.get(i);

            if(Integer.parseInt(nClasses)==1){
                nClasses= "Very Light";
                workload.add(nClasses);
            } else if (Integer.parseInt(nClasses)==2){
                nClasses= "Light";
                workload.add(nClasses);
            } else if (Integer.parseInt(nClasses)==3 || Integer.parseInt(nClasses)==4 || Integer.parseInt(nClasses)==5){
                nClasses= "Part Time";
                workload.add(nClasses);
            } else if (Integer.parseInt(nClasses)==6 || Integer.parseInt(nClasses)==7 || Integer.parseInt(nClasses)==8){
                nClasses= "Full Time";
                workload.add(nClasses);
            } else {
                System.out.println("Wrong number of classes. Something went wrong in the line "+ (i+1));
            }
        }        
        
        //d)The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number.
        ArrayList<String> studentNoArray = new ArrayList<String>();
        
        for (int i=2;i<studentsTxtArraySize;i=i+3){
            String studentNo = studentsTxtArray.get(i);

            if(studentNo.matches("^\\d{2}[a-zA-Z]{2}\\w\\d+$")){
                studentNoArray.add(studentNo);
            } else{
                System.out.println("The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number. Something went wrong in the line "+ (i+1));
            }
        }

        
        //If the data is valid, then you have to output the data to a file name status.txt,in the following format:
        // Student number - Second Name
        //Wordload
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter("status.txt",true));
            for (int i=0;i<firstName.size();i++){
                bw.write(studentNoArray.get(i)+" - "+secondName.get(i));
                bw.newLine();
                bw.write(workload.get(i));
                bw.newLine();
            }
            bw.close(); // Close the BufferedWriter after writing all data
            System.out.println("Data written to status.txt successfully.");    
        }
        catch (Exception e){
            System.out.println("Error criating a new File.");
        }
    }
    
    public static void option2() {
        System.out.println("Option 2.");
        BufferedReader myBufReader = new BufferedReader (new InputStreamReader(System.in));
        try{
            //ask how many student to know the size of the data
            System.out.println("Please type how many students info you will input");
            int numberStudents = Integer.parseInt(myBufReader.readLine());
            
            //initializing arrays for first name,second name, number of classes and student number
            String[] firstName = new String[numberStudents];
            String[] secondName = new String[numberStudents];
            String[] workload = new String[numberStudents];
            String[] studentNumber = new String[numberStudents];
            
            //read and validate the console input data 
            for(int i=0;i<numberStudents;i++){
                //Read and validate First Name
                System.out.println("Please type first name");
                firstName[i] = myBufReader.readLine();
                while(!firstName[i].matches("^[a-zA-Z]+$")){
                    System.out.println("First Name must be letters only. Please type first name");
                    firstName[i] = myBufReader.readLine();
                }
                
                //Read and validate Second Name
                System.out.println("Please type second name");
                secondName[i] = myBufReader.readLine();
                while(!secondName[i].matches("^[a-zA-Z0-9]+$")){
                    System.out.println("Second Name must be letters and/or numbers only. Something went wrong with the name in the line "+ (i+1));
                    secondName[i] = myBufReader.readLine();
                }
                
                //Read and validate Number of Classes
                System.out.println("Please type number of classes");
                int numberClasses = Integer.parseInt(myBufReader.readLine());
                //define workload: 
                //nClasses = 1 = Very Light; nClasses = 2 = Light; nClasses = 3,4,5 = Part Time; nClasses >=6 = Full Time;
                while(numberClasses<1 || numberClasses>8){
                    System.out.println("The number of classes must be an integer value between 1 and 8 (inclusive)");
                    numberClasses = Integer.parseInt(myBufReader.readLine());
                }
                    if(numberClasses==1){
                        workload[i]= "Very Light";
                        
                    } else if (numberClasses==2){
                        workload[i]= "Light";
                        
                    } else if (numberClasses==3 || numberClasses==4 || numberClasses==5){
                        workload[i]= "Part Time";
                        
                    } else if (numberClasses==6 || numberClasses==7 || numberClasses==8){
                        workload[i]= "Full Time";
                        
                    } else {
                        System.out.println("Wrong number of classes.");
                    }
                  
                
                //Read and validate Student number - The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number.
                System.out.println("Please type student number");
                studentNumber[i] = myBufReader.readLine();
                while(!studentNumber[i].matches("^\\d{2}[a-zA-Z]{2}\\w\\d+$")){
                    System.out.println("The student“number” must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4thcharacters (and possibly 5th) being a letter, and everything after the last letter character being a number. Please provide student number again.");
                    studentNumber[i] = myBufReader.readLine();
                }
            }
            for(int i=0;i<numberStudents;i++){
                //If the data is valid, then you have to output the data to a file name status.txt,in the following format:
                // Student number - Second Name
                //Wordload
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("status.txt",true));
                    for (i=0;i<numberStudents;i++){
                        bw.write(studentNumber[i]+" - "+secondName[i]);
                        bw.newLine();
                        bw.write(workload[i]);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to status.txt successfully.");    
                }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
            }
            
            
            
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }
    
    /*Attempt to create a method to validate student number as per task 1 and 2 for distinction work
    public static boolean studentNoValid(String studentNo){
        //check if the student number is at least 6 chars long
        if (studentNo.length()<6){
            return false;
        }
        
        //check if the first two chars are numbers 
        if (!Character.isDigit(studentNo.charAt(0)) || !Character.isDigit(studentNo.charAt(1))){
            return false;
        }
        
        //check if the first two chars are <20
        int year = Integer.parseInt(studentNo.substring(0,2));
        if (year<20){
            return false;
        }
        
        //check that 3rd and 4th chars are letters
        if (!Character.isLetter(studentNo.charAt(2)) || !Character.isDigit(studentNo.charAt(3))){
            return false;
        }
        
        // Check if from the 6th number (index 5) is only numbers
        for (int i=5;i<studentNo.length();i++){
            if (!Character.isDigit(studentNo.charAt(i))){
            return false;
            }
        }
        
        // Extract the number part after the letters from index 5
        String numberPart = studentNo.substring(studentNo.length()-5);
        if (studentNo.length() > 5) {
            numberPart = studentNo.substring(4,studentNo.length()-1);
        }

        // Check if the number part is within the range 1-200
        int number = Integer.parseInt(numberPart);
        if (number < 1 || number > 200) {
            return false;
        }

        return true;
    }*/
}
