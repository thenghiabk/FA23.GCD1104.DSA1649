package fgw.L03_Recursion_Backtracking.Recursion;

public class ArraySum {
    public static void main( String[] args ) {
        int[] array = { 1, 2, 3, 4, 5 };
        // int[] array = { -1, 0, 1 };
        System.out.println( sum( array, 0 ) ); // starts from index 0
    }
    static int sum( int[] array, int index ) {
        if ( index == array.length - 1 ) {
            return array[ index ];
        }
        return array[ index ] + sum( array, index + 1 );
    }
}
