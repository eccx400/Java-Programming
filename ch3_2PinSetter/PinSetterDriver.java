import kareltherobot.*;

// TODO: add comments

public class PinSetterDriver implements Directions
{
    public static void main( String args[] )
    {
        PinSetter bot = new PinSetter( 1, 5, North, 10 );
        bot.setPins();
        bot.turnOff();
    }

    static
    {
        World.reset();
        World.readWorld( "10x10.wld" );
        World.setDelay( 15 );
        World.setVisible( true );
    }
}
