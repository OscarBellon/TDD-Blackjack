
import Controller.Controller;
import cards.AceCard;
import cards.Card;
import cards.FigureCard;
import cards.PipCard;
import player.Player;

public class Main {

    public static void main(String[] args) {
        Player p1 = new Player("Player1",new PipCard(10),new FigureCard());
        Player p2 = new Player("Player2",new PipCard(10),new PipCard(2),
                new PipCard(6));
        Player p3 = new Player("Player3", new PipCard(8),new PipCard(8),
                new PipCard(5));
        Player croupier = new Player("Croupier", new PipCard(5),new PipCard(10));
        Card[] deck = {new AceCard(), new PipCard(3), new FigureCard(),
                new PipCard(2)};
        
        Player[] expectedWinners= {p1,p2};
        Player[] resultWinners = Controller.getWinners(p1.getCards(), 
                p2.getCards(), p3.getCards(), croupier.getCards(), deck);
        
    }
    
}
