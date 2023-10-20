package com.national_naming;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

//import java.util.List;

import java.util.*;
import java.util.stream.Collectors;

public class Latest_Name{

    private LinkedList<Naming> namelist;

    public Latest_Name(LinkedList<Naming> namelist) {
        this.namelist = namelist;
        display();
    }

    private void display(){
        Naming n= namelist.stream().collect(Collectors.maxBy(Comparator.comparing(Naming::getYear))).get();
        List<Naming> nlst = namelist.stream().filter(p->p.getYear()==n.getYear()).collect(Collectors.toList());

        //year last name random twy paw
        LinkedList<Naming>maxnamelst=new LinkedList<>(nlst);
        Collections.sort(maxnamelst,Comparator.comparing(Naming::getName)); //Collections.reverseOrder Descending order

        // copy paste from Top ten names
        Collections.sort(namelist,Collections.reverseOrder(Comparator.comparing(Naming::getCount)));
        System.out.println("Latest Name");
        System.out.println("==============");

        //table row create
        List<String> header = Arrays.asList("ID","NAME","YEAR","GENDER","COUNT");
        AsciiTable as=new AsciiTable();
        as.addRule();
        as.addRow(header);
        as.addRule();

        //System.out.println(maxnamelst.size()); for all data htoke pya
//        System.out.println("Id,Name,Year,Gender,Count");

        for (int index = 0; index < maxnamelst.size(); index++){
         Naming nm=maxnamelst.get(index);
            List<Object> data = Arrays.asList(nm.getId(), nm.getName(), nm.getYear(), nm.getGender(), nm.getCount());
            as.addRow(data);
            as.addRule();
        }
        as.setTextAlignment(TextAlignment.CENTER);
        System.out.println(as.render());

    }
}


