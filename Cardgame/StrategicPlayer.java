

public class StrategicPlayer extends Player {
    
    public StrategicPlayer(String name){
        super(name);
    }


    /**
     * Overrides the play method
     * The player tries to play an eight first, then the highest ranking card.
     */
    @Override
    public Card play(Eights eights, Card prev){
        Card card = searchForMatch(prev);
        if(card == null){
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    public Card searchForEight(){
        for(int a = 0; a < getHand().size(); a++){
            Card card = getHand().getCard(a);
            if(card.getRank() == 8){
                return getHand().popCard(a);
            }
        }
        return null;
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
