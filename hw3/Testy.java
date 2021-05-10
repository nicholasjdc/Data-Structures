public class Testy{
    public static void main(String[] args){
        BetterBST<Integer> numBST = new BetterBST<>();
     
        numBST.insert(30);
        numBST.insert(10);
        numBST.insert(11);
        

        numBST.mirror().prettyPrint();
        
    }
    
    
}