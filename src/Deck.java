import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> Cards = new ArrayList<Card>();
    private int cardsLeft;

    public Deck(String[] suit, String[] rank)
    {
        int length = suit.length;
        for(int i = 0; i < length; i++)
        {
            Cards.add(new Card(suit[i], rank[i]));
        }
    }
    // Make A default deck
    public Deck()
    {
        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("heart", String.valueOf(i)));
        }

        Cards.add(new Card("heart", "j"));
        Cards.add(new Card("heart", "q"));
        Cards.add(new Card("heart", "k"));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("spade", String.valueOf(i)));
        }

        Cards.add(new Card("spade", "j"));
        Cards.add(new Card("spade", "q"));
        Cards.add(new Card("spade", "k"));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("diamond", String.valueOf(i)));
        }

        Cards.add(new Card("diamond", "j"));
        Cards.add(new Card("diamond", "q"));
        Cards.add(new Card("diamond", "k"));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("club", String.valueOf(i)));
        }

        Cards.add(new Card("club", "j"));
        Cards.add(new Card("club", "q"));
        Cards.add(new Card("club", "k"));
    }
}
