import java.util.*;
import java.io.*;

/**
  Contains static methods for creating music according to Mozart's
  Musikalisches Wurfelspiel --Mozart's musical dice game. 
  
  Within this class, a parameter d of type double[] is supposed
  to be the values in a .wav array, as created by a call on
  StdAudio.read.
 */
public class WurfelSpiel
{
    private final static int measure= 16; // The number of measures in a minuet or trio
    private final static int die= 6;      // Maximum value of a roll of a die
   
    private static Random generator= new Random();
    
    /**
     * Possible measure numbers for a minuet. For measure k of the minuet,
     * 0 <= k < 16, choose a random measure number from column k.
     */
    private final static int[][] minuet= {
      { 96,  22, 141,  41, 105, 122,  11,  30,  70, 121,  26,   9, 112,  49, 109,  14},
      { 32,   6, 128,  63, 146,  46, 134,  81, 117,  39, 126,  56, 174,  18, 116,  83},
      { 69,  95, 158,  13, 153,  55, 110,  24,  66, 139,  15, 132,  73,  58, 145,  79},
      { 40,  17, 113,  85, 161,   2, 159, 100,  90, 176,   7,   4,  67, 160,  52, 170},
      {148,  74, 163,  45,  80,  97,  36, 107,  25, 143,  64, 125,  76, 136,   1,  93},
      {104, 157,  27, 167, 154,  68, 118,  91, 138,  71, 150,  29, 101, 162,  23, 151},
      {152,  60, 171,  53,  99, 133,  21, 127,  16, 155,  57, 175,  43, 168,  89, 172},
      {119,  84, 114,  50, 140,  86, 169,  94, 120,  88,  48, 166,  51, 115,  72, 111},
      { 98, 142,  42, 156,  75, 129,  62, 123,  65,  77,  19,  82, 137,  38, 149,   8},
      {  3,  87, 165,  61, 135,  47, 147,  33, 102,   4,  31, 164,  44,  59, 173,  78},
      { 54, 130,  10, 103,  28,  37, 106,   5,  35,  20, 108,  92,  12, 124,  44, 131}
    };
    
    /**
     * Possible measure numbers for a trio. For measure k of the minuet,
     * 0 <= k < 16, choose a random measure number from column k.
     */
    private final static int[][] trio= {
      {72,  6, 59, 25, 81, 41, 89, 13, 36,  5, 46, 79, 30, 95, 19, 66},
      {56, 82, 42, 74, 14,  7, 26, 71, 76, 20, 64, 84,  8, 35, 47, 88},
      {75, 39, 54,  1, 65, 43, 15, 80,  9, 34, 93, 48, 69, 58, 90, 21},
      {40, 73, 16, 68, 29, 55,  2, 61, 22, 67, 49, 77, 57, 87, 33, 10},
      {83,  3, 28, 53, 37, 17, 44, 70, 63, 85, 32, 96, 12, 23, 50, 91},
      {18, 45, 62, 38,  4, 27, 52, 94, 11, 92, 24, 86, 51, 60, 78, 31}
    };
    
    // The only constructor is private, so no instances can be created
    // outside the class.
    private WurfelSpiel() {}
    
    /**
     * = a roll of a die --an int in the range 1..6
     */
    public static int throwDie()
    {
        int roll = generator.nextInt( 6 ) + 1;
        return roll;
    }
    
    /**
     * String rep of s: i.e. the string [s[0], s[1], ..., ]
     */
    public static String toString(String[] s)
    {
        {
            /**
             * The kind of loop you write here is standard for producing a list of
             * things with comments between elements. You are expected to study the
             * result and to be able to develop such code after writing this method.
             */
            
            String res = "[";
             
            // invariant: res contains "[" followed by sa[0..i-1],         
            // with commas BETWEEN elements.
            for ( int i = 0; i != s.length; i = i + 1 )  
            {         
                if ( i == 0 ) 
                {
                    res = res + ( s[i] );                 
                } 
                else                 
                {            
                    res = res + ( ", " + s[i] );            
                }
                     
                /**                   
                 * Process sa[i]. This is done in two steps. (1) If this is not the        
                 * first iteration, append ", " to res. (2) Append s[i] to res.       
                 */      
            }          
            res = res + "]";       
            return res;
        }
    }
     
    
    /**
     * Play the measure given by mn.
     */
    public static void playMeasure(MNumber mn)
    {
        int n= mn.getLabel();
        String name= mn.isTrio() ? trioMeasure(n) : minuetMeasure(n);
        File file= new File(name);
        if (file.exists())
        {
            StdAudio.playAudio(name);
        }
        else
        {
            System.out.println("You tried to play the measure in file "
                + name + ". The file does not");
            System.out.println("exist. Did you place directory measures in the proper place?");
        }
        
    }
    
