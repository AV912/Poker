import java.util.*;

public class Deck
{
    private List<Card> deck = new ArrayList<>();
    private List<Card> cardsInPlay = new ArrayList<>(); // temporaryily used to keep track of cards in play. will remove later
    private List<Card> discardPile = new ArrayList<>();
    
    
    
    public Deck()
    {
        String suit = "";
        String value = "";
        
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
            for(int i = 1; i <= 13; i++){
                if(i == 1){
                    value = "A";
                } else if(i == 11){
                    value = "J";
                } else if(i == 12){
                    value = "Q";
                } else if(i == 13){
                    value = "K";
                } else {
                    value = String.valueOf(i);
                }
                
                deck.add(new Card(suit, value));
            }
        }
    }
    
   

    public void shuffle(){
        
        while(cardsInPlay.size() > 0){
            deck.add(cardsInPlay.remove(0));
        }
        while(discardPile.size() > 0){
            deck.add(discardPile.remove(0));
        }
        ArrayList<Card> temp = new ArrayList<>();
        int randomCard;
        for(int i = 0; i < 52; i++){
            randomCard = (int)(Math.random() * (52-i));
            temp.add(deck.remove(randomCard));
        }

        for(Card tempCard :temp){
            deck.add(tempCard);
        }

    }

    

    public Card draw(){
        cardsInPlay.add(deck.remove(0));
        return cardsInPlay.get(cardsInPlay.size() - 1);
    }

    public void addCardToDiscardPile(Card card){
        discardPile.add(card);
    }

    public void discardHand(Card[] foldedCards){
        discardPile.add(foldedCards[0]);
        String firstCardSuit = foldedCards[0].getSuit();
        String firstCardValue = foldedCards[0].getValue();
        
        discardPile.add(foldedCards[1]);
        String secondCardSuit = foldedCards[1].getSuit();
        String secondCardValue = foldedCards[1].getValue();

        for(int i = cardsInPlay.size() - 1; i >= 0; i--){
            if((cardsInPlay.get(i).getSuit().equals(firstCardSuit) && cardsInPlay.get(i).getValue().equals(firstCardValue)) ||
                (cardsInPlay.get(i).getSuit().equals(secondCardSuit) && cardsInPlay.get(i).getValue().equals(secondCardValue))){
                    cardsInPlay.remove(i);
                }
                
            
            
        }
        
        
    }

  /*  public void discard(Card[] foldedCards){
        try{
            discardCards(foldedCards);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    */



    public String toString(){
        String s = "";
        
        for(Card card : deck){
            s += (card + " ");
        
        }
        s += "\n\nCardsinPlay:\n";
        for(Card card : cardsInPlay){
            s += (card + " \n");
        }
        s += "\n\nDiscardedCards:\n";
        for(Card card : discardPile){
            s += (card + " \n");
        }

        return s;
    }
    
    
    
    
}