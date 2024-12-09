package Entity;


import java.util.Arrays;

public class Player {

    private String name;

    private long grades;

    private final Card[] cardsOnHand = new Card[2];

    public Player(String name) {
        this.name = name;
    }

    public void setCard(Card card, int index) {
        cardsOnHand[index] = card;
    }

    public Card[] getCardsOnHand() {
        return cardsOnHand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                ", cardsOnHand=" + cardsOnHand[0].getType()+cardsOnHand[0].getRank() +"  "+cardsOnHand[1].getType()+cardsOnHand[1].getRank()+
                '}';
    }
}
