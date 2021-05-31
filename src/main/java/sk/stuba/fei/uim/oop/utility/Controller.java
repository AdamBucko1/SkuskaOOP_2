package sk.stuba.fei.uim.oop.utility;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Controller{
    public MyCanvas myCanvas=new MyCanvas(this);
    public ArrayList<Shapes> allShapes=new ArrayList<>();
    private int shapeSelected=0;
    private int colorSelected=0;
    MouseMovement mouseMovement;
    private Shapes lastShapeCreated;
    public Controller() {
        this.mouseMovement=new MouseMovement(this);
        myCanvas.addMouseListener(mouseMovement);
        myCanvas.addMouseMotionListener(mouseMovement);
    }
    public Shapes createNewShape(int x,int y, int endX, int endY){
        if (shapeSelected==1){
            lastShapeCreated=new Circle(x,y,endX,endY,colorSelected);
            return lastShapeCreated;
        }
        else {
            lastShapeCreated=new Line(x,y,endX,endY,colorSelected);
            return lastShapeCreated;
        }

    }
    public void recountMyCoordinates(Shapes circle,int startX, int startY){
         int endX=circle.endX;
         int endY=circle.endY;

         int width;
         int length;

         width=abs(startX-endX);
         length=abs(startY-endY);
         if (width>length){
             width=length;
         }
        else {
            length=width;
         }
        if (startX>endX){
            circle.x=startX-width;
        }
        if (startY>endY){
            circle.y=startY-length;
        }

        circle.endX=width;
        circle.endY=length;




    }

    public int getShapeSelected() {
        return shapeSelected;
    }

    public void setShapeSelected(int shapeSelected) {
        this.shapeSelected = shapeSelected;
    }

    public int getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(int colorSelected) {
        this.colorSelected = colorSelected;
    }

    public void selectShape(int coordX, int coordY) {
        for (int i=0;i<allShapes.size();i++){
            Shapes thisShape=allShapes.get(allShapes.size()-i-1);
            if (thisShape.shapeType==1){
                Shape innerCircle= new Ellipse2D.Double(thisShape.x+(thisShape.endX)/3,thisShape.y+(thisShape.endY)/3,thisShape.endX/3,thisShape.endY/3);
                Shape outerCircle= new Ellipse2D.Double(thisShape.x,thisShape.y,thisShape.endX,thisShape.endY);
                if (innerCircle.contains(coordX,coordY)){
                    continue;
                }
                else if (outerCircle.contains(coordX,coordY)){
                        thisShape.colourOfObject=colorSelected;
                        break;
                }

            }
            else if (thisShape.shapeType==2){
                double distanceFromLine= Line2D.ptLineDist(thisShape.x,thisShape.y,thisShape.endX,thisShape.endY,coordX,coordY);
                if (distanceFromLine<2.000){
                    thisShape.colourOfObject=colorSelected;
                    break;
                }

            }
        }
    }
}
