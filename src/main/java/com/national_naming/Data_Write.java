package com.national_naming;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Data_Write {
    public void write_Data(String data,String pathname){
        try{
            FileWriter fw=new FileWriter(pathname,true);//file add mhr so boolean append true
            PrintWriter pw=new PrintWriter(fw);
            pw.println(data);
            pw.close();
            fw.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //For data update,delete
    public void write_All_Data(LinkedList<Naming>ll,String pathname){
        try{
            FileWriter fw=new FileWriter(pathname,false);//File ko new pyn yay append false
            PrintWriter pw=new PrintWriter(fw);
            pw.println("Id,Name,Year,Gender,Count");

            for (Naming n:ll){
                pw.println(n.getId()+","+n.getName()+","+n.getYear()+","+n.getGender()+","+n.getCount());
            }
            pw.close();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
