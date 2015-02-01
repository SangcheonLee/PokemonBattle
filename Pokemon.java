import java.util.*;

/** ALL LEVELS ARE 100 **/

public class Pokemon
{
     private String name;
     private Type type1;
     private Type type2;
     private String statCondition = "";
     private boolean alive = true;
     private int health, ATK, DEF, SPA, SPD, Speed;
     private ArrayList<Move> moves;
     private int BattleHealth, BattleATK, BattleDEF, BattleSPA, BattleSPD, BattleSpeed;
     private int CurrentHealth;
     private int immobilizeCount;
     
     public Pokemon(String n, Type t1, Type t2, int hp, int attack, int defense, int spattack, int spdefense, int speed, ArrayList m)
     {
         name = n;
         type1 = t1;
         type2 = t2;
         health = hp;
         ATK = attack;
         DEF = defense;
         SPA = spattack;
         SPD = spdefense;
         Speed = speed;
         moves = m;
         BattleHealth = (((2 * health) * (100 / 100)) + 100 + 10);
         BattleATK = (((2 * ATK) * (100 / 100)) + 5);
         BattleDEF = (((2 * DEF) * (100 / 100)) + 5);
         BattleSPA = (((2 * SPA) * (100 / 100)) + 5);
         BattleSPD = (((2 * SPD) * (100 / 100)) + 5);
         BattleSpeed = (((2 * Speed) * (100 / 100)) + 5);
         CurrentHealth = BattleHealth;
     }

     public void assignSpeed()
     {
         for (int i = 0; i < moves.size(); i++)
         {
              moves.get(i).assignTempSpeed(BattleSpeed);
         }
     }
     
     public boolean incrementCount()
     {
         immobilizeCount++;
         
         if (immobilizeCount < 2)
         {
               System.out.println(name + " is " + statCondition);
               return false;
         }
         else
         {
             System.out.println(name + " is no longer " + statCondition);
             statCondition = "";
             immobilizeCount = 0;
             return true;
         }
     }
     
     public int getCurrentHealth()
     {
         return CurrentHealth;
     }
     
     public void subtractHealth(int damage)
     {
         CurrentHealth = CurrentHealth - damage;
         
         if (CurrentHealth <= 0)
         {
             alive = false;
         }
     }
     
     public void setCurrentHealth(int newHealth)
     {
         CurrentHealth = newHealth;
     }
     
     public int getBattleHealth()
     {
         return BattleHealth;
     }
     
     public int getBattleATK()
     {
         return BattleATK;
     }
     
     public int getBattleDEF()
     {
         return BattleDEF;
     }
     
     public int getBattleSPA()
     {
         return BattleSPA;
     }
     
     public int getBattleSPD()
     {
         return BattleSPD;
     }
     
     public int getBattleSpeed()
     {
         return BattleSpeed;
     }
     
     public ArrayList<Move> getMoves()
     {
         return moves;
     }
     
     public String getName()
     {
         return name;
     }
     
     public Type getType1()
     {
         return type1;
     }
     
     public Type getType2()
     {
         return type2;
     }
     
     /** Making a Pokemon use a move**/
     public int getMoveDamage(Move BattleMove, Pokemon otherPokemon)
     {
        int RandomNumber = (int)(Math.random() * 16) + 85;
        double Modifier = 1;
        double initialDamage = 0.0;
        double STAB = 1;
        
        //STAB
        if (this.getType1().toString().equals(BattleMove.getType().toString()) || this.getType2().toString().equals(BattleMove.getType().toString()))
        {
            STAB = 1.5;
        }
        
        if (this.getName() != "None")
        {
            System.out.println(this.getName() + " used " + BattleMove.getName());
        }
        
        //Damage Modifier
        Modifier = (BattleMove.getType().damageModifier(otherPokemon.getType1()) * BattleMove.getType().damageModifier(otherPokemon.getType2()));
        ModifierMessages.printMessage(Modifier);
        
        //Move Damage
        if (BattleMove.getPhysicalOrSpecial().equals("Physical"))
        {
            initialDamage = ((((2 * 100 / 5 + 2) * BattleATK * BattleMove.getBaseDamage() / otherPokemon.getBattleDEF()) / 50) + 2) * STAB * Modifier * RandomNumber / 100.0;
        }
        else if (BattleMove.getPhysicalOrSpecial().equals("Special"))
        {
            initialDamage = ((((2 * 100 / 5 + 2) * BattleSPA * BattleMove.getBaseDamage() / BattleSPD) / 50) + 2) * STAB * Modifier * RandomNumber / 100.0;
        }
        
        return (int)(initialDamage);
     }
     
     public String getStatCondition()
     {
         return statCondition;
     }
     
     public boolean getAlive()
     {
         return alive;
     }
     
     public void setStatCondition(String newStat)
     {
         statCondition = newStat;
     }
     
     public String toString()
     {
         String moveList = "";
         
         for (int a = 0; a < moves.size(); a++)
         {
              moveList += moves.get(a).getName();
              
              if (a != 3)
              {
                  moveList += ", ";
              }
         }
         
         String returnString = name + " | " + "Type: " + type1.toString();
         
         if (type2.toString().equals("None") == false)
         {
             returnString += ", " + type2.toString();
         }
         
         returnString += " / Health: " + health + ", Attack: " + ATK + ", Defense: " + DEF + ", SpecialAttack: " + SPA + ", SpecialDefense: " + SPD + ", Speed: " + Speed + "\n\t";
         returnString += name + "'s Moves: " + moveList;
         
         return returnString;
     }
     
     public void statConditionTest(Move enemyMove)
     {
         boolean success = false;
         
         int percent = enemyMove.getStatChance();
         
         if (percent == 0)
         {
             return;
         }
         if (statCondition != "")
         {
             System.out.println("This Pokemon is already " + statCondition);
             System.out.println();
             return;
         }
         
         int test = (int) (Math.random() * 100 + 1);
         
         String type = enemyMove.getType().toString();
         
         if (test <= percent)
         {
            success = true;
         }
         
         if (success == true)
         {
             if (type.equals("Fire"))
             {
                 if  (!type1.getName().equals("Fire") && !type2.getName().equals("Fire"))
                 {
                    statCondition = "Burned";
                    BattleATK = BattleATK / 2;
                }
                else
                {
                    success = false;
                    return;
                }
             }
             else if (type.equals("Electric"))
             {
                 if (!type1.getName().equals("Ground") && !type2.getName().equals("Ground"))
                 {
                    statCondition = "Paralyzed";
                    BattleSpeed = BattleSpeed / 2;
                }
                else
                {
                    success = false;
                    return;
                }
             }
             else if (type.equals("Ice"))
             {
                 if (!type1.getName().equals("Ice") && !type2.getName().equals("Ice"))
                 {
                    statCondition = "Frozen";
                }
                else
                {
                    success = false;
                    return;
                }
             }
             else if (type.equals("Poison"))
             {
                 if (!(type1.getName().equals("Poison") || type2.getName().equals("Poison")) || (type1.getName().equals("Steel") || type2.getName().equals("Steel")))
                 {  
                    statCondition = "Poisoned";
                }
                else
                {
                    success = false;
                    return;
                }
             }
             else
             {
                 statCondition = "Asleep";
             }
         }         
     }
}