    /**
     * = the name of trio measure number n
     */
    public static String trioMeasure(int n)
    {
        return "measures/T" + n + ".wav";
    }
    
    /**
     * = the name of minuet measure number n
     */
    public static String minuetMeasure(int n)
    {
        return "measures/m" + n + ".wav";
    }
    
    /**
       = A String array that contains the names of all the files
       described by row 0 of array minuet and row 0 of array trio .<br><br>
      
       The file names are of the form<br><br>
      
         "measures/m<integer>.wav" and "measures/T<integer>.wav",<br><br>
      
       so the files are expected to be in directory measures.<br><br>
      
       Here is an example of a file name: "measures/T5.wav"
     */
    public static String[] create0Spiel()
    {
        String[] array = new String[( trio[0].length + minuet[0].length )];
        for ( int j = 0; j < minuet[0].length; j++ )
        {
            array[j] = minuetMeasure( minuet[0][j] );
        }
        for ( int y = 0; y < trio[0].length; y++ )
        {
            array[y + minuet[0].length] = trioMeasure( trio[0][y] );
        }
        return array;
    }
    
    /** Play the music given by files whose names are in s, in order */
    public static void play(String[] s)
    {
        for ( int j = 0; j < s.length; j++ )
        {
            StdAudio.playAudio( s[j] );
        }
    }
    
        
    /**
         = an array of random measure filenames: 16 for a minuet
         and then 16 for a trio, as explained in the A6 handout.<br><br>
          
         The filenames have the form<br><br>
          
            "measures/m<integer>.wav" and
            "measures/T<integer>.wav"<br><br>
         
         so the files are expected to be in directory measures, 
         which should be in the same folder as this class.<br><br>
         
         Here is an example of a file name: "measures/T5.wav"
     */
    public static String[] createRandomSpiel()
    {
        String[] array = new String[( trio[0].length + minuet[0].length )];
        for ( int x = 0; x < minuet[0].length; x++ )
        {
            int rand = throwDie() + throwDie() - 2;
            array[x] = minuetMeasure( minuet[rand][x] );
        }
        for ( int y = 0; y < trio[0].length; y++ )
        {
            int rand = throwDie() - 1;
            array[y + minuet[0].length] = trioMeasure( trio[rand][y] );
        }
        return array;
 
    }
    
    
    /**
     * Put all the measures given by file names in s into a new array d and
     * return d. For example, suppose s contains three file names, and the
     * length of the three files are 50, 15, and 30.
     * Then in the returned array,<br>
     * the values in the first file go in d[0..49],<br>
     * the values in the second file go in d[50..64],<br>
     * the values in the third file go in d[65..94].<br>
     */
    public static double[] build(String[] s)
    {
        // First, calculate the length of the array.
        // The files must be read in order to proceed.
        int length = 0;
        for ( int x = 0; x < s.length; x++ )
        {
            length = length + StdAudio.read( s[x] ).length;
        }
 
        // int length is the length of the array
 
        // Declare and create a double array of the proper size and read
        // the files again, storing the values into the newly created array.
        double[] neuesArray = new double[length];
        int count = 0;
        for ( int j = 0; j < s.length; j++ )
        {
            double[] x = StdAudio.read( s[j] );
            copy( x, neuesArray, count );
            count = count + x.length;
        }
        return neuesArray;
    }
      
    /**
     * Play d. Precondition. d is the contents of a .wav file.
     */
    public static void play(double[] d)
    {
        StdAudio.play(d);
    }
    
    /**
     * Place the values in array d into b[k], b[k+1], ...
     */
    public static void copy(double[] d, double[] b, int k)
    {
        for (int i= 0; i != d.length; i= i+1)
        {
            b[k+i]= d[i];   
        }
    }
}
