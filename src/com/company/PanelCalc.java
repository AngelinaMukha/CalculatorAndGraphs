package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class PanelCalc extends JPanel{
String num1="0", num2="0", sign=null;
    public PanelCalc(){
        this.setBackground(Color.DARK_GRAY);
        setLayout(null);
        Font text = new Font("Sanserif", Font.BOLD, 40);
        JTextField output = new JTextField();
        output.setBounds(10,10,760,100);
        output.setEditable(false);
        output.setBackground(Color.white);
        output.setFont(text);
        output.setHorizontalAlignment(4);
        output.setText(num1);
        add(output);
        Font font = new Font("Sanserif", Font.BOLD, 70);
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                if(b.getText().equals("C")){
                    num1="0";
                    num2="0";
                    output.setText(num1);
                }
                if(b.getText().equals("HEX")){
                    int x=Integer.parseInt(num1);
                    num1=Integer.toHexString(x)+"";
                    output.setText(num1);
                }
                if(b.getText().equals("DEC")){
                    int x=Integer.parseInt(num1,16);
                    output.setText(x+"");
                }
                if(b.getText().equals("OCT")){
                    int x=Integer.parseInt(num1);
                    num1=Integer.toOctalString(x)+"";
                    output.setText(num1);
                }
                if(b.getText().equals("BIN")){
                    int x=Integer.parseInt(num1);
                    num1=Integer.toBinaryString(x)+"";
                    output.setText(num1);
                }
                if((b.getText().equals("=") || b.getText().equals(sign) || b.getText().equals("%")) && (!(num2.equals("0")) && !(num1.equals("0")))){
                    if(b.getText().equals("%")){
                        double x= ((Double.parseDouble(num2)/100)* Double.parseDouble(num1));
                        num1 = x + "";
                    }

                    if(sign.equals("+")){
                        double x= (Double.parseDouble(num2) + Double.parseDouble(num1));
                        num1 = x + "";
                        num2 = "0";
                        if(x-(int)x==0){
                            output.setText(String.valueOf((int)x));
                        }else {
                            output.setText(num1);
                        }
                    }
                    if(sign.equals("-")){
                        double x= (Double.parseDouble(num2) - Double.parseDouble(num1));
                        num1= x+"";
                        num2="0";
                        if(x-(int)x==0){
                            output.setText(String.valueOf((int)x));
                        }else {
                            output.setText(num1);
                        }
                    }
                    if(sign.equals("*")){
                        double x= (Double.parseDouble(num2) * Double.parseDouble(num1));
                        num1= x+"";
                        num2="0";
                        if(x-(int)x==0){
                            output.setText(String.valueOf((int)x));
                        }else {
                            output.setText(num1);
                        }
                    }
                    if(sign.equals("/")){
                        double x= (Double.parseDouble(num2) / Double.parseDouble(num1));
                        num1= x+"";
                        num2="0";
                        if(x-(int)x==0){
                            output.setText(String.valueOf((int)x));
                        }else {
                            output.setText(num1);
                        }
                    }
                    if(sign.equals("√")){
                        double x= (Math.sqrt(Double.parseDouble(num2)));
                        num1= x+"";
                        num2="0";
                        if(x-(int)x==0){
                            output.setText(String.valueOf((int)x));
                        }else {
                            output.setText(num1);
                        }
                    }
                }

                //choosing sign
                if(b.getText().equals("+") && !(num1.equals("0"))){
                    num2=num1;
                    num1="0";
                    sign="+";
                    double x= Double.parseDouble(num2);
                    if(x-(int)x==0){
                        output.setText(String.valueOf((int)x)+"+");
                    }else {
                        output.setText(x+"+");
                    }
                }
                if(b.getText().equals("-") && !(num1.equals("0"))){
                    num2=num1;
                    num1="0";
                    sign="-";
                    double x= Double.parseDouble(num2);
                    if(x-(int)x==0){
                        output.setText(String.valueOf((int)x)+"-");
                    }else {
                        output.setText(x+"-");
                    }
                }
                if(b.getText().equals("*") && !(num1.equals("0"))){
                    num2=num1;
                    num1="0";
                    sign="*";
                    double x= Double.parseDouble(num2);
                    if(x-(int)x==0){
                        output.setText(String.valueOf((int)x)+"*");
                    }else {
                        output.setText(x+"*");
                    }
                }
                if(b.getText().equals("/") && !(num1.equals("0"))){
                    num2=num1;
                    num1="0";
                    sign="/";
                    double x= Double.parseDouble(num2);
                    if(x-(int)x==0){
                        output.setText(String.valueOf((int)x)+"/");
                    }else {
                        output.setText(x+"/");
                    }
                }
                 if(b.getText().equals("√") && !(num1.equals("0"))){
                    num2=num1;
                    num1="1";
                    sign="√";
                    double x= Double.parseDouble(num2);
                    if(x-(int)x==0){
                        output.setText("root("+String.valueOf((int)x)+")");
                    }else {
                        output.setText("root("+x+")");
                    }
                }
                if (b.getText().equals(".") || (b.getText(). matches("\\d"))) {
                    if (b.getText().equals(".") && (output.getText().indexOf(".")) >= 0) {
                    } else if ((b.getText().equals("0") && num1.equals("0")) || (num1.equals("0") && !(b.getText().equals(".")))) {
                        num1 = b.getText();
                        output.setText(num1);
                    } else {
                        num1 = output.getText() + b.getText();
                        output.setText(num1);
                    }
                }
            }
        };
        for(int i=0; i<3;i++) {
            for(int j=0; j<3;j++){
                JButton b = new JButton((j*3+i+1)+"");
                b.setBounds(i*120+10,(j+1)*120,100,100);
                b.setFont(font);
                add(b);
                b.addActionListener(l);
            }
        }
        JButton b0 = new JButton("0");
        b0.setBounds(10,480,220,100);
        b0.setFont(font);
        add(b0);
        b0.addActionListener(l);

        JButton bp = new JButton(".");
        bp.setBounds(250,480,100,100);
        bp.setFont(font);
        bp.setBackground(Color.lightGray);
        add(bp);
        bp.addActionListener(l);

        JButton clear = new JButton("C");
        clear.setBounds(490,120,100,100);
        clear.setFont(font);
        clear.setBackground(Color.lightGray);
        add(clear);
        clear.addActionListener(l);

        JButton minus = new JButton("-");
        minus.setBounds(370,120,100,100);
        minus.setFont(font);
        minus.setBackground(Color.lightGray);
        add(minus);
        minus.addActionListener(l);

        JButton plus = new JButton("+");
        plus.setBounds(370,240,100,100);
        plus.setFont(font);
        plus.setBackground(Color.lightGray);
        add(plus);
        plus.addActionListener(l);

        JButton mult = new JButton("*");
        mult.setBounds(370,360,100,100);
        mult.setFont(font);
        mult.setBackground(Color.lightGray);
        add(mult);
        mult.addActionListener(l);

        JButton del = new JButton("/");
        del.setBounds(370,480,100,100);
        del.setFont(font);
        del.setBackground(Color.lightGray);
        add(del);
        del.addActionListener(l);

        JButton eql = new JButton("=");
        eql.setBounds(490,480,100,100);
        eql.setFont(font);
        eql.setBackground(Color.lightGray);
        add(eql);
        eql.addActionListener(l);

        JButton per = new JButton("%");
        per.setBounds(490,240,100,100);
        per.setFont(font);
        per.setBackground(Color.lightGray);
        add(per);
        per.addActionListener(l);

        JButton root = new JButton("√");
        root.setBounds(490,360,100,100);
        root.setFont(font);
        root.setBackground(Color.lightGray);
        add(root);
        root.addActionListener(l);


        JButton hex = new JButton("HEX");
        hex.setBounds(610,120,160,100);
        hex.setFont(text);
        hex.setBackground(Color.GRAY);
        add(hex);
        hex.addActionListener(l);

        JButton dec = new JButton("DEC");
        dec.setBounds(610,240,160,100);
        dec.setFont(text);
        dec.setBackground(Color.GRAY);
        add(dec);
        dec.addActionListener(l);

        JButton oct = new JButton("OCT");
        oct.setBounds(610,360,160,100);
        oct.setFont(text);
        oct.setBackground(Color.GRAY);
        add(oct);
        oct.addActionListener(l);

        JButton bin = new JButton("BIN");
        bin.setBounds(610,480,160,100);
        bin.setFont(text);
        bin.setBackground(Color.GRAY);
        add(bin);
        bin.addActionListener(l);

    }

}
