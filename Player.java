import java.util.ArrayList;
public class Player {
    
    //Initialize Player Information
    private final int playerID;
    private final String playerName;
    private final ArrayList<Ship> fleet;
    private final ArrayList<Coordinate> shotHistory;
    private int shotsFired;
    private int hits;
    private int misses;
    private int shipsSunk;
    private int wins;
    private int losses;

    //Constructor 
    public Player(int playerId, String playerName) {
        this.playerID = playerId;
        this.playerName = playerName;

        fleet = new ArrayList<>();
        shotHistory = new ArrayList<>();

        shotsFired = 0;
        hits = 0;
        misses = 0;
        shipsSunk = 0;
        wins = 0;
        losses = 0;
    }


    //Generate Getters for Private Fields
    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Ship> getFleet() {
        return fleet;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    //Methods
    public void addShip(Ship ship) {
        fleet.add(ship);
    }
    
    public void recordShot(Coordinate coordinate) {
        if (!shotHistory.contains(coordinate)) {
            shotHistory.add(coordinate);
            shotsFired++;
        }
    }
    
        public void recordHit() {
        hits++;
    }

    public void recordMiss() {
        misses++;
    }

    public void recordSunk() {
        shipsSunk++;
    }

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public double getAccuracy() {
        if (shotsFired == 0) {
            return 0.0;
        }
        return (hits * 100.0) / shotsFired;
    }

    public boolean allShipsSunk() {
        for (Ship ship : fleet) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
    
    public int remainingShips() {
        int count = 0;
        for (Ship ship : fleet) {
            if (!ship.isSunk()) {
                count++;
            }
        }
        return count;
    }

    public void displayStatistics() {
        System.out.println("Player ID: " + getPlayerID());
        System.out.println("Player Name: " + getPlayerName());
        System.out.println("Shots Fired: " + getShotsFired());
        System.out.println("Hits: " + getHits());
        System.out.println("Ships Sunk: " + getShipsSunk());
        System.out.println("Wins: " + getWins());
        System.out.println("Losses: " + getLosses());
        System.out.println("Accuracy: " + "%");
    }

}