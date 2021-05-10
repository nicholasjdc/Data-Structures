public class MyStack<T> implements MyStackInterface<T> {
      
    private T[] stuff;
    private int theSize;
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyStack(){
        theSize = 0;
        changeCapacity(DEFAULT_CAPACITY);
        
    }
   //Code borrowed from MyArrayList
     @SuppressWarnings("unchecked")
    public void changeCapacity(int newCapacity ){
        if( newCapacity < theSize )
            return;

        T [ ] old = stuff;
        stuff = (T []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            stuff[ i ] = old[ i ];
    }
    public void push(T x){
        if(size() > stuff.length -1){
            changeCapacity(2 * stuff.length);
        }
        stuff[size()] = x;
        theSize += 1;
    }
	public T pop(){
        if(isEmpty()){
            return null;
            
        }
        T old = stuff[size() - 1];
        theSize -=1;
        
        return old;
    }
	public T peek(){
        if(isEmpty()){
            return null;
            
        }
        return stuff[size() - 1];
    }
	public boolean isEmpty(){
        return theSize==0;
    }
	public int size(){
        return theSize;
    }
    public String toString(){

        return "" + theSize + stuff;
    }
    
    
}