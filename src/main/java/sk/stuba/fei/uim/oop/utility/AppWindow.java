package sk.stuba.fei.uim.oop.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AppWindow extends JFrame implements ItemListener {


    public AppWindow() {createWindow();
    }
    JLabel displayColor;
    Controller controller=new Controller();
    private void createWindow(){
        JFrame apllication=new JFrame();
        apllication.setLayout(new BorderLayout());
        apllication.setSize(1000,1000);
        apllication.setDefaultCloseOperation(apllication.EXIT_ON_CLOSE);

        JPanel upperPanel =new JPanel();
        upperPanel.setLayout(new GridLayout(1,3));
        JPanel loverPanel =new JPanel();
        loverPanel.setLayout(new GridLayout(1,2));

        JButton circle=new JButton("CIRCLE");
        circle.addActionListener(new  ButtonResponse(controller,1));
        JButton line=new JButton("LINE");
        line.addActionListener(new ButtonResponse(controller,2));
        JButton changeColor=new JButton("CHANGE COLOR");
        changeColor.addActionListener(new ButtonResponse(controller,0));

        displayColor=new JLabel();
        displayColor.setBackground(Color.BLACK);
        displayColor.setOpaque(true);
        Choice colorChooser=new Choice();
        colorChooser.add("Black");
        colorChooser.add("Blue");
        colorChooser.add("Red");
        colorChooser.add("Green");
        colorChooser.addItemListener(this);

        upperPanel.add(circle);
        upperPanel.add(line);
        upperPanel.add(changeColor);
        loverPanel.add(colorChooser);
        loverPanel.add(displayColor);

        apllication.add("North",upperPanel);
        apllication.add("South",loverPanel);
        apllication.add("Center",controller.myCanvas);
        apllication.setDefaultCloseOperation(apllication.EXIT_ON_CLOSE);
        apllication.setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals("Red")){
            displayColor.setBackground(Color.RED);
            displayColor.setOpaque(true);
            controller.setColorSelected(2);}
        else if (e.getItem().equals("Green")){
            displayColor.setBackground(Color.GREEN);
            displayColor.setOpaque(true);
            controller.setColorSelected(3);}
        else if (e.getItem().equals("Blue")){
            displayColor.setBackground(Color.BLUE);
            displayColor.setOpaque(true);
            controller.setColorSelected(1);}
        else {
            displayColor.setBackground(Color.BLACK);
            displayColor.setOpaque(true);
            controller.setColorSelected(0);}
    }
    }
