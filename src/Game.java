import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int turn = 0;
    Player[] players;

    private Deck deck;
    private int playerNum;

    private ArrayList<Card> pile;

    public Game()
    {
        Deck deck = new Deck();
        pile = new ArrayList<Card>();
    }
    public static void main(String[] args) {
        Game b = new Game();
        b.playGame(b);
    }

    public void playGame(Game b){
        b.makePlayers();
    }
// Gets Player Name's and Number
    public void makePlayers()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many Players:");
        playerNum = s.nextInt();
        s.nextLine();
        players = new Player[playerNum];
        for(int i = 0; i < playerNum; i++)
        {
            System.out.println("What's You Name?");
            String name = s.nextLine();
            players[i] = new Player(name);
        }
    }
// Shuffles Decks and Deals
    public void makeHands()
    {
        deck.shuffle();
        int cardAmount = 52 / playerNum;
        int cardLeft = 52 % playerNum;
      // Add Leftover Cards to Pile
        for(int i = 0; i < cardLeft; i++)
        {
            pile.add(deck.deal());
        }

    }


}
