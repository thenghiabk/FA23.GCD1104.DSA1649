package fgw.L01_ADT.BagADT;

public interface Bag {
    boolean add( Object item ); // add item to the Bag
    boolean remove( Object item ); // remove one occurrence of item (if any) from the Bag
    boolean contains( Object item ); // check if item is in the Bag
    int numItems( ); // get the number of items in the Bag
    Object grab( ); // get an item at random, without removing it
    Object[] toArray( ); // get an array containing the current contents of the bag
}
