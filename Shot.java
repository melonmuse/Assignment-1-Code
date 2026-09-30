public class Shot {

    private Coordinate coordinate;
    private String result;

    public Shot(Coordinate coordinate, String result) {
        this.coordinate = coordinate;
        this.result = result;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getResult() {
        return result;
    }

    public String toString() {
        return coordinate + " - " + result;
    }
}