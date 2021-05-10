public class GenericMethods implements GenericMethodsInterface{
    
    public <AnyType extends Comparable<AnyType>>
        int binarySearch(AnyType[] a, AnyType x){
            int low = 0;
            int high = a.length - 1;
        
            return binarySearchHelper(a, x, low, high);
            
           
       
        }
    public <AnyType extends Comparable<AnyType>> 
        int binarySearchHelper(AnyType[] a, AnyType x, int low, int high){
            
             
            if(low == high + 1 || high == low -1){
                return -1; 
                
            }
        
            int mid = (low+high)/2;
            int compareResults = a[mid].compareTo(x);

            if(compareResults < 0){
                low = mid +1;
                return binarySearchHelper(a, x, low, high);
            }else if(compareResults > 0){
                high = mid -1;
                return binarySearchHelper(a, x, low, high);
            }
            return mid;
                
           

        }
	
    public <AnyType extends Comparable<AnyType>> 
        int linearSearch(AnyType[] a, AnyType x){
           for(int i =0; i< a.length; i++){
                int compareResults = a[i].compareTo(x);
                if(compareResults == 0){
                    return i;
                    
                }
            }
        
        return -1;
        
        }
    
}