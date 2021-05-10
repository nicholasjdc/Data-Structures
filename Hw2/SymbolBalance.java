import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SymbolBalance implements SymbolBalanceInterface{ 
    private MyStack<Character> symbolStack = new MyStack<Character>();
    private File f;
    private Scanner in;
    private Character[] openSymbols = {'{', '(','['};
    private Character[] closeSymbols = {'}',')',']'};
    private Boolean rawString = false;
    private int lineNumber = 0;
    private MismatchError mme;
    private NonEmptyStackError nese;
    private EmptyStackError ese;
        
    public void setFile(String filename){
        f = new File(filename);
        try {
            in = new Scanner(f);
        } catch(FileNotFoundException e){
            System.err.println("That file does not exist.");
            System.exit(-1);
        }
        
    }
    
	public BalanceError checkFile(){
          while(in.hasNextLine()){
              lineNumber +=1; 
              BalanceError errors = lineReader();
              if(errors != null){
                  return errors;
                  
              }
                     
              }
              if(symbolStack.size() != 0){
                  nese = new NonEmptyStackError(symbolStack.peek(), symbolStack.size());
                  return nese;
              }
              
              return null; 
          }
     
    
    
     public BalanceError lineReader(){
        String nextLine = in.nextLine();

       
        for(int i = 0; i < nextLine.length(); i++){
  
            if(i<nextLine.length()-1 && rawString == false){
                rawString = rawStringChecker(nextLine.charAt(i), nextLine.charAt(i+1));
                
            }else if(i<nextLine.length() && rawString == false){
                rawString = rawStringChecker(nextLine.charAt(i), ':');
            }
            if(rawString == true){
                System.out.println(symbolStack.peek());
                for(i = i +1; i< nextLine.length(); i++){                    
                    if(symbolStack.peek().equals('*') && i<nextLine.length()-1){
                        if(nextLine.charAt(i) == '*' && nextLine.charAt(i+1) == '/'){
                           symbolStack.pop();
                            symbolStack.pop();
                            rawString = false;
                            break;
                        }
                    }else if(symbolStack.peek().equals('"')){
                        if(nextLine.charAt(i) == '"' ){
                            symbolStack.pop();
                            System.out.println("Broken");
                            rawString = false;
                            break;
                        }

                    }

                }
           
            
            
            }else{
            
            
            for(Character c: openSymbols){
                if(c.equals(nextLine.charAt(i)) && rawString == false){
                    symbolStack.push(c);
                   

                    }

                }


            for(int j =0; j<  closeSymbols.length; j++){
                if(closeSymbols[j].equals(nextLine.charAt(i))){
                    if(symbolStack.isEmpty() == true){
                        ese = new EmptyStackError(lineNumber);
                        return ese;
                    }
                    Character poppedSymbol = symbolStack.pop();
                   

                    if(poppedSymbol.equals(openSymbols[j]) == false){
                        mme = new MismatchError(lineNumber, closeSymbols[j], poppedSymbol);
                        return mme;
                    }




                    }

              }
            }
       
            
        
        }
         return null;
     }
         
      
    public Boolean rawStringChecker(Character c, Character d){
        if(c.equals('/') && d.equals('*')){
            symbolStack.push(c);
            symbolStack.push(d);
            return true;
        }else if(c.equals('"')){
            symbolStack.push(c);
            
            return true;
        }else{
            return false;
        }
    }
  
    
    

}