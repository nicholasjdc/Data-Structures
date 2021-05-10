import java.util.LinkedList;

public class ExpressionTree implements ExpressionTreeInterface{

    private ExpressionNode root;
    
    public ExpressionTree(String expression){
        LinkedList<ExpressionNode> ETList= new LinkedList<>();
        String operandString = "";
        
        for(int i =0; i < expression.length(); i++){
            char currentChar = expression.charAt(i);
            if(currentChar == '+' ||currentChar == '-' ||currentChar == '*' ||currentChar == '/'){
                ExpressionNode rchild = ETList.pop();
                ExpressionNode lchild = ETList.pop();
                root = new ExpressionNode(currentChar, lchild, rchild);
                ETList.push(root);
                    
                    
            }else if(currentChar == ' ' && operandString != ""){
                 int operand = Integer.parseInt(operandString);
                 operandString = "";
                 ExpressionNode operandNode = new ExpressionNode(operand);
                 ETList.push(operandNode);   
                
                 
            
            }else if(currentChar != ' '){
                operandString += currentChar;    //operand Node
            
            }
           
        } 
        
        root = ETList.pop();
        
    }
    
    
    public int eval(){
        return eval(root);
        
    }
    
    private int eval(ExpressionNode root){
        if(root.operator == '+'){
           
            return eval(root.lchild) + eval(root.rchild); 
       
        }else if(root.operator == '-'){
           
            return eval(root.lchild) - eval(root.rchild);
        }else if(root.operator == '*'){
            
            return eval(root.lchild) * eval(root.rchild);
        }else if(root.operator == '/'){
          
            return eval(root.lchild) / eval(root.rchild);
        }else{         
            
            return root.operand; //Base Case
        }
        
    }
    
	public String postfix(){
        return postfix(root);
        
    }
    private String postfix(ExpressionNode root){
        if(root.lchild == null){
            return "" + root.operand;
            
        }else{
            return "" + postfix(root.lchild) + " "+ postfix(root.rchild) + " " + root.operator;
        
        }
    }
    
	public String prefix(){
        return prefix(root);
        
    }
    
    private String prefix(ExpressionNode root){
        if(root.lchild == null){
            return "" + root.operand;
            
        }else{
            return "" + root.operator + " " + prefix(root.lchild) + " " + prefix(root.rchild) ;
        
        }
    }
	public String infix(){
        return infix(root);
        
    }
    private String infix(ExpressionNode root){
        if(root.lchild == null){
            return "" + root.operand;
            
        }else{
            return "(" + infix(root.lchild) + root.operator +  infix(root.rchild) + ")";
        
        }
    }
    
    private static class ExpressionNode{
        char operator;
        int operand;
        ExpressionNode lchild; 
        ExpressionNode rchild;
        
        public ExpressionNode(int operand){
            this.operand = operand;
            this.lchild = null;
            this.rchild = null;
        
        }
        public ExpressionNode(char operator, ExpressionNode lchild, ExpressionNode rchild){
            this.operator = operator;
            this.lchild = lchild;
            this.rchild = rchild;
        
        }
    }

    
}