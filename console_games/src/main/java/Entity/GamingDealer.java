package Entity;

import enums.GamingStaffEnum;

import java.util.List;

public class GamingDealer extends GamingStaffTemplate{

    private static final int LIMIT_NUM = 2;
    private Deck deck;


    public GamingDealer(Deck deck,String name) {
        super(GamingStaffEnum.DEALER,name);
        this.deck = deck;
    }

    @Override
    public boolean coreDuty() {
        System.out.println("i am dealer, enjoy the game");
        return true;
    }

    /**
     *  发牌
     * @return
     */
    @Override
    public boolean coreDuty(List<Player> players) {
        deck = new Deck();
        deck.shuffle();

        // 发牌
        for(int i = 0;i<LIMIT_NUM;i++ ){
            for(int j = 0;j<players.size();j++){
                Card curCard = deck.getRandomCard((i+1)*(j+1));
                players.get(j).setCard(curCard,i);
            }
        }
        return true;

    }
}
