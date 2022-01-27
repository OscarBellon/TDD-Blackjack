import Controller.Controller;
import cards.AceCard;
import cards.Card;
import cards.FigureCard;
import cards.PipCard;
import org.junit.*;
import static org.junit.Assert.assertArrayEquals;
import player.Player;


public class tests{
    
   

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    @Test
    public void testCaso1(){
        Player p1 = new Player("Player1",new FigureCard(),new AceCard());
        Player p2 = new Player("Player2",new PipCard(10),new PipCard(5),
                new PipCard(6));
        Player p3 = new Player("Player3", new PipCard(3),new PipCard(6),
                new AceCard(), new PipCard(3),new AceCard(),new FigureCard());
        Player croupier = new Player("Croupier", new PipCard(9),new PipCard(7));
        Card[] deck = {new PipCard(5), new PipCard(4), new FigureCard(),
                new PipCard(2)};
        
        Player[] expectedWinners= {p1};
        Player[] resultWinners = Controller.getWinners(p1.getCards(), 
                p2.getCards(), p3.getCards(), croupier.getCards(), deck);
        assertArrayEquals(expectedWinners,resultWinners);
        
        
    }
    @Test
    public void testCaso2(){
        Player p1 = new Player("Player1",new PipCard(10),new FigureCard());
        Player p2 = new Player("Player2",new PipCard(10),new PipCard(2),
                new PipCard(6));
        Player p3 = new Player("Player3", new PipCard(8),new PipCard(8),
                new PipCard(5));
        Player croupier = new Player("Croupier", new PipCard(5),new PipCard(10));
        Card[] deck = {new AceCard(), new PipCard(3), new FigureCard(),
                new PipCard(2)};
        
        Player[] expectedWinners= {p1,p2,p3};
        Player[] resultWinners = Controller.getWinners(p1.getCards(), 
                p2.getCards(), p3.getCards(), croupier.getCards(), deck);
        assertArrayEquals(expectedWinners,resultWinners);
    }
}
