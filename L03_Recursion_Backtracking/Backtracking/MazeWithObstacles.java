package fgw.L03_Recursion_Backtracking.Backtracking;

public class MazeWithObstacles {
    public static void main( String[] args ) {

        // boolean[][] board = {
        //         { true, true, true },
        //         { true, false, true },
        //         { true, true, true }
        // };

        boolean[][] board = {
                { true, true, true, true },
                { true, false, true, true },
                { true, true, true, true }
        };

        pathRestrictions( "", board, 0, 0 );

    }
    private static void pathRestrictions( String p, boolean[][] maze, int r, int c ) {
        // reach the target
        if ( r == maze.length - 1 && c == maze[ 0 ].length - 1 ) {
            System.out.println( p );
            return;
        }

        // return if it's restricted
        if ( maze[ r ][ c ] == false ) {
            return;
        }

        // go down
        if ( r < maze.length - 1 ) {
            pathRestrictions( p + 'D', maze, r + 1, c );
        }

        // go right
        if ( c < maze[ 0 ].length - 1 ) {
            pathRestrictions( p + 'R', maze, r, c + 1 );
        }

    }
}