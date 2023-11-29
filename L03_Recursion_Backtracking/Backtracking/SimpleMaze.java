package fgw.L03_Recursion_Backtracking.Backtracking;

import java.util.ArrayList;

public class SimpleMaze {
    public static void main( String[] args ) {

        // board size: 3 x 3
        // player is able to go down (D) or right (R) only

        /*
               3   2   1
             -------------
          3  | S |   |   |
             -------------
          2  |   |   |   |
             -------------
          1  |   |   | T |
             -------------

             S: Start
             T: Target
         */

        // Find all possible paths
        int numOfPossiblePaths = count( 3, 3 );
        System.out.println( "Possible paths: " + numOfPossiblePaths );

        // Print all paths
        path( "", 3, 3 );

        // Print a vector of paths
        System.out.println( pathVector( "", 3, 3 ) );
    }

    static int count( int r, int c ) {
        if ( r == 1 || c == 1 ) { // base condition
            return 1;
        }

        int left = count( r - 1, c );
        int right = count( r, c - 1 );

        return left + right;
    }

    static void path( String p, int r, int c ) {
        // check the target
        if ( r == 1 && c == 1 ) { // base condition
            System.out.println( p );
            return;
        }

        // go down
        if ( r > 1 ) {
            path( p + 'D', r - 1, c );
        }

        // go right
        if ( c > 1 ) {
            path( p + 'R', r, c - 1 );
        }
    }

    static ArrayList<String> pathVector( String p, int r, int c ) {
        ArrayList<String> list = new ArrayList<>( );

        // check the target
        if ( r == 1 && c == 1 ) { // base condition
            list.add( p );
            return list;
        }

        // go down
        if ( r > 1 ) {
            list.addAll( pathVector( p + 'D', r - 1, c ) );
        }

        // go right
        if ( c > 1 ) {
            list.addAll( pathVector( p + 'R', r, c - 1 ) );
        }

        return list;
    }
}
