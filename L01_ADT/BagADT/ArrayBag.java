package fgw.L01_ADT.BagADT;

import java.util.Arrays;

public class ArrayBag implements Bag {
    private Object[] items;
    private int size;

    public ArrayBag( ) {
        items = new Object[ 4 ];
    }
    @Override
    public boolean add( Object item ) {
        items[ size ] = item;
        size++;
        return true;
    }
    @Override
    public boolean remove( Object item ) {
        for ( int i = 0; i < size; i++ ) {
            if ( items[ i ].equals( item ) ) {
                // shift elements left to remove item
                for ( int j = i; j < size - 1; j++ ) {
                    items[ j ] = items[ j + 1 ];
                }
                size--;
                items[ size ] = null;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean contains( Object item ) {
        for ( int i = 0; i < size; i++ ) {
            if ( items[ i ].equals( item ) ) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int numItems( ) {
        return size;
    }
    @Override
    public Object grab( ) {
        if ( size == 0 ) return null;
        int index = (int) ( Math.random( ) * size ); // random 0 -> 3
        return items[ index ];
    }
    @Override
    public Object[] toArray( ) {
        Object[] array = new Object[ size ];
        for ( int i = 0; i < size; i++ ) {
            array[ i ] = items[ i ];
        }
        return array;
    }
    @Override
    public String toString( ) {
        return Arrays.toString( items );
    }
}

class ArrayBagTest {
    public static void main( String[] args ) {
        ArrayBag bag = new ArrayBag( );

        // Add some items
        bag.add( "Apple" );
        bag.add( "Orange" );
        bag.add( "Banana" );
        bag.add( "Apple" );

        // Check contains
        System.out.println( "Bag contains Apple: " + bag.contains( "Apple" ) );

        // Remove an item
        bag.remove( "Apple" );
        System.out.println( "Bag contains Apple: " + bag.contains( "Apple" ) );

        // Number of items
        System.out.println( "Number of items in bag: " + bag.numItems( ) );

        // Grab a random item
        Object item = bag.grab( );
        System.out.println( "Grabbed item: " + item );

        // Convert to array
        Object[] arr = bag.toArray( );
        System.out.println( "Bag as Array: " + Arrays.toString( arr ) );

        System.out.println( bag );
    }
}
