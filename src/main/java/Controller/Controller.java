package Controller;

import cards.AceCard;
import cards.Card;
import java.util.ArrayList;
import player.Player;

public class Controller {
    public static Player[] getWinners(Card[] p1, Card[] p2, Card[] p3, 
            Card[] croupier,Card[] Deck){
        int p1Vals=calculateValue(p1);
        int p2Vals=calculateValue(p2);
        int p3Vals=calculateValue(p3);
        Card[][] cards = {p1,p2,p3};
        int[] values = {p1Vals,p2Vals,p3Vals};
        int croupierVals=calculateValue(croupier);
        ArrayList<Player> winners = new ArrayList<>();
        if(isBlackjack(croupier,croupierVals)){
            winners.add(new Player("Croupier",croupier));
            return winners.stream().toArray(Player[]::new);
        }else if(!pBlackjacks(cards,values).isEmpty()){
            return pBlackjacks(cards,values).stream().toArray(Player[]::new);
        } else{
            for (int i = 1; i < 4; i++) {
                if(values[i-1]<=21){
                    winners.add(new Player("Player"+i,cards[i-1]));
                }
            }
        }
        if(winners!=null) return winners.stream().toArray(Player[]::new);
        winners.add(new Player("Croupier",croupier));
        return winners.stream().toArray(Player[]::new);
    }
    
    public static ArrayList<Player> pBlackjacks(Card[][] cards,int[] vals){
        ArrayList<Player> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if(isBlackjack(cards[i-1],vals[i-1])){
                list.add(new Player("Player"+i,cards[i]));
            }
        }
        return list;
    }
    
    public static boolean isBlackjack(Card[] hand, int val){
        if(hand.length == 2 && val==21){
            return true;
        }
        return false;
    }
    
    public static int calculateValue(Card[] cards){
        int totalValue = 0;
        int aceCount = 0;
        for (Card card : cards) {
            if(card instanceof AceCard){
                aceCount++;
            }else{
                totalValue += card.getValue();
            }
        }
        for (int i = aceCount; i > 0; i--) {
            if(totalValue + i*11 + aceCount-i <= 21){
                return totalValue + i*11 + aceCount-i;
            }
        }
        return totalValue + aceCount;
    }
}
