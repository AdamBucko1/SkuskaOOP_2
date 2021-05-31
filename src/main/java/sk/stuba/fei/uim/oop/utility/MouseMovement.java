package sk.stuba.fei.uim.oop.utility;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMovement extends MouseAdapter {
    Shapes newShape;
    Controller controller;
    public MouseMovement(Controller controller) {
        this.controller=controller;
    }

    private int startX=0;
    private int startY=0;
    private int endX=0;
    private int endY=0;
    @Override
    public void mousePressed(MouseEvent e){
        startX=e.getX();
        startY=e.getY();
        System.out.println(startX);
        if (controller.getShapeSelected()==1||controller.getShapeSelected()==2){
        newShape=controller.createNewShape(startX,startY,endX,endY);}
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        if (controller.getShapeSelected() == 1 || controller.getShapeSelected() == 2) {
            newShape.x = startX;
            newShape.y = startY;
            if (newShape instanceof Line){
            newShape.endX = endX;
            newShape.endY = endY;}
            else if (newShape instanceof Circle){
                controller.recountMyCoordinates(newShape);
            }

            controller.allShapes.add(newShape);

            controller.myCanvas.repaint();
            System.out.println("end   " + endX);
        }
    }
}
