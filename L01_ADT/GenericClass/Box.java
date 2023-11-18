package fgw.L01_ADT.GenericClass;

public class Box<T> {
    private T content;
    public void setContent( T content ) {
        this.content = content;
    }
    public T getContent( ) {
        return content;
    }
}

class BoxTest {
    public static void main( String[] args ) {
        Box<Integer> integerBox = new Box<>( );
        integerBox.setContent( 42 );
        int content = integerBox.getContent( ); // content will be 42
        System.out.println( content );

        Box<String> stringBox = new Box<>( );
        stringBox.setContent( "Hello" );
        String anotherContent = stringBox.getContent( ); // content will be "Hello"
        System.out.println( anotherContent );

    }
}
