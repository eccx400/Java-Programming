/**
    Chapter 9 - Variables and Assignment Statements
    Programming Exercises 1-3

    @author  Eric Cheng
    @version 10/18/2013

    @author  Period - 6
    @author  Assignment - Ch09Ex1_3

    @author  Sources - Eric Cheng
 */
public class Ch09Ex1_3
{
    public Ch09Ex1_3()
    { }

    /**
        Payroll method
     */
    public void payroll()
    {
        long hoursWorked = 40;
        double payRate = 10.0, taxRate = 0.10;
        System.out.println( "Hours Worked: " + hoursWorked );
        System.out.println( "pay Amount  : " + ( hoursWorked * payRate ) );
        System.out.println( "tax Amount  : " + ( hoursWorked * payRate * taxRate ) );
    }

    /**
        Computes value of the quadratic
        
           3*X^2 -8*X + 4
        
        for several values of X. The program uses a double precision variable X,
        assigns a value to it, and writes statement that computes a value for
        the quadratic and stores the result in another double precision variable.
        Finally the result is written out in the following form:
        
            At X = 4.0 the value is 20.0
     */
    public void valueOfAQuadratic()
    {
        double X = 4; 
        double value; 
        value = (3 * X * X - 8 * X + 4); 
        System.out.println("At X = " + X + " the value is " + value); 
    }

    /**
        Modify of the ValueOfAQuadratic() method so that one run of the method
        will evaluate and write out the value of the quadratic for three
        different values of X: 0.0, 2.0, and 4.0 (or any three chosen values.)
        
        The method is written using only two variables, called x and value.
     */
    public void reassign()
    {
        double X; 
        X = 0; 
        double value; 
        value = (3 * X * X - 8 * X + 4); 
        System.out.println("At X = " + X + " the value is " + value); 
        X = 2; 
        value = (3 * X * X - 8 * X + 4); 
        System.out.println("At X = " + X + " the value is " + value); 
        X = 4; 
        value = (3 * X * X - 8 * X + 4); 
        System.out.println("At X = " + X + " the value is " + value); 
    }

    /**
        Testing method: instantiates a Ch09Ex1_3 object and
        then invokes each method
        
        @param  args  command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Ch09Ex1_3 exercise = new Ch09Ex1_3();

        exercise.payroll();
        System.out.println();

        exercise.valueOfAQuadratic();
        System.out.println();

        exercise.reassign();
        System.out.println();
    }
}
