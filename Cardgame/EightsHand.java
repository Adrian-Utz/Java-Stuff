public class EightsHand extends Hand{
    
    
    public EightsHand(String label){
        super(label);
    }  
    
    public int scoreHand(){
        int sum = 0;
        for(int i = 0; i < size(); i++){
            EightsCard card = (EightsCard) getCard(i);
            sum += card.scoreCard();
        }
        return sum;
    }


}
