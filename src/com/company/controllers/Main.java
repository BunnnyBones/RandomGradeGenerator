package com.company.controllers;

import com.company.models.Student;
import com.company.views.CmdLineView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //I probably did not do MVC right

        ArrayList<String> listOfNames = new ArrayList<>();

        getInput controller = new getInput();
        boolean tag = false;

        CmdLineView view = new CmdLineView();

        view.promptInput();

        String stringDirectory = view.getFilePath();
        String fileName = view.getFileName();
        Path directoryPath = Paths.get(stringDirectory);
        Path filePath = Paths.get(stringDirectory, fileName);

        if(Files.notExists(directoryPath)){
            try{
                Files.createDirectories(directoryPath);
            } catch(IOException x){
                x.printStackTrace();
            }
        }

        if(Files.notExists(filePath)){
            try{
                Files.createFile(filePath);
                tag = true;
            } catch(IOException x){
                x.printStackTrace();
            }
        }

         //Creating the file object after initialization and checks
        File activeFile = filePath.toFile();

        //If no file was detected and needed to be created, then the user will be prompted...
        //to input any names they want on the file, and it will record the names in the new file
        if(tag){
            controller.emptyFile(activeFile);
        }

         //Reading "activeFile" and copying the contents per line into "listOfNames"
        try {
            FileReader fileReader = new FileReader(activeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;
            try{
                while((input = bufferedReader.readLine()) != null){
                    listOfNames.add(input);
                }
                bufferedReader.close();
            } catch(IOException x){
                x.printStackTrace();
            }

        } catch (IOException x){
            x.printStackTrace();
        }

        //The file should be created and filled with data by this point, and listOfNames should have
        //all the students names. Now is the grade generating and then output

        Random rand = new Random();
        ArrayList<Student> studentList = new ArrayList<>();

        for(String name : listOfNames){
            int grade = rand.nextInt(100) +1;

            Student student = new Student(name, grade);
            if(grade >= 90){
                student.setGrade("A");
            } else if(grade >= 80){
                student.setGrade("B");
            } else if(grade >= 70){
                student.setGrade("C");
            } else if(grade >= 60){
                student.setGrade("D");
            } else {
                student.setGrade("F");
            }
            studentList.add(student);
        }

        view.displayInformation(studentList);

    }
}
