package Blackjack;

public class playingCard {

    protected String suit;
    protected String number;
    protected Integer value;

    public playingCard(String suit, String number, int value){
        this.suit = suit;
        this.number = number;
        this.value = value;
    }

    public String getSuit() {return suit; }

    public void setSuit(String suit) { this.suit = suit;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public Integer getValue() {return value; }

    public void setValue(Integer value) { this.value = value; }
    
    @Override
    public String toString(){
        return String.format("%s %s",this.suit, this.number);
    }
}
