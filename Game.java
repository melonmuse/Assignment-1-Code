public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private boolean gameOver;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        currentPlayer = player1;
        gameOver=false;

    }

    //Getters and Setters for Private Fields
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    //Methods 
    public void switchTurns() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void checkFleets() {

    if (player1.getFleet().isEmpty()) {

        gameOver = true;

        player2.updateStats(false, false, false, true, false);
        player1.updateStats(false, false, false, false, true);

        System.out.println("The winner is: " + player2.getPlayerID());
    }

    else if (player2.getFleet().isEmpty()) {

        gameOver = true;

        player1.updateStats(false, false, false, true, false);
        player2.updateStats(false, false, false, false, true);

        System.out.println("The winner is: " + player1.getPlayerID());
    }
}

    public void displayPerformance() {

        System.out.println("\n===== PLAYER 1 STATISTICS =====");
        player1.displayPerformance();

        System.out.println("\n===== PLAYER 2 STATISTICS =====");
        player2.displayPerformance();
    }
public void startGame() {

        System.out.println("================================");
        System.out.println("     NAVAL FLEET BATTLE");
        System.out.println("================================");

        System.out.println("Player 1: " + player1.getPlayerID());
        System.out.println("Player 2: " + player2.getPlayerID());

        System.out.println("\nGame started!");
        System.out.println("Current player: "
                + currentPlayer.getPlayerID());
    }

}
