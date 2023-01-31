public class Card
{
    private final String suit;
    private final String value;
    
    
    public Card(String s, String v){
        suit = s;
        value = v;
     
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String getValue(){
        return value;
    }
    
    public String toString(){
        return value  + suit;
    }
}