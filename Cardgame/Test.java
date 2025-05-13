/**
 * Test code for Deck and Hand.
 */
public class Test {

    public static void main(String[] args) {
        int strategicPlayerWins = 0;
        int geniusPlayerWins = 0;

        //Simulate 100 games
        for(int game = 0; game < 100; game++){
            Eights gameInstance = new Eights(4);

            //Create two players
            StrategicPlayer player1 = new StrategicPlayer("Strategic Player");
            Genius player2 = new Genius("Genius Player");

            //One game Round
            Player winner = playGame(player1, player2, gameInstance);

            //Track wins
            if(winner == player1){
                strategicPlayerWins++;
            }else if(winner == player2){
                geniusPlayerWins++;
            }

            System.out.println("Strategic Player Wins: " + strategicPlayerWins);
            System.out.println("Genius Player Wins: " + geniusPlayerWins);
        }

        System.out.println("After 100 games:");
        System.out.println("Strategic Player Wins: " + strategicPlayerWins);
        System.out.println("Genius Player Wins: " + geniusPlayerWins);
    }

    public static Player playGame(Player player1, Player player2, Eights gameInstance){
        Card prevCard = gameInstance.getDiscardPile().lastCard();

        while(!player1.getHand().isEmpty() && !player2.getHand().isEmpty()){
            Card card1 = player1.play(gameInstance, prevCard);
            prevCard = card1;

            if(!player1.getHand().isEmpty()){
                Card card2 = player2.play(gameInstance, prevCard);
                prevCard = card2;
            }
        }

        if(player1.getHand().isEmpty()){
            return player1;
        }else{
            return player2;
        }
    }

}
