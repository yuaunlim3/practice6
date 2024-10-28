package Blackjack;

import java.security.SecureRandom;
import java.util.*;

public class playingDeck {
    public static final String[] SUIT = {"Heart", "Diamond", "Spade", "Clubs"};

    public static final String[] NUMBERS ={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public static final Integer[] VALUES= {1,2,3,4,5,6,7,8,9,10,10,10,10};

    protected Queue<playingCard> deck;

    protected playingCard[] cardInDeck;

    public playingDeck(){
        this.deck = new LinkedList<playingCard>();
        this.cardInDeck = new playingCard[52];
        int idx = 0;
        for(String suit:SUIT){
            for(int i = 0; i < NUMBERS.length; i++){
                String number = NUMBERS[i];
                int value = VALUES[i];
                playingCard card = new playingCard(suit, number, value);
                this.cardInDeck[idx] = card;
                idx++;

            }
        }

        createDeck();

    }

    public void createDeck(){
        Arrays.stream(this.cardInDeck).forEach(item -> this.deck.add(item));
    }

    public playingCard drawCard(){
        if(this.deck.size() > 0){
            shuffle();
            return this.deck.poll();
        }else{
            createDeck();
            shuffle();
        }
        return null;

    }

    public void shuffle(){
        this.deck = new LinkedList<playingCard>();
        Random rand = new SecureRandom();
        for (int idx = this.cardInDeck.length - 1; idx > 0; idx--) {
            
            int pos = rand.nextInt(idx + 1);
            playingCard temp = this.cardInDeck[idx];
            this.cardInDeck[idx] = this.cardInDeck[pos];
            this.cardInDeck[pos] = temp;
        }

        createDeck();

    }



}
    
