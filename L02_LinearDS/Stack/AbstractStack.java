package fgw.L02_LinearDS.Stack;


/**
 * This is an interface for an abstract stack.
 * It provides methods for pushing an element onto the stack,
 * popping the top element from the stack, peeking at the top element,
 * getting the size of the stack, and checking if the stack is empty.
 * It also extends the Iterable interface to provide iteration over the elements of the stack.
 */
public interface AbstractStack<E> extends Iterable<E> {
    void push( E element ); // Pushes an element onto the stack
    E pop( ); // Pops the top element from the stack
    E peek( ); // Peeks at the top element
    int size( ); // Gets the size of the stack
    boolean isEmpty( ); // Checks if the stack is empty
}
