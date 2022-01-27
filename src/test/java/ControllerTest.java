
import Controller.Controller;
import cards.AceCard;
import cards.Card;
import cards.FigureCard;
import cards.PipCard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void calculateValueTest1(){
        Card[] cards = {new AceCard(),new PipCard(3)};
        int expectedVal = 14;
        assertEquals(expectedVal,Controller.calculateValue(cards));
    }
    @Test
    public void calculateValueTest2(){
        Card[] cards = {new AceCard(),new FigureCard()};
        int expectedVal = 21;
        assertEquals(expectedVal,Controller.calculateValue(cards));
    }
    @Test
    public void calculateValueTest3(){
        Card[] cards = {new AceCard(),new AceCard(), new PipCard(8)};
        int expectedVal = 20;
        assertEquals(expectedVal,Controller.calculateValue(cards));

    }
    @Test
    public void isBlackJackTest1(){
        Card[] cards = {new AceCard(),new FigureCard()};
        boolean expectedValue = true;
        assertEquals(expectedValue,Controller.isBlackjack(cards,
                Controller.calculateValue(cards)));
    }
    @Test
    public void isBlackJackTest2(){
        Card[] cards = {new AceCard(),new PipCard(8),new PipCard(2)};
        boolean expectedValue = false;
        assertEquals(expectedValue,Controller.isBlackjack(cards,
                Controller.calculateValue(cards)));
    }
}
