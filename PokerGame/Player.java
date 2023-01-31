

public class Player {
    private Card[] hand = new Card[2];
    public static int numPlayers;
    private double money;
    private double bet;
    private String name;
    private int playerNumber;
    private boolean isActive;  // regards players activity in a hand


    public Player( String name, double cash){
        numPlayers++;
        this.name = name;
        money = cash;
        hand[0] = null;
        hand[1] = null;
        isActive = true;
        bet = 0;
        playerNumber = numPlayers;

    }
    
    public void addCard(Card card){
        if(hand[0] == null){
            hand[0] = card;
        } else if(hand[1] == null){
            hand[1] = card;
        }
    }

    public String getName(){
        return name;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setActivity(boolean isActive){
        this.isActive = isActive;
    }

    public double getBet(){
        return bet;
    }

    public void resetBet(){
        bet = 0;
    }
    
    public double bet(double amount){
        money-=amount;
        bet = bet + amount;
        return bet;
    }

    

    public void call(double amount){
        bet(amount);
    }

    public void check(){
        
    }




    public Card[] fold(){
        Card[] temp = new Card[]{hand[0], hand[1]};
        hand[0] = null;
        hand[1] = null;
        return temp;
    }

    

    public void addMoney(double amount){
        money+= amount;
    }

    public double getMoney(){
        return money;
    }

    public String toString(){
        return hand[0] + " " + hand[1] + " " + "$" + money + "\n";
    }



    
}
