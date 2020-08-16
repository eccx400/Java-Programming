import kareltherobot.*;
import java.awt.Color;

public class LostMineFinder extends BetterBot
{
   public LostMineFinder( int st, int av, Direction dir, int beeps )
   {
      super( st, av, dir, beeps );
   }

   public LostMineFinder( int st, int av, Direction dir, int beeps, Color c )
   {
      super( st, av, dir, beeps, c );
   }

   public void pickAll()
   {
      if ( !nextToABeeper() )
      {
         return;
      }
      pickBeeper();
      pickAll();
   }

   public int pickAndCountAll()
   {
      if ( !nextToABeeper() )
      {
         return 0;
      }
      pickBeeper();
      return pickAndCountAll() + 1;
   }

   public void findBeeper()
   {
      if ( nextToABeeper() )
      {
         return;
      }
      move();
      findBeeper();
   }

   public void findMine()
   {
      if ( nextToABeeper() )
      {
         turnLeft();
      }
      else
      {
         move();
         findMine();
         move();
      }
   }
}