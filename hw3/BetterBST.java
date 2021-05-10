import java.util.LinkedList;
public class BetterBST<T extends Comparable <? super T>> extends BinarySearchTree<T>{
   
    public int height(){
    // - return the height of the BST  
        return height(root);
        
    }
    
    private int height(BinaryNode<T> root){
        //int h=0;
        if(root.left ==null && root.right == null){
           return 0;
        }
        if(root.left == null){
           // h++;
           return 1 + height(root.right);


        }if(root.right == null){
          //  h++;
            return 1 + height(root.left);


        }else{
           // h++;
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh > rh){
                return 1 + lh;
            }else{
                return 1 + rh;
            }
                
            
            
        }
    
        
    }
    public T imbalance(){
        return imbalance(root);
        /*
         - check whether the tree is balanced.
         A balanced tree is one where every node’s 
         left and right subtrees differ in height 
         by no more than 1. Return the value at 
         first node you find which has a height imbalance 
         greater than 1 between its subtrees, or null if no 
         such node exists (i.e. the tree is balanced). 
         In class, we discussed AVL trees, which enforce 
         this balance condition.
        */
    }
    
    private T imbalance(BinaryNode<T> root){
        int hDiff;
        
        if(root.left == null && root.right == null){
             return null;  
            
        }else if(root.right == null){
            hDiff = height(root.left) + 1;
        }else if(root.left == null){
            hDiff = height(root.right) + 1;
        }else{
            hDiff = Math.abs(height(root.left) - height(root.right));
        }
        
        if(hDiff > 1){
            
            return root.data;
       
        }else{
            //if(root.left != null && imbalance(root.left) != null){
           //     return imbalance(root.left);
                
           // }else{
           //     return imbalance(root.right);
           // }
            
            
            return (imbalance(root.left) != null)? imbalance(root.left): imbalance(root.right);
            
        }
            
        
          
    }
    public T smallestGreaterThan(T t){

      return smallestGreaterThan(root, t);
        /*
         - given some generic comparable 
         value t, find the smallest value 
         in the BST that is larger than t. 
         For example, if a binary search tree 
         contains the values 1, 3, and 5, 
         and the function is called with t = 2, 
         it should return 3.
        */
        
    }
    
    private T smallestGreaterThan(BinaryNode<T> root, T t){

        if(t.compareTo(root.data) < 0){

            if(root.left == null){
                 return root.data;   
            }else{
                T sgtRecursive = smallestGreaterThan(root.left, t);
                return (sgtRecursive != null)? sgtRecursive: root.data;
            }
        }else if(root.right != null){
            return smallestGreaterThan(root.right, t);
        }else{
            return null;
        }
    }
    public BinarySearchTree<T> mirror(){
        BetterBST<T> mirrorTree = new BetterBST<>();
        mirrorTree.root = rootReverse(root);
         return mirrorTree;

        
    }

    private BinaryNode<T> rootReverse(BinaryNode<T> root){
    
        if(root == null || (root.right == null && root.left == null)){
            return root; 
            
        }
        BinaryNode<T> newRight = root.left;
        BinaryNode<T> newLeft = root.right;
        BinaryNode<T> newNode = new BinaryNode<>(root.data, rootReverse(newLeft), rootReverse(newRight));
        return newNode;
                                     
   }
    
    public void prettyPrint(){
        
        
        LinkedList<T> binaryList = binaryListMaker(root, height(root), null, null);
       
        prettyPrint(binaryList, 0, height(root));
        
       
        
    }

    private void prettyPrint(LinkedList<T> binaryList, int depth, int currentHeight){
            String currentLine = "";
            String spacing = "";
            for (int i = 0; i<(int)(Math.pow(currentHeight+1, 2)/2) -1; i++ ){
                currentLine += "--";
                }
            for(int i =0; i<(int)(Math.pow(currentHeight+2, 2)/2) -1; i++){
                spacing += "--";
            }
            
            for(int i = 0; i< Math.pow(2, depth); i++){
                T nodeData = binaryList.remove();
                if(nodeData == null){
                    nodeData = (T)"--";
                }
                currentLine += nodeData + spacing;

            }
            System.out.println(currentLine);
            currentHeight--;
            depth++;
            if(binaryList.isEmpty() == true)
                return;
            
        
            prettyPrint(binaryList, depth, currentHeight);
        
       
    }

    private LinkedList<T> binaryListMaker(BinaryNode<T> root, int treeHeight, LinkedList<T> binaryList, LinkedList<BinaryNode<T>> tempList){

        if(root !=null && treeHeight == height(root)){
            
            binaryList = new LinkedList<T>();
            tempList = new LinkedList<>();
            binaryList.add(root.data); 
            
        }
        if(binaryList.size() >= Math.pow(2, treeHeight+1)-1){
            return binaryList;
        }
         
        
        if(root != null){
            tempList.add(root.left);
            tempList.add(root.right);
            if(root.left != null)
                binaryList.add(root.left.data);
            else 
                binaryList.add(null);
           if(root.right != null)
                binaryList.add(root.right.data);
            else 
                binaryList.add(null);
        }else{
            tempList.add(null);
            tempList.add(null);
            binaryList.add(null);
            binaryList.add(null);
            
        }
        root = tempList.remove();
           return binaryListMaker(root, treeHeight, binaryList, tempList);
        
        

   
    }
    
  
}
