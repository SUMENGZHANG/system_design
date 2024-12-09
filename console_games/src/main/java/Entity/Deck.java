package Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 一副牌
 */
public class Deck {

    private static final List<Card> cards = new ArrayList<>(52);
    private static final String[] cardTypes = {"红桃","方块","黑桃","梅花"};
    private static final String[] cardRank = {
            "1","2","3","4","5","6","7","8","9","10","J","Q","K","A"
    };

    static {
        for(String cardType:cardTypes){
            for(String cardRank:cardRank ){
                cards.add(new Card(cardType,cardRank));
            }
        }
    }

    public List<Card> shuffle(){
        Collections.shuffle(cards);
        return cards;
    }

    public Card getRandomCard(int index){
        return cards.get(index);
    }

}
