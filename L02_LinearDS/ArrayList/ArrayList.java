package fgw.L02_LinearDS.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

import java.util.Scanner;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private E[] elements;
    private int size;
    public ArrayList( ) {

        elements = (E[]) new Object[ DEFAULT_CAPACITY ];
    }
    @Override
    public boolean add( E element ) {
        if ( size == elements.length ) {
            elements = Arrays.copyOf( elements, elements.length * 2 );
            ;
        }
        elements[ size++ ] = element;
        return true;
    }
    @Override
    public boolean add( int index, E element ) {
        if ( index < 0 || index >= size ) throw new IndexOutOfBoundsException( "Index out of bound:"
                + index + " out of " + size );
        if ( size == elements.length ) {
            elements = Arrays.copyOf( elements, elements.length * 2 );
            ;
        }
        // shifts all elements to the right to accommodate the new element.
        for ( int i = size; i >= index + 1; i-- ) {
            elements[ i ] = elements[ i - 1 ];
        }
        elements[ index ] = element;
        size++;
        return true;
    }
    public E get( int index ) {
        if ( index < 0 || index >= size ) throw new IndexOutOfBoundsException( "Index out of bound:"
                + index + " out of " + size );
        return getElement( index );
    }
    private E getElement( int index ) {
        return (E) elements[ index ];
    }
    public E set( int index, E element ) {
        if ( index < 0 || index >= size ) throw new IndexOutOfBoundsException( "Index out of bound:"
                + index + " out of " + size );
        E oldElement = getElement( index );
        elements[ index ] = element;
        return oldElement;
    }
    public E remove( int index ) {
        if ( index < 0 || index >= size ) throw new IndexOutOfBoundsException( "Index out of bound:"
                + index + " out of " + size );
        E removedElement = getElement( index );

        for ( int i = index; i < size - 1; i++ ) {
            elements[ i ] = elements[ i + 1 ];
        }
        size--;
        elements[ size ] = null;

        if ( size < elements.length / 3 ) {
            elements = Arrays.copyOf( elements, elements.length / 2 );
        }

        return removedElement;
    }
    @Override
    public int size( ) {
        return size;
    }
    @Override
    public int indexOf( E element ) {
        for ( int i = 0; i < size; i++ ) {
            if ( elements[ i ] != null && elements[ i ].equals( element ) ) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean contains( E element ) {
        return indexOf( element ) != -1;
    }
    @Override
    public boolean isEmpty( ) {
        return size == 0;
    }

    //  It returns an iterator that allows iterating over the elements in the ArrayList.
    //  The iterator keeps track of the current index and provides methods to check
    //  if there are more elements ( hasNext() ) and to retrieve the next element ( next() )
    @Override
    public Iterator<E> iterator( ) {
        return new Iterator<E>( ) {
            private int index = 0;
            @Override
            public boolean hasNext( ) {
                return index < size;
            }

            @Override
            public E next( ) {
                E element = getElement( index );
                index++;
                return element;
            }
        };
    }
    @Override
    public String toString( ) {
        return Arrays.toString( elements );
    }
}

class Student {
    private String name;
    public Student( String name ) {
        this.name = name;
    }
    public String getName( ) {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    @Override
    public String toString( ) {
        return name;
    }
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Student ) ) return false;
        Student student = (Student) o;
        return name == student.name;
    }
}

class ArrayListTest {
    public static void main( String[] args ) {
        /**
         * Integer ArrayList Demo
         * */
        ArrayList<Integer> myIntArrayList = new ArrayList<>( );
        myIntArrayList.add( 10 );
        myIntArrayList.add( 20 );
        myIntArrayList.add( 30 );
        myIntArrayList.add( 40 );
        System.out.println( myIntArrayList );

        myIntArrayList.add( 2, 50 );
        System.out.println( myIntArrayList );

        myIntArrayList.set( 4, 10 );
        System.out.println( myIntArrayList );

        System.out.println( "Index of 50 is " + myIntArrayList.indexOf( 50 ) );

        System.out.println( "Delete element " + myIntArrayList.remove( 1 ) + " out of Arraylist" );
        System.out.println( myIntArrayList );
        System.out.println( "Delete element " + myIntArrayList.remove( 1 ) + " out of Arraylist" );
        System.out.println( myIntArrayList );
        System.out.println( "Delete element " + myIntArrayList.remove( 1 ) + " out of Arraylist" );
        System.out.println( myIntArrayList );
        System.out.println( "Delete element " + myIntArrayList.remove( 1 ) + " out of Arraylist" );
        System.out.println( myIntArrayList );

        /**
         * String ArrayList Demo
         * */
        ArrayList<String> famousPersons = new ArrayList<>( );
        famousPersons.add( "Elon Musk" );
        famousPersons.add( "Cristiano Ronaldo" );
        famousPersons.add( "Lionel Messi" );
        famousPersons.add( "Mark Zuckerberg" );
        famousPersons.add( "Dwayne Johnson" );
        famousPersons.add( "Bill Gates" );

        System.out.println( famousPersons );
        System.out.println( "Index of `Mark Zuckerberg` " + famousPersons.indexOf( "Mark Zuckerberg" ) );

        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter the name of person you want to search:" );
        String input = scanner.nextLine( );
        System.out.println( "Index of `" + input + "` is " + famousPersons.indexOf( input ) );

        /**
         * Object ArrayList Demo
         * */
        ArrayList<Student> studentList = new ArrayList<>( );
        studentList.add( new Student( "John" ) );
        studentList.add( new Student( "David" ) );
        studentList.add( new Student( "Lucy" ) );
        studentList.add( new Student( "Ben" ) );
        System.out.println( studentList );
        System.out.println( "Index of `Ben` is " + studentList.indexOf( new Student( "Ben" ) ) );

        Iterator<Student> myIntIterator = studentList.iterator( );
        while ( myIntIterator.hasNext( ) ) {
            System.out.println( myIntIterator.next( ) );
        }
    }
}
