import java.util.ArrayList;

//INCOMPLETE

public abstract class ship {
    private final String name;
    private final int size;
    private int health;
    private final ArrayList<coordinate> position;
    private final ArrayList<coordinate> hits;


    public ship(String name, int size){
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

    public ArrayList<coordinate> getPosition(){
        return new ArrayList<>(position);
    }

    public void addPosition(coordinate coordinate){
        position.add(coordinate);
    }

    public boolean occupies(coordinate coordinate){
        return position.contains(coordinate);
    }

    public final String recieveHit(coordinate coordinate){
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
