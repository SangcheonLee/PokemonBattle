import java.util.*;

public class Move implements Comparable<Move>
{
     private String name;
     private int baseDamage;
     private int accuracy;
     private Type type;
     private String PhysOrSpec;
     private int statChance;
     private int Priority;
     private int tempSpeed;
     
     public Move(String n, int d, int a, Type t, String PoS, int sc, int priority)
     {
         name = n;
         baseDamage = d;
         accuracy = a;
         type = t;
         PhysOrSpec = PoS;
         statChance = sc;
         Priority = priority;
     }
     
     public String getName()
     {
         return name;
     }
     
     public boolean getHitOrMiss()
     {
         int chance = (int)(Math.random() * 100);
         
         if (chance <= accuracy)
         {
             return true;
         }
         else
         {
             return false;
         }
     }
     
     public int getStatChance()
     {
         return statChance;
     }
     
     public int getPriority()
     {
         return Priority;
     }
     
     public String getPhysicalOrSpecial()
     {
         return PhysOrSpec;
     }
     
     public int getBaseDamage()
     {
         return baseDamage;
     }
     
     public Type getType()
     {
         return type;
     }
     
     public void assignTempSpeed(int s)
     {
         tempSpeed = s;
     }
     
     public int getTempSpeed()
     {
         return tempSpeed;
     }
     
     public String toString()
     {
         return name + " | Type: " + type.toString() + ", Damage: " + baseDamage + ", Accuracy: " + accuracy + ", Chance of Causing Status Condition: " + statChance + ", Priority: " + Priority ;
     }
     
     public int compareTo(Move other)
     {
         if (this.getPriority() > other.getPriority())
         {
             return -1;
         }
         else if (this.getPriority() < other.getPriority())
         {
             return 1;
         }
         else
         {
             if (this.getTempSpeed() > other.getTempSpeed())
             {
                 return -1;
             }
             else if (this.getPriority() < other.getTempSpeed())
             {
                 return 1;
             }
             else
             {
                 double prob = Math.random() * 100 + 1;
                 
                 if (prob < 51)
                 {
                     return -1;
                 }
                 else
                 {
                     return 1;
                 }
             }  
         }
     }
}
