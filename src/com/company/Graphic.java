package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel {
    Graphic(){
        boolean pressGo=false;
        setBackground(Color.darkGray);
        setLayout(null);
        Paint grid = new Paint();
        this.add(grid);

        FunctionBlock fb1 = new FunctionBlock();
        add(fb1);
        fb1.setBounds(520,20,250,75);

        FunctionBlock fb2 = new FunctionBlock();
        add(fb2);
        fb2.setBounds(520,130,250,75);

        FunctionBlock fb3 = new FunctionBlock();
        add(fb3);
        fb3.setBounds(520,240,250,75);

        FunctionBlock fb4 = new FunctionBlock();
        add(fb4);
        fb4.setBounds(520,350,250,75);

        ActionListener draw = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton start1 = (JButton) e.getSource();
                start1.setBackground(Color.orange);
                for(Function i: FuncStor.list){
                    System.out.println(i.s);
                }

                    grid.repaint();

            }
        };
        Font text = new Font("Sanserif", Font.BOLD, 20);
        //Button start
        JButton start = new JButton("START");
        start.setFont(text);
        start.setBounds(520,500,250,50);
        start.setBackground(Color.GRAY);
        start.addActionListener(draw);
        add(start);
    }


}
