public class testsecond {

    public static void main(String[] args){
        EightsCard card1 = new EightsCard(8, 1);
        EightsCard card2 = new EightsCard(5, 3);
        EightsCard card3 = new EightsCard(12, 2);
        EightsCard card4 = new EightsCard(8, 0);
        EightsCard card5 = new EightsCard(3, 1);
        EightsCard card6 = new EightsCard(10, 2);

        System.out.println("Testing. . .");
        System.out.println("Card Matching:");
        System.out.println(card1.match(card2));
        System.out.println(card3.match(card4));
        System.out.println(card5.match(card6));


        EightsHand hand = new EightsHand("Player hand");
        hand.addCard(card6);
        hand.addCard(card1);
        hand.addCard(card5);
        hand.addCard(card3);

        System.out.println("\nTesting scoreHand Method . . .");
        System.out.println("Total: " + hand.scoreHand());

        System.out.println("\nCards in hand:");
        for(int i = 0; i< hand.size(); i++){
            System.out.println(hand.getCard(i));
        }
    }
    
}
