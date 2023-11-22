package fgw.L02_LinearDS.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private int size;
    public Queue( ) {
        head = null;
    }
    @Override
    public void offer( E data ) {
        Node<E> newNode = new Node<>( data );
        if ( isEmpty( ) ) {
            head = newNode;
        } else {
            Node<E> current = head;
            while ( current.next != null ) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    @Override
    public E poll( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        E data = head.element;
        if ( size == 1 ) {
            head = null;
        } else {
            Node<E> next = head.next;
            head.next = null;
            head = next;
        }
        size--;
        return data;
    }
    @Override
    public E peek( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return head.element;
    }
    @Override
    public int size( ) {
        return size;
    }
    @Override
    public boolean isEmpty( ) {
        return head == null; // or size == 0
    }
    @Override
    public Iterator<E> iterator( ) {
        return new Iterator<>( ) {
            private Node<E> current = head;
            public boolean hasNext( ) {
                return current != null;
            }
            public E next( ) {
                if ( !hasNext( ) ) {
                    throw new NoSuchElementException( );
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
    // toString method to represent the queue as a string
    @Override
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<E> current = head;

        while ( current != null ) {
            result.append( current.element );
            if ( current.next != null ) {
                result.append( ", " );
            }
            current = current.next;
        }
        result.append( "]" );
        return result.toString( );
    }
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node( E element ) {
            this.element = element;
        }
    }
}

class QueueTest {
    public static void main( String[] args ) {
        QueueEnhanced<Integer> queueEnhanced = new QueueEnhanced<>( );

        queueEnhanced.offer( 10 );
        queueEnhanced.offer( 20 );
        queueEnhanced.offer( 30 );

        System.out.println( "Queue: " + queueEnhanced ); // Should print [10, 20, 30]

        System.out.println( "Poll: " + queueEnhanced.poll( ) ); // Should print 10

        System.out.println( "Queue after poll: " + queueEnhanced ); // Should print [20, 30]

        queueEnhanced.offer( 40 );

        System.out.println( "Queue after offer: " + queueEnhanced ); // Should print [20, 30, 40]

        System.out.println( "Peek: " + queueEnhanced.peek( ) ); // Should print 20

        System.out.println( "Size: " + queueEnhanced.size( ) ); // Should print 3

        System.out.println( "Is Empty: " + queueEnhanced.isEmpty( ) ); // Should print false

        System.out.println( queueEnhanced ); // prints out current queue

        System.out.println( "Poll: " + queueEnhanced.poll( ) );
        System.out.println( "Poll: " + queueEnhanced.poll( ) );
        System.out.println( "Poll: " + queueEnhanced.poll( ) );
        // System.out.println( "Poll: " + queue.poll( ) ); // uncommenting this line can cause error

        QueueEnhanced<String> stringQueueEnhanced = new QueueEnhanced<>( );

        stringQueueEnhanced.offer( "Hello" );
        stringQueueEnhanced.offer( "World" );

        System.out.println( stringQueueEnhanced.poll( ) );  // Should print "Hello"
        System.out.println( stringQueueEnhanced.peek( ) );  // Should print "World"
    }
}
