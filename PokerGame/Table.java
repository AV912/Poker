import java.util.*;

public class Table extends Deck{
    private Card[] table;
    public static int numCards;
    private ArrayList<Player> activePlayers = new ArrayList<>();
    private int pot;
    private double currentBet;
    private final double smallBlind;
    private final double  bigBlind;
    private int buttonPosition;
    
    


    
    

    public Table(double smallBlind, double bigBlind){
        super();
        table = new Card[5];
        pot = 0;
        
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        buttonPosition = 1; 
        currentBet = bigBlind;

        
    }

    public double getSmallBlind(){
        return smallBlind;
    }

    public double getBigBlind(){
        return bigBlind;
    }



    public void advanceButtonPosition(){
        if(buttonPosition == players.size()){
            buttonPosition = 1;
        } else{
            buttonPosition++;
        }
    }

    public int getButtonPosition(){
        return buttonPosition;
    }

    

    

    

    public boolean CanStartGame(){
        if(players.size() >= 2){
            return true;
        }
        return false;
    }



    public void printPot(){ //prints pot
        System.out.println("Pot: " + pot);
    }

    public void increasePot(double amount){
        pot += amount;
    }



    public void payout(Player player){     // implement side pots later
        player.addMoney(pot);
        pot = 0;
    }

    //public void payout(Player )   // method that takes three players and takes the lowest bet and makes a side pot with the other players.
    public double sidePotPayout(double sidePot, int numberOfPlayers ){ // takes the side pot and the number of players to be distributed by and returns the number each person gets
        return sidePot / numberOfPlayers;
    }



   /* public void changeBet(int PlayerNumber, double amount){
        if(amount < 0){

        } else{
        bets[PlayerNumber] = players.get(PlayerNumber - 1).bet(amount);
        }
    }
    public void raiseBet(int PlayerNumber, double amount){
        if(amount < 0){

        }else{
        bets[PlayerNumber] += players.get(PlayerNumber - 1).bet(amount);
        currentBet += amount;
        }
    }*/
    public boolean areAllBetsEqual(){
        boolean allBetsEqual = true;
        for(int i = 1; i < players.size(); i++){
            if()
        }
    }
    public double getCurrentBet(){
        return currentBet;
    }

    




    public void shuffle(){
        
        for (Player player : players) {
            player.fold();
        }

        for(int i = 0; i < table.length; i++){
            table[i] = null;
        }

        super.shuffle();
    }
    
    public void dealCards(){
        
        for(int i = 1; i <= 2; i++){
            this.burnCard();
            for(int j = 0; j < players.size(); j++){
                players.get(j).addCard(super.draw());
            }
        }
    }

    public void addCardtoTable(){
        if(numCards >=5){
            System.out.println("No more cards can be placed");
        } else{
            table[numCards] = super.draw();
            numCards++;
        }
    }

    public void dealFlop(){
        addCardtoTable();
        addCardtoTable();
        addCardtoTable();
    }

    public void discard(int playerNumber){
        try{
            super.discardHand(getPlayer(playerNumber).fold());
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void burnCard(){
        super.addCardToDiscardPile(super.draw());  // burns card
    }




    

    

    public void addPlayer(String name, double cash){
        if(players.size() >= 6){
            System.out.println("The table is full! Wait for next game");
        } else{
            players.add(new Player( name, cash));
        }
    }


    public Player getPlayer(int playerNumber) {
        
        try{
            if(playerNumber < 1 || playerNumber > 6){
                throw new Exception("Player number " + playerNumber + " doesn't exist");
            }
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        
        return players.get(playerNumber - 1);
    }

    public int getNumberOfPlayers(){
        return players.size();
    }

   
    

    public String toString(){
        String s = "table:\n";
        for(int i = 0; i < 5; i++){
            s += table[i] + "  ";
        }
        s += "\n\nPlayers:\n";
        for(int i = 0; i < players.size(); i++){
            s += "Number " + (i+1) + ": " + players.get(i).getName() + " " + players.get(i);
        }

        return super.toString() + "\n" + s + "\n";

    }
}
