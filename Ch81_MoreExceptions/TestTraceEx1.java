class CallEg
{
    //methodA() calls methodB() calls methodC() inside a try{} block
    public void methodA() throws ArithmeticException
    {
        try
        {
            methodB();
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw new ArithmeticException( "Math Error: Divide by 0" );
        }
    }

    public void methodB() throws ArithmeticException
    {
        try
        {
            methodC();
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw new ArithmeticException( "Math Error: Divide by 0" );
        }
    }

    // Divide by 0
    public void methodC() throws ArithmeticException
    {
        try
        {
            int dvz = 1 / 0;
            System.out.println( dvz );
        }
        catch ( ArithmeticException ex )
        {
            ex.printStackTrace();
            throw new ArithmeticException( "Math Error: Divide by 0" );
        }
    }
}

public class TestTraceEx1
{
    public static void main ( String[] args )
    {
        CallEg eg = new CallEg();   // use default constructor
        try
        {
            eg.methodA();
        }
        catch ( ArithmeticException oops )
        {
            oops.printStackTrace();
        }
    }
}
