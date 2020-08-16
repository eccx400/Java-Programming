import kareltherobot.*;
import java.awt.Color;

/**
   KJR Chapter 7 Recursion Lecture Examples

   @author  Mr. Peck
   @version Sep 27, 2006

   Period - 1-7
   Assignment - LostBeeperMine

   Sources - David Wittry
 */
public class LostMineFinderTest implements Directions
{
    public static void main(String args[])
    {
        LostMineFinder Carol = new LostMineFinder(1, 1, East, 0, Color.red);
        
        //Carol.setUserPause(true);      
        //Carol.userPause("Enter to start");
        
        Carol.findBeeper();
        Carol.pickAll();
        
        Carol.findMine();

        System.out.println("Carol mined " + Carol.pickAndCountAll() + " beepers");
        
        Carol.turnOff();  
    } 

    static
    {
        World.reset(); 
        World.readWorld("LostBeeperMine.wld");
        World.setDelay(5);
        World.setTrace( false );
        World.setVisible(true);
    }
}
