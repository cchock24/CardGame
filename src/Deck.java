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
            for(int j = 0; j < length2; j++)
            {
                Cards.add(new Card(suit[i], rank[j]));
            }
        }
    }
    // Make A default deck
    public Deck()
    {
        cardsLeft = 52;
        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("heart", String.valueOf(i), i));
        }

        Cards.add(new Card("heart", "j", 11));
        Cards.add(new Card("heart", "q", 12));
        Cards.add(new Card("heart", "k", 12));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("spade", String.valueOf(i), i));

        }

        Cards.add(new Card("spade", "j", 11));
        Cards.add(new Card("spade", "q", 12));
        Cards.add(new Card("spade", "k", 13));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("diamond", String.valueOf(i), i));
        }

        Cards.add(new Card("diamond", "j", 11));
        Cards.add(new Card("diamond", "q", 12));
        Cards.add(new Card("diamond", "k", 13));

        for(int i = 1; i < 11; i++)
        {
            Cards.add(new Card("club", String.valueOf(i), i));
        }

        Cards.add(new Card("club", "j", 11));
        Cards.add(new Card("club", "q", 12));
        Cards.add(new Card("club", "k", 13));
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
            Card temp = Cards.get(index1);
            Cards.set(index1, Cards.get(index2));
            Cards.set(index2, temp);
        }
    }

}
