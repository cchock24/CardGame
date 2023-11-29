public class Card {

    private int point;
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }

    public void setSuit(String str)
    {
        if(str.equals("heart") || str.equals("diamond") || str.equals("club") || str.equals("spade"))
        {
            suit = str;
        }
    }

    public void setRank(String str)
    {
        rank = str;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
