public class Battleship extends Ship{
    private boolean armorUsed;

    public Battleship(){
        super("battleship", 4);
        armorUsed = false;
    }

    @Override
    public String getSpecialAbility() {
        return "Special Ability";
    }

    @Override
    public boolean specialAbilityOnHit() {
        return true;
    }


}
