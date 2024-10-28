package Blackjack;

public class Player extends Dealer {
    protected Integer amount;
    protected Integer betMade;
    protected String name;

    public Player(String name,int amount){
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void drawCard(playingCard card){
        this.value += card.getValue();
        this.cardsInHand.add(card);
        String hand = "[";
        for(playingCard cards:cardsInHand){
            String info = cards.toString();
            hand += " " + info;
        }
        hand += "]" +"  " + this.value;

        System.out.printf("Total values = %s\n",hand);
    }

    public void bet(Integer bet){
        this.betMade = bet;
    }

    public void lose(){
        this.value = 0;
        if(this.betMade > this.amount){
            System.out.println("You are out of money");
        }else{
            System.out.printf("You lose $%d\n",this.betMade);
            this.amount -= this.betMade;
        }
    }

    public void win(){
        System.out.printf("You won $%d\n",this.betMade);
        this.amount += this.betMade;
        this.value = 0;
    }

    public void draw(){this.value = 0;}

    public Integer getAmount() {return amount;}


    public String getName() {return name;}

    

    
    
}
