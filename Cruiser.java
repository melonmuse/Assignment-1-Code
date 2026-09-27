public class Cruiser extends Ship{
    public Cruiser(){
        super("Cruiser", 3);
    }

    @Override 
    public String getSpecialAbility(){
        return "reinforced hull: standard damage resistance.";
    }

    @Override 
    protected boolean specialAbilityOnHit(){
        return false;
    }
}
