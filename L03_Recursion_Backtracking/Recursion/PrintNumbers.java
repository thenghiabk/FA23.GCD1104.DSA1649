package fgw.L03_Recursion_Backtracking.Recursion;

public class PrintNumbers {
    public static void main( String[] args ) {
        // printChainOfNum( 5 ); // should print 54321
        printReversedChainOfNums( 5 ); // should print 12345
    }

    static void printChainOfNums( int n ) {
        if ( n == 0 ) {
            return;
        }
        System.out.println( n );
        printChainOfNums( n - 1 );
    }
    static void printReversedChainOfNums( int n ) {
        if ( n == 0 ) {
            return;
        }
        printReversedChainOfNums( n - 1 );
        System.out.print( n );
    }
}
