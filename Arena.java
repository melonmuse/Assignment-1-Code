import java.util.ArrayList;

public class Arena {

    private char[][] grid;

    private ArrayList<Coordinate> rocks;

    private ArrayList<Ship> ships;

    private ArrayList<Shot> shots;

    public Arena() {

        grid = new char[10][10];

        rocks = new ArrayList<Coordinate>();

        ships = new ArrayList<Ship>();

        shots = new ArrayList<Shot>();

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                grid[row][column] = '.';
            }
        }
    }

    private boolean validPosition(int row, int column) {

        if (row < 0 || row >= 10) {
            return false;
        }

        if (column < 0 || column >= 10) {
            return false;
        }

        return true;
    }

    public boolean addRock(int row, int column) {

        if (!validPosition(row, column)) {
            return false;
        }

        if (grid[row][column] != '.') {
            return false;
        }

        grid[row][column] = 'R';

        Coordinate rock = new Coordinate(row, column);

        rocks.add(rock);

        return true;
    }

    public boolean placeShip(Ship ship) {

        ArrayList<Coordinate> positions = ship.getPosition();

        for (Coordinate coordinate : positions) {

            int row = coordinate.getRow();
            int column = coordinate.getColumn();

            if (!validPosition(row, column)) {
                return false;
            }

            if (grid[row][column] == 'R') {
                return false;
            }

            if (grid[row][column] == 'S') {
                return false;
            }
        }

        for (Coordinate coordinate : positions) {

            int row = coordinate.getRow();
            int column = coordinate.getColumn();

            grid[row][column] = 'S';
        }

        ships.add(ship);

        return true;
    }

    private boolean alreadyShot(int row, int column) {

        for (Shot shot : shots) {

            Coordinate coordinate = shot.getCoordinate();

            if (coordinate.getRow() == row &&
                coordinate.getColumn() == column) {

                return true;
            }
        }

        return false;
    }

    private Coordinate findShipCoordinate(Ship ship, int row, int column) {

        ArrayList<Coordinate> positions = ship.getPosition();

        for (Coordinate coordinate : positions) {

            if (coordinate.getRow() == row &&
                coordinate.getColumn() == column) {

                return coordinate;
            }
        }

        return null;
    }

    public String shoot(int row, int column) {

        if (!validPosition(row, column)) {
            return "INVALID";
        }

        if (alreadyShot(row, column)) {
            return "ALREADY SHOT";
        }

        Coordinate shotCoordinate = new Coordinate(row, column);

        if (grid[row][column] == 'R') {

            Shot shot = new Shot(shotCoordinate, "BLOCKED");

            shots.add(shot);

            return "BLOCKED";
        }

        for (Ship ship : ships) {

            Coordinate shipCoordinate =
                    findShipCoordinate(ship, row, column);

            if (shipCoordinate != null) {

                String result = ship.recieveHit(shipCoordinate);

                grid[row][column] = 'X';

                Shot shot = new Shot(shotCoordinate, result.toUpperCase());

                shots.add(shot);

                if (result.equals("sunk")) {
                    return "SUNK";
                }

                if (result.equals("hit")) {
                    return "HIT";
                }

                if (result.equals("already shot")) {
                    return "ALREADY SHOT";
                }
            }
        }

        grid[row][column] = 'O';

        Shot shot = new Shot(shotCoordinate, "MISS");

        shots.add(shot);

        return "MISS";
    }

    public void display() {

        System.out.println();

        System.out.print("   ");

        for (int column = 0; column < 10; column++) {
            System.out.print(column + " ");
        }

        System.out.println();

        for (int row = 0; row < 10; row++) {

            System.out.print(row + "  ");

            for (int column = 0; column < 10; column++) {

                System.out.print(grid[row][column] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public ArrayList<Coordinate> getRocks() {
        return rocks;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }
}