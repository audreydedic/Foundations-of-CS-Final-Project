import javax.swing.*;
import java.awt.*;

public class SkyObjects extends Square{
    private int dX;
    private int dY;

    private int ob;
    private ImageIcon b;

   
    public SkyObjects(int s, int x, int y, Color c){
      super(s,x,y,c);
   }



   public void drawMe(Graphics g){
      //ImageIcon coney = new ImageIcon("cone.png");
      //ImageIcon bokbok = new ImageIcon("helicopter.png");
      //g.drawImage(bokbok.getImage(),getX(),getY(),getSide()+50,getSide()+20,null);
      

   }
   
   //accessors
   public int getDX()
   {
      return dX;
   }
   
   public int getDY()
   {
      return dY;
   }
   
   //modifiers
   public void setDX(int dXValue)
   {
      dX = dXValue;
   }
   
   public void setDY(int dYValue)
   {
      dY = dYValue;
   }
   
      
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      setX(getX() + dX);
      setY(getY() + dY);   

      //ob = 5;
     // ob = Math.random(5);

      }

   }
   
