import java.io.*;

/**
   Prints out a table of x and ln(x) so that the table is formatted using HTML.
   A web page is created by first printing:
   
      <html>
      <body>
      <table cellspacing=10>
      <tr><th>x</th><th>ln(x)</th></tr>
   
   Next, for each iteration of the loop, x and log(x) are calculated and
   the following line is printed:
   
      "<tr><td>" + x + "</td><td>" + Math.log(x) + "</td></tr>"
   
   The web page is finalized by printing:
   
      </table>
      </body>
      </html>
   
   TWhen run the program writes the output to a disk file named myLogs.html.

   @author  Eric Cheng
   @version January 21, 2014

   @author  Period - 6

   @author  Sources - Eric Cheng
 */
public class Ex1_LogTable
{
    public static void main( String[] args ) throws IOException 
    { 
        File output = new File( "karelsLogs.html" ); 
        PrintStream print = new PrintStream( output ); 
        print.println( "<html>" ); 
        print.println( "<body>" ); 
        print.println( "<table border=\"1\">" ); 
        print.println( "<tr><th>x</th><th>ln(x)</th></tr>" ); 
        for ( int j = 1; j <= 20; j++ ) 
        { 
            double x = j / 10.0; 
            print.println( "<tr><td>" + x + "</td><td>" + Math.log( x ) 
                + "</td></tr>" ); 
        } 
        print.println( "</table>" ); 
        print.println( "</body>" ); 
        print.println( "</html>" ); 
    } 

    
}