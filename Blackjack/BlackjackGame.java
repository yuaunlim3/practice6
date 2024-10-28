package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame{
    protected playingDeck deck;
    protected Dealer dealer;
    protected List<Player> players;
    protected List<Player> playerLeft;

    public BlackjackGame(){
        this.deck = new playingDeck();
        this.dealer = new Dealer();
        this.players = new ArrayList<>();
        this.playerLeft = new ArrayList<>();
    }

    public void bet(String name, int bet){
        for(Player player: this.players){
            if(player.getName().equalsIgnoreCase(name)){
                player.bet(bet);
            }
        }
    }

    public void printPlayers(){
        System.out.println("List of players: ");
        this.players.forEach(players -> System.out.printf("%s \n", players.getName()));
        System.out.println("========================");
    }

    public void start(Player player){

        this.players.add(player);
        this.playerLeft.add(player);    
    }

    public void reset(){
        this.players = new ArrayList<>();
        this.playerLeft = new ArrayList<>();
    }

    public void drawCard(){
        for(int i = 0; i < 2;i++){
            for(Player player : this.players){
                System.out.println("========================");
                System.out.printf("%s cards: ",player.getName());
                player.drawCard(this.deck.drawCard());
                System.out.println("========================");
            }
            System.out.println("Dealer cards: ");
            System.out.println("========================");
            this.dealer.drawCard(this.deck.drawCard());
        }
    }

    public void hit(String name){
        for(Player player: this.players){
            if(player.getName().equalsIgnoreCase(name)){
                player.drawCard(deck.drawCard());
                int scorePlayer = player.getValue();
                if(scorePlayer > 21){
                    System.out.println("Busted");
                    player.lose();
                    this.playerLeft.remove(player);
                }
            }
        }
    }

    public void exit(String name){
        Player toRemove = null;
        for(Player player: this.players){
            if(player.getName().equalsIgnoreCase(name)){
                System.out.printf("%s left with $%d\n",player.getName(),player.getAmount());
                toRemove = player;
                
            }
        }

        this.players.remove(toRemove);
    }

    public void stand(String name){
        for(Player player: this.players){
            if(player.getName().equalsIgnoreCase(name)){
                this.playerLeft.remove(player);
                if(this.playerLeft.size() > 0){
                    this.playerLeft.forEach(players -> System.out.printf("Players left: %s\n", players.getName()));
                }else{
                    System.out.println("No players left");
                }
            }
        }
    }

    public void play(){
        int scoreDealer = dealer.getValue();
        System.out.printf("The dealers value is %d\n", scoreDealer);
        for(Player player: this.players){
            System.out.println("========================");
            int scorePlayer = player.getValue();
            System.out.printf("%s value is %d\n",player.getName(),scorePlayer);
            if(scoreDealer == scorePlayer || (scoreDealer > 21 && scorePlayer > 21)){
                player.draw();
            }else if(scoreDealer < scorePlayer ||(scoreDealer > 21 && scorePlayer < 21)){
                player.win();
            }else if(scoreDealer > scorePlayer ||(scoreDealer < 21 && scorePlayer > 21)){
                player.lose();
            }
            System.out.println("========================");
        }
    }
}
