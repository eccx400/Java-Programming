import java.util.Scanner;

/**
 * Chapter 46 Programming Exercises 1-5
 * 
 * @author Eric Cheng
 * @version 1/25/2014
 * 
 * @author Period - 6
 * @author Assignment - Ch46_Arrays
 * 
 * @author Sources - Eric Cheng
 */
public class Ch46ArraysEx1_5
{
    private Scanner scan;

    public Ch46ArraysEx1_5()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Complete the assignment statement so that it computes the sum of
     * all the numbers in the array.
     */
    public void ex1_ArraySum()
    {
        int[] val = { 0, 1, 2, 3 };

        int sum = val [0] + val [1] + val [2]+ val [3];

        System.out.println( "Sum of all numbers = " + sum );
    }

    /**
     * Complete the method so that a new array twice is constructed.
     * Now copy values from val to twice, but make the values in twice
     * double what they are in val.
     */
    public void ex2_TwoArrays()
    {
        int[] val = { 13, -4, 82, 17 };

        System.out.println( "Original Array: " +
            val[0] + " " + val[1] + " " + val[2] + " " + val[3] );

        //Construct an array object for twice.
        int[] twice = new int [4];

        //Put values in twice that are twice the corresponding values in val.
        twice[0] = 2 * val[0];
        twice[1] = 2 * val[1];
        twice[2] = 2 * val[2];
        twice[3] = 2 * val[3];

        System.out.println( "New Array: " +
            twice[0] + " " + twice[1] + " " + twice[2] + " " + twice[3] );
    }

    /**
     * Complete the method with four assignment statements so that each
     * cell of sum contains the sum of the corresponding cells in valA
     * and valb. Ie., add cell zero of valA to cell zero of valB and put
     * the result in cell zero of sum, and so on.
     */
    public void ex3_ThreeArrays()
    {
        int[] valA = {  13, -22,  82,  17 };
        int[] valB = { -12,  24, -79, -13 };
        int[] sum =  {   0,   0,   0,   0 };

        // Add values from corresponding cells of valA and valB
        // and put the result in the corresponding cell of sum.
        sum[0] = valA[0] + valB[0];
        sum[1] = valA[1] + valB[1];
        sum[2] = valA[2] + valB[2];
        sum[3] = valA[3] + valB[3];
        
        System.out.println( "sum: " +
            sum[0] + " " + sum[1] + " " + sum[2] + " " + sum[3] );
    }

    /**
     * Complete the method with four assignment statements that put
     * values into valB so that the sum of corresponding cells in valA
     * and valB is 25.
     */
    public void ex4_SameSum()
    {
        int[] valA = { 13, -22, 82, 17 };
        int[] valB = {  0,  0,   0,  0 };
        
        // Put values into valB so that the sum of the values
        // in corresponding cells of valA and valB is 25.
        valB[0] = 25 - valA[0];
        valB[1] = 25 - valA[1];
        valB[2] = 25 - valA[2];
        valB[3] = 25 - valA[3];
        int sum[] = new int[4];
        sum[0] = valA[0] + valB[0];
        sum[1] = valA[1] + valB[1];
        sum[2] = valA[2] + valB[2];
        sum[3] = valA[3] + valB[3];

        System.out.println( "valA: " +
            valA[0] + " " + valA[1] + " " + valA[2] + " " + valA[3] );
     
        System.out.println( "valB: " +
            valB[0] + " " + valB[1] + " " + valB[2] + " " + valB[3] );

        System.out.println( "sum:  " +
            (valA[0]+valB[0]) + " " + (valA[1]+valB[1]) + " " +
            (valA[2]+valB[2]) + " " + (valA[3]+valB[3]) );
    }

    /**
     * Complete the method so that the numbers in the array appear in
     * reversed order. You will need to use the variable
     * <code>temp</code> to do this.
     */
    public void ex5_ReverseOrder()
    {
        int[] val = { 0, 1, 3, 5 };
        int temp;
     
        System.out.println( "Original Array: " +
            val[0] + " " + val[1] + " " + val[2] + " " + val[3] );
     
        // reverse the order of the numbers in the array
        temp = val[0];
        val[0]= val[3];
        val[3]= temp;
        temp = val[1];
        val[1]= val[2];
        val[2]= temp;
      
        System.out.println( "Reversed Array: " +
            val[0] + " " + val[1] + " " + val[2] + " " + val[3] );
    }

    /**
     * Testing method: instantiates a Ch46ArraysEx1_5 object and then
     * invokes each method
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;
        String separator = "";

        Ch46ArraysEx1_5 exercise = new Ch46ArraysEx1_5();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) Array Sum" );
            System.out.println( "   (2) Two Arrays" );
            System.out.println( "   (3) Three Arrays" );
            System.out.println( "   (4) Same Sum" );
            System.out.println( "   (5) Reverse Order" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        exercise.ex1_ArraySum();
                        break;
                    case '2':
                        exercise.ex2_TwoArrays();
                        break;
                    case '3':
                        exercise.ex3_ThreeArrays();
                        break;
                    case '4':
                        exercise.ex4_SameSum();
                        break;
                    case '5':
                        exercise.ex5_ReverseOrder();
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                            done = true;
                        else
                            System.out.print( "Invalid Choice" );
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
