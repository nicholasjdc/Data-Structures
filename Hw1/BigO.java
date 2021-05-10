import java.util.Scanner;
public class BigO implements BigOInterface{

    public void test(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long startTime = System.nanoTime();
        constant(n);
        long endTime = System.nanoTime();
        System.out.println("cons" + (endTime - startTime));
        startTime = System.nanoTime();
        cubic(n);
        endTime = System.nanoTime();
        System.out.println("cubic: " + (endTime - startTime));
        startTime = System.nanoTime();
        exp(n);
        endTime = System.nanoTime();
        System.out.println("exp: " + (endTime - startTime));
        
        
        
        
    }
    public void cubic(int n){ 
        int m = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    m++;
                    
            
                }
            
            
            }
            
        }
        
    }
    private int qre = 0;
	public void exp(int n){
        if(n == 0 || n==1){
            qre++;
            
            
        }else{
        exp(n-1);
        exp(n-2);
        }
        
    }
	public void constant(int n){
        System.out.println("Hello Fabulous Reader");
        
    }
}