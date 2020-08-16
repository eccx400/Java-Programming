import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * This program creates random balls around using the animation base
 * To use this code, we have to construct the animation using the animation
 * base app and moving balls.
 * 
 * @author Eric Cheng
 * @version 1/8/2013
 * 
 * @author Period - 6
 * @author Assignment - Ch38BEx1_MarchingLines1
 * 
 * @author Sources - Eric Cheng
 */
public class Ch38BEx3_BouncingBalls extends AnimationBase
{
    //Creates balls
    
    BouncingBall x1; 
    BouncingBall x2; 
    BouncingBall x3; 
    BouncingBall x4; 
    BouncingBall x5; 
    BouncingBall x6; 
    BouncingBall x7;  
    BouncingBall x8;  
    BouncingBall x9; 
    BouncingBall x10;
    BouncingBall x11; 
    BouncingBall x12; 
    BouncingBall x13; 
    BouncingBall x14; 
    BouncingBall x15; 
    BouncingBall x16; 
    BouncingBall x17; 
    BouncingBall x18; 
    BouncingBall x19; 
    BouncingBall x20; 
    BouncingBall x21; 
    BouncingBall x22; 
    BouncingBall x23; 
    BouncingBall x24; 
    BouncingBall x25; 
    BouncingBall x26; 
    BouncingBall x27; 
    BouncingBall x28; 
    BouncingBall x29; 
    BouncingBall x30;  
    BouncingBall x31; 
    BouncingBall x32; 
    BouncingBall x33;  
    BouncingBall x34; 
    BouncingBall x35; 
    BouncingBall x36; 
    BouncingBall x37; 
    BouncingBall x38; 
    BouncingBall x39; 
    BouncingBall x40; 
    BouncingBall x41; 
    BouncingBall x42; 
    BouncingBall x43;
    BouncingBall x44; 
    BouncingBall x45; 
    BouncingBall x46;  
    BouncingBall x47;   
    BouncingBall x48; 
    BouncingBall x49; 
    BouncingBall x50; 
  
  
    /** 
     * This routine is called by the system when the applet is first created. 
     */
    public void init() 
    { 
        Random rand = new Random();
        int x = 100; 
  
        x1 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x2 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x3 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x4 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x5 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x6 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x7 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x8 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ),
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x9 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x10 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5,
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x11 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x12 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ),
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x13 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x14 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x15 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x16 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x17 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x18 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ),
                rand.nextInt( 256 ) ) ); 
        x19 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x20 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x21 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x22 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x23 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x24 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x25 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x26 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x27 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x28 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5,
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x29 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x30 = new BouncingBall( 0, 
            0,
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x31 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x32 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5,
            new Color( rand.nextInt( 256 ),
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x33 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x34 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x35 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ),
                rand.nextInt( 256 ) ) ); 
        x36 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x37 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x38 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ),
                rand.nextInt( 256 ) ) ); 
        x39 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x40 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x41 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x42 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) ); 
        x43 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x44 = new BouncingBall( 0, 
            0,
            rand.nextInt( x / 5 ) + 5,

            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x45 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x46 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x47 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ),

                rand.nextInt( 256 ) ) );
        x48 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x49 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );
        x50 = new BouncingBall( 0, 
            0, 
            rand.nextInt( x / 5 ) + 5, 
            new Color( rand.nextInt( 256 ), 
                rand.nextInt( 256 ), 
                rand.nextInt( 256 ) ) );  
        setMillisecondsPerFrame( 10 ); 
    } 
  
    /** 
     * This routine is called by the animation framework every time a new frame 
     * needs to be drawn. 
     *  
     * For this animation, We create the different weight and heights for the
     * balls and that creates the bouncing balls
     */
    public void drawFrame( Graphics g ) 
    { 
        int w = getWidth(); 
        int h = getHeight(); 
        g.setColor( Color.BLACK ); 
        g.fillRect( 0, 0, w, h ); 
  
        x1.doFrame( g, w, h ); 
        x2.doFrame( g, w, h ); 
        x3.doFrame( g, w, h ); 
        x4.doFrame( g, w, h ); 
        x5.doFrame( g, w, h ); 
        x6.doFrame( g, w, h ); 
        x7.doFrame( g, w, h ); 
        x8.doFrame( g, w, h ); 
        x9.doFrame( g, w, h ); 
        x10.doFrame( g, w, h ); 
        x11.doFrame( g, w, h ); 
        x12.doFrame( g, w, h ); 
        x13.doFrame( g, w, h ); 
        x14.doFrame( g, w, h ); 
        x15.doFrame( g, w, h ); 
        x16.doFrame( g, w, h ); 
        x17.doFrame( g, w, h ); 
        x18.doFrame( g, w, h ); 
        x19.doFrame( g, w, h ); 
        x20.doFrame( g, w, h ); 
        x21.doFrame( g, w, h ); 
        x22.doFrame( g, w, h ); 
        x23.doFrame( g, w, h ); 
        x24.doFrame( g, w, h ); 
        x25.doFrame( g, w, h ); 
        x26.doFrame( g, w, h ); 
        x27.doFrame( g, w, h ); 
        x28.doFrame( g, w, h ); 
        x29.doFrame( g, w, h ); 
        x30.doFrame( g, w, h ); 
        x31.doFrame( g, w, h ); 
        x32.doFrame( g, w, h ); 
        x33.doFrame( g, w, h ); 
        x34.doFrame( g, w, h ); 
        x35.doFrame( g, w, h ); 
        x36.doFrame( g, w, h ); 
        x37.doFrame( g, w, h ); 
        x38.doFrame( g, w, h ); 
        x39.doFrame( g, w, h ); 
        x40.doFrame( g, w, h ); 
        x41.doFrame( g, w, h ); 
        x42.doFrame( g, w, h ); 
        x43.doFrame( g, w, h );
        x44.doFrame( g, w, h );
        x45.doFrame( g, w, h );
        x46.doFrame( g, w, h );
        x47.doFrame( g, w, h );
        x48.doFrame( g, w, h );
        x49.doFrame( g, w, h );
        x50.doFrame( g, w, h );
    } 
} 