package Blackjack;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        
        Console con = System.console();
        String cmd = "a";

        while(!cmd.equalsIgnoreCase("exit")){
            game.printPlayers();
            cmd = con.readLine("CMD>>> ");
            if(cmd.equalsIgnoreCase("start")){
                String name = con.readLine("Name: ");
                int amount = Integer.parseInt(con.readLine("Amount in hand: "));
                Player player = new Player(name, amount);
                game.start(player);

                int amountBet = Integer.parseInt(con.readLine("Bet "));
                game.bet(name, amountBet);
                
            }

            if(cmd.equalsIgnoreCase("draw")){
                game.drawCard();
            }
            if(cmd.equalsIgnoreCase("hit")){
                String name = con.readLine("Name: ");
                game.hit(name);
            }

            
            if(cmd.equalsIgnoreCase("stand")){
                String name = con.readLine("Name: ");
                game.stand(name);
            }

            if(cmd.equalsIgnoreCase("play")){
                game.play();
            }

            if(cmd.equalsIgnoreCase("exit player")){
                String name = con.readLine("Name: ");
                game.exit(name);
            }

        }
        
    }
}
