/**
 * HelloPlanets Testing. Using the code, we can make the computer print out the 
 * words Hello plus the name of the 9 planets afterward.
 * 
 * @author 5121400
 * @version Aug 23, 2013
 * @author Period: 6
 * @author Assignment: Ch07_HelloPlanets
 * 
 * @author Sources: Eric Cheng
 */
public class HelloPlanets
{
    public static void main( String[] args )
    {
        String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter",
            "Saturn", "Uranus", "Neptune", "Pluto" };

        for ( int j = 0; j < planets.length; j++ )
        {
            System.out.println( "Hello " + planets[j] + "!" );
        }
    }
}