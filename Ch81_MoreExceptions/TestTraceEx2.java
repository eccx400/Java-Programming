// Testing class TestTrace and three classes CallEgA, CallEgB, and CallEgC. 
class CallEgA
{
    public void method()
    {
        CallEgB eg = new CallEgB();
        eg.method();
    }
}

class CallEgB
{
    public void method()
    {
        CallEgC eg = new CallEgC();
        eg.method();
    }
}

//divide by 0
class CallEgC
{
    public void method()
    {
        int dvz = 1 / 0;
        System.out.println( dvz );
    }
}

public class TestTraceEx2
{

    public static void main ( String[] args )
    {
        CallEgA eg = new CallEgA();   // use default constructor
        try
        {
            eg.method();
        }
        catch ( ArithmeticException oops )
        {
            oops.printStackTrace();
        }
    }
}

