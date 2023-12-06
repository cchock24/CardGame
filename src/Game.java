import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int turn = 1;
    int p = 0;

    String response = "";
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
        b.clearScreen();
        for(int i = 0; i < playerNum; i++)
        {
            System.out.println("Showing Player " + (i+1) + "'s Cards");
            response = s.nextLine();
            b.showHand(i);
            b.clearScreen();

        }
        boolean win = false;
        while(!win)
        {
            b.playCard();
            b.addTurn();
            win = b.checkWin();
        }
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
        response = s.nextLine();
        this.clearScreen();
    }

    public void playCard(){
        this.explainValue();
        ArrayList<Card> check = new ArrayList<>();
        System.out.println("How Many Cards Do You Want to Play");
        int amount = s.nextInt();
        s.nextLine();
        for(int i = 0; i < amount; i++) {
            System.out.println("What Cards Do You Want to Play (Input the Index)");
            int index = s.nextInt();
            s.nextLine();
            check.add(players[p].getHand().get(index));
            pile.add(players[p].getHand().remove(index));
        }
        this.clearScreen();
        System.out.println("Do You Think They Lied");
        boolean lie = s.nextBoolean();
        s.nextLine();
        if(lie)
        {
            //Ask for Player's Number
            boolean result = this.checkLie(check);
            if(!result)
            {
                System.out.println("Player " + (p+1) + " did lie!");
                System.out.println("As punishment they must take all the cards in the pile!");
                for(int i = 0; i < pile.size(); i++)
                {
                    players[p].addCard(pile.remove(i));
                }
            }
            else{
                System.out.println("Player " + (p+1) + " did not lie!");
                System.out.println("As punishment you must take all the cards in the pile");
                // Change to make guessing player take the cards
                for(int i = 0; i < pile.size(); i++)
                {
                    players[p].addCard(pile.remove(i));
                }
            }
        }
    }

    public void explainValue()
    {
        System.out.println("You need to play a card of " + turn + " value");
        if(turn == 1)
        {
            System.out.println("Or an Ace");
        }
        if(turn == 11)
        {
            System.out.println("Or a Jack");
        }
        if(turn == 12)
        {
            System.out.println("Or a Queen");
        }
        if(turn == 13)
        {
            System.out.println("Or a King");
        }
    }

    public boolean checkLie(ArrayList<Card> list)
    {
        for(Card i : list)
        {
            if(i.getPoint() != turn)
            {
                return false;
            }
        }
        return true;
    }

    public void addTurn()
    {
        if(turn <= 13)
        {
            turn += 1;
        }
        else
        {
            turn = 1;
        }
        if(p <= playerNum)
        {
            p += 1;
        }
        else
        {
            p = 0;
        }
    }

    public boolean checkWin()
    {
        for(int i = 0; i < players.length; i++)
        {
            if(players[i].getHand().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    public void clearScreen()
    {
        for(int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

}
