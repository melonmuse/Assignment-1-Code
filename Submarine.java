public class Submarine extends Ship {
    private boolean stealthUsed;

    public Submarine(){
        super("Submarine", 2);
        stealthUsed = false;
    }

    @Override 
    public String getSpecialAbility(){
        return "stealth: the first successful attack is evaded.";
    }

    @Override protected boolean specialAbilityOnHit(){
        if (!stealthUsed){
            stealthUsed = true;
            return true;
        }
        return false;
    }
}
