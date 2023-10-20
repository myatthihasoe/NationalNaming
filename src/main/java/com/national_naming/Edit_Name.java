package com.national_naming;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Edit_Name {
    private LinkedList<Naming> namelist;

    //Constructor
    public Edit_Name(LinkedList<Naming>namelist){
        this.namelist=namelist;
        get_Data();
    }

    private boolean check_Id(String id){
        if (!id.matches("[0-9]+")){
            System.out.println("Invalid ID");
            return false;
        }
        return true;
    }

    private boolean check_Name(String name) {
//        if (!name.matches("[a-z][A-Z]{3,50}")){//for a to z and + is for one or more / [A-Z]{1}[a-z]{2,49}  example > Leo
//            System.out.println("Invalid name!");
//            return false;
//        }
        if (name.isEmpty()) {
            System.out.println("Invalid Name!!");
            return false;
        }
        if (name.contains(" ")) {
            System.out.println("Enter only one word name.");
            return false;
        }
        if (name.length() > 50) {
            System.out.println("Enter name within 50 character.");
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println("Name must be only in alphabets.");
                return false;
            }
        }
        return true;
    }

    private boolean check_Year(String year){
        if (year.isEmpty()) {
            System.out.println("Invalid Year!!");
            return false;
        }
        try {
            int y=Integer.parseInt(year);
            if (y<1800||y>2100){
                System.out.println("Enter year between 1800 and 2100");
                return false;
            }
        }
        //Number format exception
        catch (Exception e){
            System.out.println("Enter only number for year!");
            return false;
        }
        return true;
    }

    private boolean check_Name_Year(String id,String name,String year){
//        for (Naming n:namelist){
//            if (n.getId()!=Integer.parseInt(id)&& n.getName().contentEquals(name)&& n.getYear()==Integer.parseInt(year)){
//                System.out.println("Name is already exist!");
//                return false;
//            }
//        }
        //String for big data bcos faster
        Predicate<Naming>forid=p->p.getId()!=Integer.parseInt(id);
        Predicate<Naming> forname= p->p.getName().contentEquals(name);
        Predicate<Naming>foryear=p->p.getYear()==Integer.parseInt(year);
        Predicate<Naming>foridnameyear=forid.and(forname.and(foryear));
        if (namelist.stream().anyMatch(foridnameyear)){
            System.out.println("Name is already present.");
            return false;
        }
        return true;
    }

    private boolean check_Gender(String gender){
        if (gender.isEmpty()) {
            System.out.println("Invalid Gender!!");
            return false;
        }
        if (!(gender.contentEquals("M")||gender.contentEquals("F"))) {
            System.out.println("Enter gender must be M or F!!");
            return false;
        }
        return true;
    }

    private boolean check_Count(String count){
        if (count.isEmpty()) {
            System.out.println("Invalid Year!!");
            return false;
        }
        try {
            int c=Integer.parseInt(count);
            if (c<1){
                System.out.println("Enter count at least 1");
                return false;
            }
        }
        //Number format exception
        catch (Exception e){
            System.out.println("Enter only number for Count!");
            return false;
        }
        return true;
    }

    private void get_Data() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        while (!check_Id(id.trim())) {
            System.out.println("Enter ID: ");
            id = sc.nextLine();
        }

        int index = -1;
        int i = 0;
        for (Naming n : namelist) {
            if (n.getId() == Integer.parseInt(id)) {
                index = i;
                break;
            }
            i++;
        }

        if (index >= 0) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            while (!check_Name(name.trim())) {
                System.out.println("Enter Name: ");
                name = sc.nextLine();
            }

            System.out.println("Enter Year: ");
            String year = sc.nextLine().trim();
            while (!check_Year(year)) {
                System.out.println("Enter Year: ");
                year = sc.nextLine();
            }

            //for duplicate name
            while (!check_Name_Year(id,name,year)) {
                System.out.print("Enter Name: ");
                name = sc.nextLine();
                while (!check_Name(name.trim())) {
                    System.out.println("Enter Name: ");
                    name = sc.nextLine();
                }

                System.out.println("Enter Year: ");
                year = sc.nextLine().trim();
                while (!check_Year(year)) {
                    System.out.println("Enter Year: ");
                    year = sc.nextLine();
                }
            }

            System.out.println("Enter Gender: ");
            String gender = sc.nextLine();
            while (!check_Gender(gender)) {
                System.out.println("Enter Gender: ");
                gender = sc.nextLine();
            }

            System.out.println("Enter Count: ");
            String count = sc.nextLine();
            while (!check_Count(count)) {
                System.out.println("Enter Count: ");
                count = sc.nextLine();
            }

            //For Data edit
            namelist.set(index,new Naming(Integer.parseInt(id), name, Integer.parseInt(year), gender, Integer.parseInt(count)));
            Data_Write dw = new Data_Write();
            dw.write_All_Data(namelist,"Data/NationalNames.csv");

            System.out.println("Name is edited...");
        }
        else {
            System.out.println("Enter ID is not found!");
        }
    }
}
