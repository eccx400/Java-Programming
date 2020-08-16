import java.awt.Color;
import java.awt.Graphics;

public class Circle
{
  // variables
  private int x, y, radius;
  private Color color;

  // constructors
  public Circle()
  { x = 0; y = 0; radius = 0; color = Color.black;}

  public Circle( int x, int y, int radius )
  { this.x = x;  this.y = y;  this.radius = radius; color = Color.black;}

  // methods
  void draw( Graphics gr )
  {
    int ulX = x-radius ; // X of upper left corner of rectangle
    int ulY = y-radius ; // Y of upper left corner of rectangle
    gr.setColor( color );
    gr.drawOval( ulX, ulY, 2*radius, 2*radius );
  }
  
  void drawFilled( Graphics gr )
  {
    int ulX = x-radius ; // X of upper left corner of rectangle
    int ulY = y-radius ; // Y of upper left corner of rectangle
    gr.setColor( color );
    gr.fillOval( ulX, ulY, 2*radius, 2*radius );
  }


  // change the center of the circle to a new X and Y
  void setPosition( int newX, int newY )
  {
    x = newX ;
    y = newY ;
  }

  // change the radius of the circle
  void setRadius( int newR )
  {
    radius = newR;
  }
  
  // change the color of the circle
  void setColor( Color newC )
  {
    color = newC;
  } 
}