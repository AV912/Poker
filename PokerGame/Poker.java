import java.util.*;

/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

public class Poker
{
    
    public static void main (String[] args) throws Exception {
        /* code */
        //Deck deck = new Deck();
        //System.out.println(deck);

        //deck.shuffle();

        //System.out.println(deck);

       // for(int i =0; i < 11; i++){
            //deck.draw();
        //}
       // System.out.println(deck);

      
      
      
      /*
      
       Table table = new Table(1,2);

       System.out.println(table);
       table.shuffle();
       System.out.println(table);

       table.dealFlop();
       table.addCardtoTable();
       table.addCardtoTable();
       table.addCardtoTable();
       System.out.println(table);

       table.addPlayer("j",25000);
       table.addPlayer("i",25000);
       table.addPlayer("k",25000);
       table.addPlayer("l",25000);
       table.addPlayer("m",25000);
       table.addPlayer("n",25000);
       table.addPlayer("p",25000);
       table.dealCards();
       System.out.println(table);
       */

       //table.discard(1);

      // table.discard(0);
      // System.out.println(table);

      // table.shuffle();
       //System.out.println(table);

       PokerUI game = new PokerUI(1,2);
       game.startGame();

       

       

    
      
    }
}
