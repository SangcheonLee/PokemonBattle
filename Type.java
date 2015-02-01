import java.util.*;

public class Type
{
    String typeName;

    public Type(String name)
    {
        typeName = name;
    }
    
    public String getName()
    {
        return typeName;
    }
    
    public double damageModifier(Type t2)
    {
         String Type1 = this.toString();
         String Type2 = t2.toString();
         double modifier = 1;
        
         if (Type1.equals("Fire"))
         {
             if (Type2.equals("Ice") || Type2.equals("Grass") || Type2.equals("Bug") || Type2.equals("Steel"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Water") || Type2.equals("Rock") || Type2.equals("Fire") || Type2.equals("Dragon"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Water"))
         {
             if (Type2.equals("Fire") || Type2.equals("Rock") || Type2.equals("Ground"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Water") || Type2.equals("Grass") || Type2.equals("Dragon"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Grass"))
         {
             if (Type2.equals("Water") || Type2.equals("Ground") || Type2.equals("Rock"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Fire") || Type2.equals("Grass") || Type2.equals("Flying") || Type2.equals("Poison") || Type2.equals("Bug") || Type2.equals("Steel") || Type2.equals("Dragon"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Normal"))
         {
             if (Type2.equals("Steel") || Type2.equals("Rock"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Ghost"))
             {
                modifier = 0;
             }
         }
         else if (Type1.equals("Fighting"))
         {
             if (Type2.equals("Rock") || Type2.equals("Normal") || Type2.equals("Steel") || Type2.equals("Dark") || Type2.equals("Ice"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Bug") || Type2.equals("Psychic") || Type2.equals("Flying") || Type2.equals("Poison"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Ghost"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Dragon"))
         {
             if (Type2.equals("Dragon"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Steel"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Ghost"))
         {
             if (Type2.equals("Ghost") || Type2.equals("Psychic"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Dark") || Type2.equals("Steel"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Normal"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Psychic"))
         {
             if (Type2.equals("Fighting") || Type2.equals("Poison"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Psychic") || Type2.equals("Steel"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Dark"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Dark"))
         {
             if (Type2.equals("Ghost") || Type2.equals("Psychic"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Fighting") || Type2.equals("Dark") || Type2.equals("Steel"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Electric"))
         {
             if (Type2.equals("Flying") || Type2.equals("Water"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Electric") || Type2.equals("Grass") || Type2.equals("Dragon"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Ground"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Poison"))
         {
             if (Type2.equals("Grass"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Poison") || Type2.equals("Ground") || Type2.equals("Rock") || Type2.equals("Ghost"))
             {
                 modifier = .5;
             }
             else if (Type2.equals("Steel"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Ice"))
         {
             if (Type2.equals("Grass") || Type2.equals("Dragon") || Type2.equals("Ground") || Type2.equals("Flying"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Ice") || Type2.equals("Water") || Type2.equals("Fire") || Type2.equals("Steel"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Ground"))
         {
             if (Type2.equals("Poison") || Type2.equals("Rock") || Type2.equals("Steel") || Type2.equals("Fire") || Type2.equals("Electric"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Bug") || Type2.equals("Grass")) 
             {
                 modifier = .5;
             }
             else if (Type2.equals("Flying"))
             {
                 modifier = 0;
             }
         }
         else if (Type1.equals("Bug"))
         {
             if (Type2.equals("Grass") || Type2.equals("Dark") || Type2.equals("Psychic"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Steel") || Type2.equals("Ghost") || Type2.equals("Flying") || Type2.equals("Fire") || Type2.equals("Fighting") || Type2.equals("Poison"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Flying"))
         {
             if (Type2.equals("Fighting") || Type2.equals("Bug") || Type2.equals("Grass"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Steel") || Type2.equals("Rock") || Type2.equals("Electric"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Rock"))
         {
             if (Type2.equals("Fire") || Type2.equals("Bug") || Type2.equals("Ice") || Type2.equals("Flying"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Fighting") || Type2.equals("Ground") || Type2.equals("Steel"))
             {
                 modifier = .5;
             }
         }
         else if (Type1.equals("Steel"))
         {
             if (Type2.equals("Rock") || Type2.equals("Ice"))
             {
                 modifier = 2;
             }
             else if (Type2.equals("Steel") || Type2.equals("Water") || Type2.equals("Fire") || Type2.equals("Electric"))
             {
                 modifier = .5;
             }
         }
         else
             modifier = 1;
         
         return modifier;     
    }
    
    public String toString()
    {
        return typeName;
    }
}
