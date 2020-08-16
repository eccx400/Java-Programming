import kareltherobot.*;

/**
 *  A MountainClimber Driver (test).
 *
 *  @author  George Peck
 *  @version August 30, 2010
 *  @author  Period: 1-7
 *  @author  Assignment: KJR Ch2_6MountainClimber
 *
 *  @author  Sources: Joseph Bergin
 */
public class MountainClimberDriver implements Directions
{
   /**
    * Instantiate a MountainClimber and invoke its climbMountain method.
    * @param args command-line arguments not used
    */
   public static void main( String args[] )
   {
      MountainClimber edmund = new MountainClimber( 1, 3, East, 1 );
      
      edmund.climbMountain();
      edmund.turnOff();
   }

   static
   {
      World.reset();
      World.readWorld( "ch2_6.wld" );
      World.setDelay( 10 );
      World.setVisible( true );
   }
}