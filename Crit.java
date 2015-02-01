public class Crit
{
    public int critDamage(int damage)
    {
        double prob = Math.random() * 100;
        
        if (prob <= 6.25)
        {
            System.out.println("A critical hit");
            damage = damage * 2;
        }
        
        return damage;
    }
}
