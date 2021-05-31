package sk.stuba.fei.uim.oop.utility;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame{


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
        displayColor=new JLabel();
        Choice colorChooser=new Choice();
        colorChooser.add("Black");
        colorChooser.add("Blue");
        colorChooser.add("Red");
        colorChooser.add("Green");

        upperPanel.add(circle);
        upperPanel.add(line);
        upperPanel.add(changeColor);
        loverPanel.add(colorChooser);
        loverPanel.add(displayColor);

        apllication.add("North",upperPanel);
        apllication.add("South",loverPanel);
        apllication.add("Center",controller.myCanvas);
        apllication.setVisible(true);

    }
}
