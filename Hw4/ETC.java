import java.util.*;
public class ETC{
	
	public static void main(String[] args){
		KBestCounter kbc = new KBestCounter(5);
        kbc.count(5);
        kbc.count(2);
        kbc.count(10);
        kbc.count(13);
        kbc.count(8);
        kbc.count(25);
        List<Integer> kbcList = kbc.kbest();
        System.out.println(kbc.kbest());
        for(Integer n: kbcList)
            System.out.println(n);
    }
        
}