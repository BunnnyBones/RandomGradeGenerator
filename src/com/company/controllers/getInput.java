package com.company.controllers;

import com.company.views.CmdLineView;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class getInput {

    private final CmdLineView view = new CmdLineView();

    private final ArrayList<String> list = new ArrayList<>();

    public void emptyFile(File file){
        view.emptyFile();
        String input = view.fillFile();
        list.add(input);

        while(!(input.toLowerCase(Locale.ROOT).equals("stop"))){
            input = view.fillFile();
            list.add(input);
        }

        list.remove("stop");
        list.remove("Stop");

        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for(String x : list){
                out.println(x);
            }
            out.close();
        } catch(IOException x){
            x.printStackTrace();
        }
    }



}
