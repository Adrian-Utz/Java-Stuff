public class EightsCard extends Card {
    
    
    public EightsCard(int rank, int suit){
        super(rank, suit);
    }

    public boolean match(EightsCard other){
        if(other == null){
            return false;
        }
        return this.getSuit() == other.getSuit()
            || this.getRank() == other.getRank()
            || this.getRank() == 8;
    }

    public int scoreCard(){
        int rank = getRank();
        if(rank == 8){
            return -20;
        }else if(rank > 10){
            return -10;
        }else{
            return -rank;
        }
    }

}
