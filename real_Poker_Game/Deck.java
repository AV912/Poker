import java.util.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();


    public Deck(){
        String suit = "";
        
        String name = "";
        
        for(int j = 1; j <= 4; j++){
            if(j == 1){
                suit = "Spade";
            } else if(j == 2){
                suit = "Club";
            } else if(j == 3){
                suit = "Heart";
            } else if(j == 4){
                suit = "Diamond";
            }
            for(int i = 2; i <= 14; i++){
                if(i == 14){
                    name = "A";
                    
                } else if(i == 11){
                    name = "J";
                } else if(i == 12){
                    name = "Q";
                } else if(i == 13){
                    name = "K";
                } else {
                    name = String.valueOf(i);
                }
                
                deck.add(new Card(suit, i, name));
            }
        }
    }


    public void shuffle(){
        
        ArrayList<Card> temp = new ArrayList<>();
        int randomCard;
        int originalDeckSize = deck.size();
        for(int i = 0; i < originalDeckSize; i++){
            randomCard = (int)(Math.random() * (originalDeckSize - i));
            temp.add(deck.remove(randomCard));
        }

        for(Card tempCard :temp){
            deck.add(tempCard);
        }
    }

    public Card draw(){
        return deck.remove(0);
    }

    public String toString(){
        String s = "";
        
        for(Card card : deck){
            s += (card + " ");
        
        }
        

        return s;
    }


}

