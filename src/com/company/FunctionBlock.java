package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionBlock extends JPanel {
    String s1;
    Color color1;
    boolean check1=false;
    String type;

    FunctionBlock(){
        setLayout(null);
        this.setBackground(Color.GRAY);
        //checkbox
        JCheckBox check = new JCheckBox();
        check.setBounds(5,5,30,30);
        add(check);
        Font text = new Font("Sanserif", Font.BOLD, 20);
        //setBounds(0,0,200,100);
        //window f(x)
        JTextField output1 = new JTextField();
        output1.setBounds(35,5,45,30);
        output1.setEditable(false);
        output1.setBackground(new Color(0xFFF7E5));
        output1.setFont(text);
        output1.setText("f(x)=");
        add(output1);

        //put function
        JTextField output2 = new JTextField();
        output2.setBounds(80,5,170,30);
        output2.setEditable(true);
        output2.setBackground(Color.white);
        output2.setFont(text);
        //output2.setText("x^2+5");
        add(output2);

        ActionListener cl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                //for color chooser
                if (b.getText().equals("color")){
                    //ColorChooser color = new ColorChooser();
                    //color.createWindow();
                    JFrame frame = new JFrame("Color");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JColorChooser colTable=new JColorChooser();
                    Font text1 = new Font("Sanserif", Font.BOLD, 30);
                    JButton button=new JButton("Choose color");
                    button.setFont(text1);
                    button.setBackground(Color.GRAY);
                    colTable.add(button,BorderLayout.NORTH);
                    button.addActionListener(
                            new ActionListener () {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Color c=colTable.getColor();
                                    color1=c;
                                    b.setBackground(c);
                                    button.setBackground(c);
                                }
                            });
                    Color col=colTable.getColor();
                    frame.add(colTable);
                    frame.setSize(650, 400);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }

                if(b.getText().equals("delete")){
                    int ind=0;
                    for(Function f: FuncStor.list){
                        if(output2.getText().equals(f.s)){
                            f.s="";
                            if(check.isSelected()) {
                                check.doClick();
                            }
                            output2.setBackground(Color.white);
                            ind= FuncStor.list.indexOf(f);
                            output2.setText(null);
                            System.out.println("deleted from list");
                        }
                    }
                    FuncStor.list.remove(FuncStor.list.get(ind));
                }

                if(b.getText().equals("ok")){
                    s1=output2.getText();

                    String pattern2 = "\\-?(\\d+)?\\*?x\\^2[\\+|\\-]?(\\d+)?\\*?x?[\\+|\\-]?(\\d+)?"; //x^2
                    String pattern3 = "\\-?(\\d+)?\\*?x\\^3[\\+|\\-]?(\\d+)?\\*?x?\\^?2?[\\+|\\-]?(\\d+)?\\*?x?[\\+|\\-]?(\\d+)?"; //x^3
                    String pattern1 = "\\-?(\\d+)?\\*?x[\\+|\\-]?(\\d+)?";// linear
                    String pattern0 = "\\-?(\\d+)"; // const function
                    Pattern p1 = Pattern.compile(pattern1);
                    Matcher m1 = p1.matcher(s1);
                    Pattern p2 = Pattern.compile(pattern2);
                    Matcher m2 = p2.matcher(s1);
                    Pattern p3 = Pattern.compile(pattern3);
                    Matcher m3 = p3.matcher(s1);
                    Pattern p0 = Pattern.compile(pattern0);
                    Matcher m0 = p0.matcher(s1);

                    if
                    (m1.matches()==true||m2.matches()==true||m3.matches()==true||m0.matches()==true)
                    {
                        if(m0.matches()==true){
                            type="const";
                        }
                        if(m1.matches()==true){
                            type="linear";
                        }
                        if(m2.matches()==true){
                            type="x^2";
                        }
                        if(m3.matches()==true){
                            type="x^3";
                        }
                        output2.setBackground(new Color(0xFFAFFF8E, true));
                                if(check.isSelected()){
                                    check1=true;
                                }
                                    Function f = new Function(s1, color1, check1, type);
                                    f.addToStor();

                    }else{
                        output2.setBackground(new Color(0xFFFF9786, true));
                        s1=null;
                    }
                }
            }
        };
        Font botF = new Font("Sanserif", Font.BOLD, 15);
        //color
        JButton choose = new JButton("color");
        choose.addActionListener(cl);
        choose.setBounds(10,40,80,30);
        choose.setFont(botF);
        choose.setBackground(Color.lightGray);
        add(choose);

        //delete
        JButton del = new JButton("delete");
        del.addActionListener(cl);
        del.setBounds(100,40,80,30);
        del.setFont(botF);
        del.setBackground(Color.DARK_GRAY);
        del.setForeground(Color.white);
        add(del);

        JButton ok = new JButton("ok");
        ok.addActionListener(cl);
        ok.setBounds(195,40,50,30);
        ok.setBackground(Color.orange);
        add(ok);

        setVisible(true);
    }
}
