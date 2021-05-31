package sk.stuba.fei.uim.oop.utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonResponse implements ActionListener {
    Controller controller;
    private int shapeSelected;
    public ButtonResponse(Controller controller,int shapeSelected) {
        this.controller= controller;
        this.shapeSelected=shapeSelected;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.setShapeSelected(shapeSelected);

    }
}
