package com.national_naming;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;


public class Top_Ten_Name {
    private LinkedList<Naming> namelist;

    public Top_Ten_Name(LinkedList<Naming> namelist) {
        this.namelist = namelist;
        display();
    }
    private void display(){
        //Collection sort
        Collections.sort(namelist, Collections.reverseOrder(Comparator.comparing(Naming::getCount)));//Collections.reverseOrder Descending order

        System.out.println("Top Ten Name");
        System.out.println("==============");

        List<String> header = Arrays.asList("ID","NAME","YEAR","GENDER","COUNT");
        AsciiTable at=new AsciiTable();
        at.addRule();
        at.addRow(header);
        at.addRule();

       // System.out.println("ID,Name,Year,Gender,Count");

        for (int index =0; index <10; index++){
            Naming n=namelist.get(index);
            List<Object> data = Arrays.asList(n.getId(), n.getName(), n.getYear(), n.getGender(), n.getCount());
           //at.addRule();
            at.addRow(data);
           at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        System.out.println(at.render());
    }
}
