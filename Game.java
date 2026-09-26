//1097512 - Abeer Abu Shiekah


import java.util.Scanner;
public class Game {
    private final Player player1;
    private final Player player2;
    private final Player currentPlayer;
    private final Player[] playerList;

    Game(Player player1, Player player2) {
        this.player1=player1;
        this.player2=player2;
        this.currentPlayer = player1;
        this.playerList = new Player[]{player1, player2};
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        registerPlayers(input);
        selectArenas(input);
        buildFleets();

        runBattle(input);
        displayStatistics();
    }

    //Methods
    private void registerPlayers(Scanner input) {
        System.out.println("Naval Fleet Battle Game");
        
        //Enter gamers details
        System.out.print("Enter Player 1's Name: ");
        String name1 = input.nextLine();
        Player player1 = new Player(name1);

        System.out.println("Enter Player 2's Name: ");
        String name2 = input.nextLine();
        Player player2 = new Player(name2);

    }
    
    //After Arenas Class is Completed Come Back to It
    private void selectArenas(Scanner input) {
        System.out.println("\nChoose arena:");
        System.out.println("1. Preset Arena");
        System.out.println("2. Random Arena");
        System.out.print("Choice of arena: ");
        int choice = input.nextInt();

    } 


    private void buildFleets() {
        for(int i=0; i<playerList.length; i++) {
            Player player = playerList[i];

            //Creae ships. Add more ships when all ship subclasses are made. 
            Ship battleship = new Battleship();
            
            //Add ships to fleet. Add more ships when all ship subclasses are made
            player.addShip(battleship);

            //Place ships randomly. Wait till arena class is completed

        }
    }

    //Wait till arenas are completed
    public void runBattle(Scanner input) {

    }
    
    public void displayStatistics() {
        System.out.println("\n========== FINAL STATISTICS ==========");
        for(int i=0; i<playerList.length; i++) {
            playerList[i].displayStatistics();
        }
    }
}
