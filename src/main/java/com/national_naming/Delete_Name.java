package com.national_naming;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Delete_Name {
    private LinkedList<Naming> namelist;

    //Constructor
    public Delete_Name(LinkedList<Naming>namelist){
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

    //Confirm for delete
    private boolean check_Confirm(String confirm){
        if (confirm.isEmpty()) {
            System.out.println("Invalid Confirm!!");
            return false;
        }
        if (!(confirm.contentEquals("Y")||confirm.contentEquals("N"))) {
            System.out.println(" Must be Y or N!!");
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

            System.out.print("Enter Confirm Y or N: ");
            String confirm = sc.nextLine();
            while (!check_Confirm(confirm.trim())) {
                System.out.println("Enter Confirm Y or N: ");
                confirm = sc.nextLine();
            }

            if (confirm.contentEquals("Y")) {
                //For Data edit
                namelist.remove(index);
                Data_Write dw = new Data_Write();
                dw.write_All_Data(namelist, "Data/NationalNames.csv");

                System.out.println("Name is deleted...");
            }
        }
        else {
            System.out.println("Enter ID is not found!");
        }
    }
}
