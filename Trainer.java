import java.util.*;

public class Trainer
{
    ArrayList<Pokemon> Pokemons = new ArrayList<Pokemon>();
    int PlayerNumber;
    public boolean moveMade = false;

    public Trainer(ArrayList<Pokemon> p, int PN)
    {
        Pokemons = p;
        PlayerNumber = PN;
    }
    
    public void setCurrentPokemon(Pokemon newCurrent)
    {
        int n = Pokemons.indexOf(newCurrent);
        
        Pokemons.set(n, Pokemons.get(0));
        Pokemons.set(0, newCurrent);
    }
    
    public Pokemon getCurrentPokemon()
    {
        return Pokemons.get(0);
    }
    
    public Pokemon removePokemon(Pokemon temp)
    {
        int n = Pokemons.indexOf(temp);
        
        return Pokemons.remove(n);
    }
    
    public Pokemon removePokemon(int a)
    {
        return Pokemons.remove(a);
    }
    
    public Pokemon getPokemon(int a)
    {
        return Pokemons.get(a);
    }
    
    public int getSize()
    {
        return Pokemons.size();
    }
    
    public int getPlayerNumber()
    {
        return PlayerNumber;
    }
    
    public boolean isEmpty()
    {
        return Pokemons.isEmpty();
    }
}
