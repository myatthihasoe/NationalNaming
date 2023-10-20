package com.national_naming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Data_Read {
    public LinkedList<Naming> read_Data(String filepath){
        LinkedList<Naming> ll=new LinkedList<>();
        try{
            FileReader fr=new FileReader((filepath));//harddisk to memory run
            BufferedReader br=new BufferedReader(fr);
            String line= br.readLine();
            while((line=br.readLine())!=null){
                String[] data=line.split(",");//corma CSV data
                ll.add(new Naming(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4])));

            }
            br.close();
            fr.close();
        }

        //for user pyn yay error handling
        catch (Exception e){
            e.printStackTrace();//error for developer
        }
        return ll;
    }
}
