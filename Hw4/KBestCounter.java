import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
    private PriorityQueue<T> pq;
    private int listLength;
    
    public KBestCounter(int k){
        listLength = k;
        pq = new PriorityQueue<>();
    }
    
    public void count(T x){
         if(pq.size() < listLength){
                pq.add(x);
         }else if(pq.peek() != null && pq.peek().compareTo(x) < 0){
            pq.poll();
            pq.add(x);
        }else{

        }

    }
 
	public List<T> kbest(){
        PriorityQueue<T> tempQueue = new PriorityQueue<>(pq);
        LinkedList<T> kbest = new LinkedList<>();  
        for(int i = 0; i < listLength; i++){
            kbest.add(tempQueue.poll());
        }
        return kbest;
        
    }
}