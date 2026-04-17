/** 
 * Java program to demonstrate how to convert Enum to String in Java. This program demonstrate
 * two examples by using name() and toString() method to get a meaningful String representation 
 * from an Enum instance in Java.
 * 
 * @author Javin Paul
 */ 
public class EnumToString { 

  private enum Weekdays { 
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY; 
  } 

  private enum ColdDrink { 
    PEPSI("Pepsi"), COKE("Coca Cola"), SPRITE("Sprite"); 

    private String brandname; 

    private ColdDrink(String brand) { 
      this.brandname = brand; 
    } 
        
    @Override 
    public String toString(){ 
      return brandname; 
    } 
  } 
    
  public static void main(String args[]) { 
    //Converting Enum to String by using name() method by default print mehtod calls toString() of enum 
    
    ColdDrink[] drinks = ColdDrink.values(); 
    for (ColdDrink drink : drinks) { 
      System.out.printf("String to Enum example using name :  %s%n", drink.name ()); 
    } 

    //Converting Enum to String using toString() method 
    for (ColdDrink drink : drinks) { 
      System.out.println("String to enum conversion using toString() : " + drink); 
    } 

}

