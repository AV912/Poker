import java.util.*;

public class PokerUI {
    
    private Scanner scan;
    private Table table;
    private boolean isPreflop;
    private boolean isFlop;
    private boolean isTurn;
    private boolean isRiver;

    public PokerUI(double smallBlind, double bigBlind){
        this.scan = new Scanner(System.in);
        this.table = new Table(smallBlind, bigBlind);
        isPreflop = true;
        isFlop = false;
        isTurn = false;
        isRiver = false;
    }


    public void startGame(){
        System.out.println("Welcome to Poker!\nIf you would like to play press: 1\n if you would like to leave press: 2");
        String introButtons = scan.nextLine();
        
        while(!(introButtons.equals("2"))){
            playerSelect();

            System.out.println("Starting Game!");

            playHand();


            




            System.out.println("Press 2 to confirm");
            introButtons = scan.nextLine();
            System.out.println(table);
        }
        System.out.println("Thanks for playing Poker!");
    }

    public void playerSelect(){
        System.out.println("If you would like to add a player press: 1\nIf you would like to leave press: 2");
            String playerSelection = scan.nextLine();
            
            while(playerSelection.equals("1")){
                System.out.println("What's your name?");
                String name = scan.nextLine();
                System.out.println("How much money are you starting with?");
                double money = Double.valueOf(scan.nextLine());
                table.addPlayer(name, money);

                System.out.println("If you would like to add another player press: 1\nIf you would like to start the game press: 2");
                playerSelection = scan.nextLine();
                if(playerSelection.equals("2") && !(table.CanStartGame())){
                    System.out.println("Need more players to start game");
                    playerSelection = "1";
                }
            }
    }


    public void playHand(){
        System.out.println("...Dealing Cards...");
        table.dealCards();
        this.playBlinds();
        this.startRoundOfBetting();
        isPreflop = false;
        isFlop = true;
        this.startRoundOfBetting();
        isFlop = false;
        isTurn = true;

    }

    public void playBlinds(){
        System.out.println("...Small Blind...");
        
         // changes the table bets and plays small blind
            
        
        
        table.printPot();
        System.out.println("...Big Blind...");
       
         // changes the table bets and plays big blind
            
       
        table.printPot();
    }

    public void startRoundOfBetting(){
        if(isPreflop){
            int index = table.getButtonPosition() + 3; // starts after big blind
            while(!(table.areAllBetsEqual())){
                
               
                System.out.println(table.getPlayer(index) + " if you want to ante up press 1 or if you want to fold press 2");
                    
                
                
                String playerInput = scan.nextLine();

                if(playerInput.equals("1")){
                    System.out.println("How much do you want to bet?");

                }

                index = (index + 1) % table.getNumberOfPlayers();
            }
        }
    }
}
