package fgw.L03_Recursion_Backtracking.Backtracking;

import java.util.Arrays;

public class MazeWithAllPaths {
    public static void main( String[] args ) {

        // boolean[][] board = {
        //         { true, true, true },
        //         { true, true, true },
        //         { true, true, true }
        // };

        boolean[][] board = {
                { true, true, true, true },
                { true, true, true, true },
                { true, true, true, true }
        };


        // allPaths( "", board, 0, 0 );

        int[][] path = new int[ board.length ][ board[ 0 ].length ];
        allPathsPrinted( "", board, 0, 0, path, 1 );

    }

    private static void allPaths( String p, boolean[][] maze, int r, int c ) {

        // reach the target
        if ( r == maze.length - 1 && c == maze[ 0 ].length - 1 ) {
            System.out.println( p );
            return;
        }

        // return if it's restricted
        if ( maze[ r ][ c ] == false ) {
            return;
        }

        // backtracking
        // mark the cell as visited
        maze[ r ][ c ] = false;

        // go down
        if ( r < maze.length - 1 ) {
            allPaths( p + 'D', maze, r + 1, c );
        }

        // go right
        if ( c < maze[ 0 ].length - 1 ) {
            allPaths( p + 'R', maze, r, c + 1 );
        }

        // go up
        if ( r > 0 ) {
            allPaths( p + 'U', maze, r - 1, c );
        }

        // go left
        if ( c > 0 ) {
            allPaths( p + 'L', maze, r, c - 1 );
        }

        // where the function will be over
        // before the function gets removed, also remove the changes
        // that were made by the function
        maze[ r ][ c ] = true;
    }

    private static void allPathsPrinted( String p, boolean[][] maze, int r, int c, int[][] path, int step ) {

        // reach the target
        if ( r == maze.length - 1 && c == maze[ 0 ].length - 1 ) {
            path[ r ][ c ] = step;

            for ( int[] arr : path ) {
                System.out.println( Arrays.toString( arr ) );
            }
            System.out.println( p );
            System.out.println( );
            return;
        }

        // return if it's restricted
        if ( maze[ r ][ c ] == false ) {
            return;
        }

        // backtracking
        // mark the cell as visited
        maze[ r ][ c ] = false;
        path[ r ][ c ] = step;

        // go down
        if ( r < maze.length - 1 ) {
            allPathsPrinted( p + 'D', maze, r + 1, c, path, step + 1 );
        }

        // go right
        if ( c < maze[ 0 ].length - 1 ) {
            allPathsPrinted( p + 'R', maze, r, c + 1, path, step + 1 );
        }

        // go up
        if ( r > 0 ) {
            allPathsPrinted( p + 'U', maze, r - 1, c, path, step + 1 );
        }

        // go left
        if ( c > 0 ) {
            allPathsPrinted( p + 'L', maze, r, c - 1, path, step + 1 );
        }

        // where the function will be over
        // before the function gets removed, also remove the changes
        // that were made by the function
        maze[ r ][ c ] = true;
        path[ r ][ c ] = 0;
    }


}