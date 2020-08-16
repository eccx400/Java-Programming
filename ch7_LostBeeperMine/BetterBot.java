import kareltherobot.*;
import java.awt.Color;

public class BetterBot extends Robot
{
   public BetterBot( int st, int av, Direction dir, int beeps )
   {
      super( st, av, dir, beeps );
   }

   public BetterBot( int st, int av, Direction dir, int beeps, Color badge )
   {
      super( st, av, dir, beeps, badge );
   }

   public void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();
   }

   public void turnAround()
   {
      turnLeft();
      turnLeft();
   }

   public void faceEast()
   {
      if ( !facingEast() )
      {
         turnLeft();
         faceEast();
      }
   }

   public void faceSouth()
   {
      if ( !facingSouth() )
      {
         turnLeft();
         faceSouth();
      }
   }

   public void faceNorth()
   {
      if ( !facingNorth() )
      {
         turnLeft();
         faceNorth();
      }
   }

   public void faceWest()
   {
      if ( !facingWest() )
      {
         turnLeft();
         faceWest();
      }
   }

   public boolean rightIsBlocked()
   {
      turnRight();
      if ( frontIsClear() )
      {
         turnLeft();
         return false;
      }
      turnLeft();
      return true;
   }
}



