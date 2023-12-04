import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int turn = 0;
    Player[] players;

    private Deck deck;
    private int playerNum;

    private Scanner s;

    private ArrayList<Card> pile;

    public Game()
    {
        deck = new Deck();
        pile = new ArrayList<Card>();
        s = new Scanner(System.in);
    }
    public static void main(String[] args) {
        Game b = new Game();
        b.playGame(b);
    }

    public void playGame(Game b){
        b.makePlayers();
        b.makeHands();
    }
// Gets Player Name's and Number
    public void makePlayers()
    {
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
        for(int i = 0; i < playerNum; i++)
        {
            for(int j = 0; j < cardAmount; j++)
            {
                players[i].addCard(deck.deal());
            }
        }
        for(int i = 0; i < cardLeft; i++)
        {
            pile.add(deck.deal());
        }
    }
    // Orders hands numerically
    public void orderHands(ArrayList<Card> hand, int playerNum)
    {

    }

    public void showHand(int playerNum)
    {
        ArrayList<Card> temp = players[playerNum].getHand();
        int length = temp.size();
        for(int i = 0; i < length; i++)
        {
            System.out.println(temp.get(i));
        }
        System.out.println("Done Looking?");
        String response = s.nextLine();
        System.out.println("\033[H\033[2J");
    }



}
