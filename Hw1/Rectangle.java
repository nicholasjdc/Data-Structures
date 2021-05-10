public class Rectangle implements RectangleInterface, Comparable<Rectangle> { 
    private double length;
    private double width;
    private double perimeter;
   
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
        this.perimeter = length + width;
        
        
    }
    @Override
    public int compareTo(Rectangle other){
        return (int)(this.getPerimeter() - other.getPerimeter());
    }

    public double getLength(){
    return length;    
  
    }
    
    public double getWidth(){ 
    return width;
    
    }
    
    public double getPerimeter(){
        return perimeter;
        
    }
    @Override
    public String toString(){
        return perimeter + " " + length + " " + width;
        
        
    }

}
