import java.util.ArrayList;

//INCOMPLETE. STILL NEEDS WORK

public abstract class Ship {
    private String name;
    private int size;
    private int health;
    private ArrayList<Coordinate> position;
    private ArrayList<Coordinate> hits;


    public Ship(String name, int size){
        this.name = name;
        this.size = size;
        this.health = size;
        this.position = new ArrayList<>();
        this.hits = new ArrayList<>();
    }


    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }

    public int getHealth(){
        return health;
    }


    public boolean Sunk(){
        return health <= 0;
    }

    public ArrayList<Coordinate> getPosition(){
        return new ArrayList<>(position);
    }

    public void addPosition(Coordinate coordinate){
        position.add(coordinate);
    }

    public boolean occupies(Coordinate coordinate){
        return position.contains(coordinate);
    }

    public final String recieveHit(Coordinate coordinate){
        if (!occupies(coordinate)){
            return "missed";
        }

        if (hits.contains(coordinate)){
            return "already shot";
        }

        hits.add(coordinate);

        if (specialAbilityOnHit()) {
            return Sunk() ? "sunk" : "hit";
        }


        health--;

        return Sunk() ? "sunk" : "hit";
    }

    protected abstract boolean specialAbilityOnHit();


    public abstract String getSpecialAbility();


    @Override
    public String toString() {
        return name + "(health: " + health + 
        "/" + size + ")";
    }


}
