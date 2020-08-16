/**
   Chapter 9c - Object Data
   Programming Exercises 1-4

   @author  Eric Cheng
   @version 10/23/2013

   Period - 6
   Assignment - Ch09bEx1_3

   Sources - Eric Cheng
 */
public class Ch09cEx1_4
{
   /**
    * 
    */
public Ch09cEx1_4()
   {
       //empty constructor
   }

   /**
      Object Created at Run Time
    */
   public void objAtRuntime()
   {
      String str = ( "Hello World");
      System.out.println( str );
   }
  
   /**
      String Length
    */
   public void stringLength()
   {
      String str;
      int    len;

      str = new String("Potato    .   .       ."  );

      len = str.length();

      System.out.println("The length is: " + len );
   }
  
   /**
       A String Method that creates a new String
    */
   public void createNewString()
   {
      String first = new String( "  In a Hole    in the ground there lived a Hobbit.");
      String second;
      second = first.trim();
      System.out.println(first);
      System.out.println(second);
   }

   /**
       Play with substring() exercise
    */
   public void playWithSubstring()
   {
       String str = new String( "Golf is a good walk spoiled." ); // create the original object

       String sub = str.substring(2, 28); //create a new object from the original

       System.out.println( sub );  
   }

   /**
       Testing method: instantiates a Ch09cEx1_4 object and
       then invokes each method
      
       @param  args  command-line parameters (not used)
    */
   public static void main (String[] args )
   {
      Ch09cEx1_4 exercise = new Ch09cEx1_4();
          
      exercise.objAtRuntime();
      System.out.println();
          
      exercise.stringLength();
      System.out.println();
      
      exercise.createNewString();
      System.out.println();

      exercise.playWithSubstring();
      System.out.println();
   }
}
