import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int point;

    public Player(String n){
        this.name = n;
        point = 0;
    }

    public Player(String n, ArrayList<Card> h){
        name = n;
        point = 0;
        hand = h;
    }

    public int getPoint()
    {
        return point;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void addPoints(int points)
    {
        point += points;
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }

    public String toString()
    {
        return name + " has " + point + " points" + name + "'s cards: " + hand;
    }
}
