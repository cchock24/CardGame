public class Card {

    private int point;
    private String suit;
    private String rank;

    public Card(String suit, String rank, int point) {
        this.suit = suit;
        this.rank = rank;
        this.point = point;
    }

    public Card(String suit, String rank){
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

    public void setPoint(int num)
    {
        point = num;
    }

    public int getPoint()
    {
        return point;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
