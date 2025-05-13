public class Genius extends Player{
    
    public Genius(String name){
        super(name);
    }

/**
 * Genius Stratagy:
 * Prioritize eights
 * Play the card with the highest rank
 * If no match, draw cards untill a match is found
 */
    @Override
    public Card play(Eights eights, Card prev){
        //look for eight
        Card card = searchForHighestMatch(prev);
        if(card == null){
            card = drawForMatch(eights, prev);
        }
        return card;

  

    }

    public Card searchForHighestMatch(Card prev){
        Card bestMatch = null;
        for(int a = 0; a < getHand().size(); a++){
            Card card = getHand().getCard(a);
            if(cardMatches(card, prev) && (bestMatch == null || card.getRank() > bestMatch.getRank())){
                    bestMatch = card;
                }
            
        }
        if(bestMatch != null){
            getHand().removeCard(bestMatch);
        }
        return bestMatch;
    }





}
