package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame w= new JFrame("CaculatorAndGraphs");
        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        w.setBounds(screen.width/2-400, screen.height/2-325, 800,650);
        JTabbedPane panelTab=new JTabbedPane();
        panelTab.addTab("Calculator",new PanelCalc());
        panelTab.addTab("Graphic", new Graphic());
        w.setVisible(true);
        w.add(panelTab);
    }
}
