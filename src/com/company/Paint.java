package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paint extends JPanel {
    public static int x = 250;
    public static int y = 280;
    public int a = 0, b = 0, c = 0, d=0;

    Paint() {
        this.setBounds(10, 10, 500, 570);
        this.setBackground(new Color(0xFFFFE811, true));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = 500, h = 570;
        g2.setColor(Color.GRAY);
        for (int y = 10; y <= h; y += 10) {
            g2.drawLine(0, y, w - 1, y);
        }
        for (int x = 10; x <= w; x += 10) {
            g2.drawLine(x, 0, x, h - 1);
        }
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(249, 0, 3, h);
        g2.fillRect(0, 279, w, 3);
        g2.setColor(Color.red);

        ArrayList<Function> fun = FuncStor.list;
        if (!(fun.isEmpty())) {
            for (int i = 0; i < fun.size(); i++) {

                g2.setColor(fun.get(i).color);
                if (fun.get(i).type.equals("const")) {
                    if (fun.get(i).check == true) {
                        int z = y - (Integer.parseInt(fun.get(i).s) * 10);
                        g2.fillRect(0, z, w, 3);
                    }
                }


                if (fun.get(i).type.equals("linear")) {
                    Pattern sq = Pattern.compile("([+-]?\\d+?)?\\*?x([+-]?\\d+?)?");
                    Matcher m = sq.matcher(fun.get(i).s);
                    String str = (fun.get(i).s).replace("-x", "-1x");
                    str = str.replace("+x", "+1x");
                    if ((str.charAt(0)) == 'x') {
                        str = str.replaceFirst("x", "+1x");
                    }
                    Matcher matcher = sq.matcher(str);
                    if (matcher.matches() == true) {
                        if (matcher.group(1) != null) {
                            a = Integer.parseInt(matcher.group(1));
                        }
                        if (matcher.group(2) != null) {
                            b = Integer.parseInt(matcher.group(2));
                        }
                        System.out.println("a=" + a + " b=" + b);
                        int x1 = -250;
                        int y1 = a * x1 + b;
                        int x2 = 250;
                        int y2 = a * x2 + b;
                        BasicStroke dashed = new BasicStroke(3.0f);
                        g2.setStroke(dashed);
                        g2.drawLine(x + x1 * 10, y - y1 * 10, x + x2 * 10, y - y2 * 10);
                        b=0;
                        a=0;
                    }
                }

                if (fun.get(i).type.equals("x^2")) {
                    Pattern sq = Pattern.compile("([+-]?\\d+?)?\\*?x\\^2([+-]?\\d+?)?\\*?x?([+-]?\\d+?)?");
                    Matcher m = sq.matcher(fun.get(i).s);
                    String str = (fun.get(i).s).replace("-x", "-1x");
                    str = str.replace("+x", "+1x");
                    if ((str.charAt(0)) == 'x') {
                        str = str.replaceFirst("x", "+1x");
                    }
                    Matcher matcher = sq.matcher(str);
                    if (matcher.matches() == true) {
                        if (matcher.group(1) != null) {
                            a = Integer.parseInt(matcher.group(1));
                        }
                        // System.out.println(a + " " + b + " " + c);
                        if (matcher.group(2) != null) {
                            b = Integer.parseInt(matcher.group(2));
                        }
                        if (matcher.group(3) != null) {
                            c = Integer.parseInt(matcher.group(3));
                        }
                        Pattern c2 = Pattern.compile("(.*)x[+-](.*)?");
                        Matcher mc = c2.matcher(str);
                        System.out.println(mc.matches());
                        if(mc.matches() == false){
                            System.out.println(" here");
                            int temp=c;
                            c=0;
                            d=temp;

                        }
                        System.out.println("a=" + a + " b=" + b + " c=" + c);

                    }
                    int x1, y1, x2, y2;
                    for (int k = -250; k < 250; k += 1) {
                        x1 = k * 10;
                        y1 = (a * k * k + b * k + c) * 10;
                        x2 = (k + 1) * 10;
                        y2 = (a * (k + 1) * (k + 1) + b * (k + 1) + c) * 10;


                        BasicStroke bold = new BasicStroke(3.0f);
                        g2.setStroke(bold);
                        g2.drawLine((x + x1), (y - y1), (x + x2), (y - y2));

                    }
                    c=0;
                    b=0;
                    a=0;
                }
//--------------------------------------------------------------------------------------------
                if (fun.get(i).type.equals("x^3")) {
                    Pattern sq = Pattern.compile("([+-]?\\d+?)?\\*?x\\^3([+-]?\\d+?)?\\*?x?\\^?2?([+-]?\\d+?)?\\*?x?([+-]?\\d+?)?");
                    Matcher m = sq.matcher(fun.get(i).s);
                    String str = (fun.get(i).s).replace("-x", "-1x");
                    str = str.replace("+x", "+1x");
                    if ((str.charAt(0)) == 'x') {
                        str = str.replaceFirst("x", "+1x");
                    }

                    Matcher matcher = sq.matcher(str);
                    if (matcher.matches() == true) {
                        if (matcher.group(1) != null) {
                            a = Integer.parseInt(matcher.group(1));
                        }
                        if (matcher.group(2) != null) {
                            System.out.println(matcher.group(2));
                            b = Integer.parseInt(matcher.group(2));
                        }
                        if (matcher.group(3) != null) {
                            System.out.println(matcher.group(3));
                            c = Integer.parseInt(matcher.group(3));
                        }
                        if(matcher.group(4) != null && !matcher.group(4).equals("-")) {
                              d = Integer.parseInt(matcher.group(4));
                        }
                        Pattern b2 = Pattern.compile("(.*)x\\^2(.*)?");
                        Matcher mb = b2.matcher(str);
                        System.out.println(mb.matches());
                        if(mb.matches() == false){
                            int temp=b;
                            d=c;
                            b=0;
                            c=temp;
                        }
                        Pattern c2 = Pattern.compile("(.*)x[+-](.*)?");
                        Matcher mc = c2.matcher(str);
                        System.out.println(mc.matches());
                        if(mc.matches() == false){
                            System.out.println(" here");
                            int temp=c;
                            c=0;
                            d=temp;

                        }
                        System.out.println("a=" + a + " b=" + b + " c=" + c+" d="+d);


                    }
                    int x1, y1, x2, y2;
                    for (int k = -250; k < 250; k += 1) {
                        x1 = k * 10;
                        y1 = (a * k*k*k + b * k*k + c*k+d) * 10;
                        x2 = (k + 1) * 10;
                        y2 = (a * (k + 1)*(k + 1)*(k + 1) + b * (k + 1)*(k + 1) + c*(k + 1)+d) * 10;


                        BasicStroke bold = new BasicStroke(3.0f);
                        g2.setStroke(bold);
                        g2.drawLine((x + x1), (y - y1), (x + x2), (y - y2));

                    }
                    d=0;
                    c=0;
                    b=0;
                    a=0;
                }

            }
        }
    }
}

