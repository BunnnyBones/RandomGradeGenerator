package com.company.views;

import com.company.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdLineView {

    private String filePath;
    private String fileName = "names.txt";

    public void promptInput(){

        System.out.println("Please Enter the path to the file");
        System.out.print("Your Input: ");

        Scanner in = new Scanner(System.in);

        filePath = in.next();

        System.out.println("What is the name of your file?(I.E. \"names.txt\")");
        System.out.print("Your Input: ");

        fileName = in.next();

    }

    public void emptyFile(){
        System.out.println("There was no corresponding file at that location");
        System.out.println("One has been created for you at the specified location");
        System.out.println("Please enter the names of the students you wish to be on the list");
        System.out.println("Please enter \"stop\" when you wish to stop");
    }

    public String fillFile(){
        System.out.print("\nYour Input: ");

        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public String getFilePath(){
        return filePath;
    }

    public String getFileName(){
        return fileName;
    }

    public void displayInformation(ArrayList<Student> list){
        //Separate inputs in new file creation and outputs in the console
        System.out.print("\n");
        for(Student student : list){
            System.out.println("Student Name: " + student.getName());
            System.out.println(student.getName() + "'s Percentage Grade: " + student.getPercentGrade());
            System.out.println(student.getName() + "'s Letter Grade: " + student.getGrade() + "\n");
        }
    }

}
