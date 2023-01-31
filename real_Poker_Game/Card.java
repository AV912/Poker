public class Card
{
    private final String suit;
    private final int faceValue;
    private final String faceName;
    
    
    public Card(String s, int v, String n){
        suit = s;
        faceValue = v;
        faceName = n;
     
    }
    
    public String getSuit(){
        return suit;
    }
    
    public int getValue(){
        return faceValue;
    }

    public String getfaceName(){
        return faceName;
    }
    
    public String toString(){
        return faceName  + suit;
    }
}