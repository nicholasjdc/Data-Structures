public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
   private MyStack<T> s1 = new MyStack<T>();
    private MyStack<T> s2 = new MyStack<T>();
    private int theSize = 0;
    
    public void enqueue(T x){
        s1.push(x);
        theSize +=1;
    }
	public T dequeue(){
        if(isEmpty()){
            return null;
        }else{
            for(int i = 0; i < size(); i++){
                s2.push(s1.pop());
            }
            T dequeued = s2.pop();
            theSize -=1;
            
            for(int i = 0; i < size(); i++){
                s1.push(s2.pop());
            }
            
            return dequeued;
        }
    }
	public int size(){
        return theSize;
        
    }
	public boolean isEmpty(){
        return size() == 0;
    }
    
    
}