package com.national_naming;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private LinkedList<Naming> namelist;
    public String filepath="Data/NationalNames.csv";
    public Menu(){
        Data_Read dr=new Data_Read();
        System.out.println("Name data are loading....");
        namelist=dr.read_Data(filepath);
        user_Choose();
    }

    public void display_Menu(){
        System.out.println("====================================");
        System.out.println("||        ==================      ||\n" +
                           "||      //                  \\\\    ||\n" +
                           "||     ||   M   E   N   U   ||    ||\n" +
                           "||      \\\\_________________//     || ");
        System.out.println("||================================||");
        System.out.println("||    1. New Naming               ||");
        System.out.println("||    2. Edit Naming              ||");
        System.out.println("||    3. Delete Naming            ||");
        System.out.println("||    4. Display Top 10 Naming    ||");
        System.out.println("||    5. Display Latest Naming    ||");
        System.out.println("||    6. Exit                     ||");
        System.out.println("___________________________________");

    }

    public boolean check_Input(String input){
        switch (input){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6": return true;
            default:
                System.out.println("Enter only number between 1 and 6");
                return false;
            //case "1","2","3","4","5","6" -> {return true;}
            //default -> {return false;}
        }
    }

    public void user_Choose(){

        Scanner sc=new Scanner(System.in);
        display_Menu();
        System.out.print("Enter menu number between 1 and 6: ");
        String input =sc.nextLine();

        while (!check_Input(input)){
            System.out.println("*Enter only number between 1 and 6!!");
            System.out.print("Enter menu number betwveen 1 and 6: ");
            input=sc.nextLine();
        }
        switch(input){
            case "1": {
                new NewNaming(namelist);
                user_Choose();
            }
            case "2":{
                new Edit_Name(namelist);
                user_Choose();
            }
            case "3":{
                new Delete_Name(namelist);
                user_Choose();
            }
            case "4":{
                new Top_Ten_Name(namelist);
                user_Choose();
            }
            case "5":{
                new Latest_Name(namelist);
                user_Choose();
            }
            case "6": System.exit(0);
        }
    }

    public static void main(String[] args) {
//        Menu program=new Menu();
//        program.user_Choose();
        new Menu();
    }
}


