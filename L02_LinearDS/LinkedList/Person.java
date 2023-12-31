package fgw.L02_LinearDS.LinkedList;

class Person {
    private String name;
    public Person( String name ) {
        this.name = name;
    }
    @Override
    public String toString( ) {
        return name;
    }
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Person ) ) return false;
        Person person = (Person) o;
        return name == person.name;
    }
}
