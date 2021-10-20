package com.company;

import java.awt.*;

public class Function {
    String s;
    Color color;
    boolean check=false;
    String type;
    Function(String s, Color color, boolean check, String type){
        this.s=s;
        this.color=color;
        this.check=check;
        this.type=type;
    }
    public void addToStor(){
        FuncStor.list.add(this);
        System.out.println("I am in storage)");
    }
}
