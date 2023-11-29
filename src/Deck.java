import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> Cards = new ArrayList<Card>();
    private int cardsLeft;

    public Deck(String[] suit, String[] rank)
    {
        int length = suit.length;
        int length2 = rank.length;
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < length2; i++)
            {
                Cards.add(new Card(suit[i], rank[j]));
            }
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

    public boolean isEmpty()
    {
        if(cardsLeft <= 0)
        {
            return true;
        }
        return false;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public Card deal()
    {
        if(Cards.isEmpty())
        {
            return null;
        }

        cardsLeft -= 1;
        return Cards.get(cardsLeft);
    }

    public void shuffle()
    {
        for(int i = 0; i < cardsLeft; i++)
        {
            int index1 = (int)(Math.random() * cardsLeft);
            int index2 = (int)(Math.random() * cardsLeft);
            Cards.add(index2, Cards.remove(index1));
            Cards.add(index1, Cards.remove(index2));
        }
    }

}
