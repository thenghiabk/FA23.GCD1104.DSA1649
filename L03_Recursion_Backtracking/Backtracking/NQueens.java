package fgw.L03_Recursion_Backtracking.Backtracking;

import java.util.HashMap;

public class NQueens {
    public static final int NUMBER = 4;
    public boolean[] col, leftDiagonal, rightDiagonal;
    public boolean[][] board;
    public int count;
    NQueens( ) {
        col = new boolean[ NUMBER ];
        leftDiagonal = new boolean[ 2 * NUMBER - 1 ];
        rightDiagonal = new boolean[ 2 * NUMBER - 1 ];
        board = new boolean[ NUMBER ][ NUMBER ];
        count = 0;
        init( );
    }
    private void init( ) {
        for ( int i = 0; i < col.length; i++ ) {
            col[ i ] = true;
        }
        for ( int j = 0; j < leftDiagonal.length; j++ ) {
            leftDiagonal[ j ] = true;
            rightDiagonal[ j ] = true;
        }
    }
    public void printSolution( ) {
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board.length; j++ ) {
                if ( !board[ i ][ j ] ) {
                    System.out.print( '-' );
                } else {
                    System.out.print( '*' );
                }
            }
            System.out.println( );
        }
        System.out.println( );
    }
    public void test( int i ) {
        for ( int j = 0; j < board.length; j++ ) {
            if ( isFree( i, j ) ) {
                board[ i ][ j ] = true;
                col[ j ] = leftDiagonal[ j - i + board.length - 1 ] = rightDiagonal[ i + j ] = false;
                if ( i == board.length - 1 ) {
                    printSolution( );
                    count++;
                } else {
                    test( i + 1 );
                }
                board[ i ][ j ] = false;
                col[ j ] = leftDiagonal[ j - i + board.length - 1 ] = rightDiagonal[ i + j ] = true;

            }
        }
    }

    private boolean isFree( int i, int j ) {
        return col[ j ] && leftDiagonal[ j - i + board.length - 1 ] && rightDiagonal[ i + j ];
    }

}

class NQueensTest {
    public static void main( String[] args ) {
        NQueens myQueens = new NQueens( );
        myQueens.test( 0 );
        System.out.println( "There is " + myQueens.count + " solutions" );

    }
}
