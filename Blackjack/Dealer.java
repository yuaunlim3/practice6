package Blackjack;

import java.util.*;

public class Dealer {
    protected List<playingCard> cardsInHand;
    protected Integer value;

    public Dealer(){
        this.cardsInHand = new ArrayList<>();
        this.value = 0;
    }
    public void drawCard(playingCard card){
        this.value += card.getValue();
        this.cardsInHand.add(card);
        System.out.println(this.cardsInHand.get(0).toString());
    }

    public Integer getValue() {
        return value;
    }

    public void drawAfter(playingCard card){
        this.value += card.getValue();
        this.cardsInHand.add(card);
        String hand = "[";
        for(playingCard cards:cardsInHand){
            String info = cards.toString();
            hand += " " + info;
        }
        hand += "]" +"  " + this.value;

        System.out.println(hand);
    }

    


    
    

}
