package sk.stuba.fei.uim.oop.utility;

import java.awt.*;

public class MyCanvas extends Canvas {
    Controller controller;
    public MyCanvas(Controller controller) {
        this.controller=controller;
    }

    public void paint(Graphics g){
        for (int i=0;i<controller.allShapes.size();i++){
            Shapes currentShape=controller.allShapes.get(i);
            if (currentShape.colourOfObject==0){
                g.setColor(Color.BLACK);
            }
            if (currentShape.colourOfObject==1){
                g.setColor(Color.BLUE);
            }
            if (currentShape.colourOfObject==2){
                g.setColor(Color.RED);
            }
            if (currentShape.colourOfObject==3){
                g.setColor(Color.GREEN);
            }
            if (currentShape.shapeType==2){
                g.drawLine(currentShape.x,currentShape.y,currentShape.endX,currentShape.endY);
            }
            else if (controller.allShapes.get(i).shapeType==1){
                g.fillOval(currentShape.x,currentShape.y,currentShape.endX,currentShape.endY);
                g.setColor(Color.WHITE);
                g.fillOval(currentShape.x+(currentShape.endX)/3,currentShape.y+(currentShape.endY)/3,currentShape.endX/3,currentShape.endY/3);
            }
        }
    }
}
