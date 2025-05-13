import java.util.Scanner;
import java.util.ArrayList;

/**
 * Simulates a game of Crazy Eights.
 * See https://en.wikipedia.org/wiki/Crazy_Eights.
 */
public class Eights {

    private ArrayList<Player> players;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;
    private int currentPlayerIdx;

    /**
     * Initializes the state of the game.
     */
    public Eights(int numberofPlayers) {
        Deck deck = new Deck("Deck");
        deck.shuffle();
        
        players = new ArrayList<>();

        // deal cards to each player
        for(int i = 1; i <= numberofPlayers; i++){
            Player player = new Player("Player " + i);
            players.add(player);
            deck.deal(player.getHand(), 5);
        }

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        // create the scanner we'll use to wait for the user
        in = new Scanner(System.in);
        currentPlayerIdx = 0;
    }

    /**
     * Returns true if either hand is empty.
     */
    public boolean isDone() {
        for(Player player : players){
            if(player.getHand().isEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * Moves cards from the discard pile to the draw pile and shuffles.
     */
    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    /**
     * Returns a card from the draw pile.
     */
    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switches players.
     */
    public Player nextPlayer() {
        currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
        return players.get(currentPlayerIdx);
    }

    /**
     * Displays the state of the game.
     */
    public void displayState() {
        for(Player player : players){
            player.display();
        }
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
        in.nextLine();
    }

    /**
     * One player takes a turn.
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.lastCard();
        Card next = player.play(this, prev);

        if(next != null){
            discardPile.addCard(next);
            System.out.println(player.getName() + " plays " + next);
        }else{
            System.out.println(player.getName() + " cannot play this turn.");
        }
        System.out.println();
    }

    /**
     * Plays the game.
     */
    public void playGame() {
        

        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            Player currentPlayer = players.get(currentPlayerIdx);
            takeTurn(currentPlayer);
            nextPlayer();
        }

        // display the final score
        for(Player player : players){
            player.displayScore();
        }
    }

    /**
     * Creates the game and runs it.
     */
    public static void main(String[] args) {
        int numberOfPlayers = 4;
        Eights game = new Eights(numberOfPlayers);
        game.playGame();
    }

    public Hand getDrawPile() {
        return drawPile;
    }

    public Hand getDiscardPile() {
        return discardPile;
    }

}
