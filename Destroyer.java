public class Destroyer extends Ship {
    public Destroyer(){
        super("Destroyer", 3);
    }

    @Override 
    public String getSpecialAbility(){
        return "rapid fire: designed fro fast attacks.";
    }

    @Override 
    protected boolean specialAbilityOnHit(){
        return false;
    }
}
