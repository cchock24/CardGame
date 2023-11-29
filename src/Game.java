import java.util.Scanner;

public class Game {
    int turn = 0;
    Player[] players;

    public Game()
    {

    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        Game b = new Game();
        b.makePlayers();
    }

    public void makePlayers()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many Players:");
        int playerNum = s.nextInt();
        s.nextLine();
        players = new Player[playerNum];
        for(int i = 0; i < playerNum; i++)
        {
            System.out.println("What's You Name?");
            String name = s.nextLine();
            players[i] = new Player(name);
        }
    }


}
