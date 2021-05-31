package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

public class Controller {
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
            lastShapeCreated=new Circle(x,y,endX,endY);
            return lastShapeCreated;
        }
        else {
            lastShapeCreated=new Line(x,y,endX,endY);
            return lastShapeCreated;
        }

    }
    public void recountMyCoordinates(Shapes circle){
         int startX=circle.x;
         int startY=circle.y;
         int endX=circle.endX;
         int endY=circle.endY;

         if (endX>startX&&endY>startY){
             if (endX-startX>endY-startY){
                 endY=endY+(endX-startX)-(endY-startY);
                 endY=endY-startY;
                 endX=endY;
                 circle.x=startX;
                 circle.y=startY;
                 circle.endX=endX;
                 circle.endY=endY;
             }

         }
    }

    /*public void modifyLastShape(int x,int y, int endX, int endY){
        lastShapeCreated.x=x;
        lastShapeCreated.y=y;
        lastShapeCreated.endX=endX;
        lastShapeCreated.endY=endY;
    }*/

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
}
