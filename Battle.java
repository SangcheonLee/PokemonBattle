import java.util.*;

public class Battle
{
    boolean p1win = false;
    boolean p2win = false;
    Move Poke1 = null;
    Move Poke2 = null;
    boolean poke1Miss = false;
    boolean poke2Miss = false;
    boolean pokemonFainted = false;
    Trainer player1;
    Trainer player2;
    PriorityQueue<Move> moveOrder = new PriorityQueue<Move>(2);
    Crit critical = new Crit();
    Scanner scan = new Scanner(System.in);
    
    public Battle(Trainer p1, Trainer p2)
    {
        player1 = p1;
        player2 = p2;
    }
    
    public void PokemonStart()
    {
        while (p1win == false && p2win == false)
        {
            Poke1 = null;
            Poke2 = null;
            
            /** Choosing for Player 1**/
            for (int i = 0; i < player1.getSize(); i++)
            {
                System.out.println(player1.getPokemon(i).getName() + " | HP: " + player1.getPokemon(i).getCurrentHealth() + " / " + player1.getPokemon(i).getBattleHealth());
            }
            System.out.println("Player 1, will you Battle or Switch?");
            String response1 = scan.nextLine().toUpperCase();
            System.out.println();
            
            while (!response1.equals("BATTLE") && !response1.equals("SWITCH"))
            {
                System.out.println("Try Again");
                System.out.println("Player 1, will you Battle or Switch?");
                response1 = scan.nextLine().toUpperCase();
                System.out.println();
            }
            
            /** Choosing for Player 2**/
            for (int i = 0; i < player2.getSize(); i++)
            {
                System.out.println(player2.getPokemon(i).getName() + " | HP: " + player2.getPokemon(i).getCurrentHealth() + " / " + player2.getPokemon(i).getBattleHealth());
            }
            System.out.println("Player 2, will you Battle or Switch?");
            String response2 = scan.nextLine().toUpperCase();
            System.out.println();
            
            while (!response2.equals("BATTLE") && !response2.equals("SWITCH"))
            {
                System.out.println("Try Again");
                System.out.println("Player 2, will you Battle or Switch?");
                response2 = scan.nextLine().toUpperCase();
                System.out.println();
            }
            
            if (response1.equals("SWITCH") && response2.equals("SWITCH"))
            {
                System.out.print('\f');
                PokemonSwitch(player1);
                System.out.print('\f');
                PokemonSwitch(player2);
            }
            else if (response1.equals("BATTLE") && response2.equals("SWITCH"))
            {
                System.out.print('\f');
                PokemonSwitch(player2);
                System.out.print('\f');
                PokemonBattle(player1);
            }
            else if (response1.equals("SWITCH") && response2.equals("BATTLE"))
            {
                System.out.print('\f');
                PokemonSwitch(player1);
                System.out.print('\f');
                PokemonBattle(player2);
            }
            else if (response1.equals("BATTLE") && response2.equals("BATTLE"))
            {
                System.out.print('\f');
                PokemonBattle(player1);
                System.out.print('\f');
                PokemonBattle(player2);
            }
            System.out.print('\f');
            
            //Adding moves to PriorityQueue
            //Finding out if Move's accuracy is good
            if (Poke1 != null)
            {
                if (Poke1.getHitOrMiss() == false)
                {
                    System.out.println(player1.getCurrentPokemon().getName() + "'s " + Poke1.getName() + " missed!");
                    System.out.println();
                    Poke1 = null;
                }
                else
                {
                    moveOrder.add(Poke1);
                }
            }
            if (Poke2 != null)
            {
                if (Poke2.getHitOrMiss() == false)
                {
                    System.out.println(player2.getCurrentPokemon().getName() + "'s " + Poke2.getName() + " missed!");
                    System.out.println();
                    Poke2 = null;
                }
                else
                {
                    moveOrder.add(Poke2);
                }
            }
            
            //Real Battling Part
            //pokemonFainted is when the 1st Pokemon faints the 2nd Pokemon. If pokemonFainted is true, the switched 2nd Pokemon should not attack
            for (int a = 0; a < moveOrder.size(); a++)
            {
                if (pokemonFainted == false)
                {
                    if (Poke1== Poke2)
                    {
                        if (player1.getCurrentPokemon().getBattleSpeed() >= player2.getCurrentPokemon().getBattleSpeed())
                        {
                            PokemonBattleDamage(player1, player2);
                            PokemonBattleDamage(player2, player1);
                            a--;
                        }
                        else
                        {
                            PokemonBattleDamage(player2, player1);
                            a--;
                            PokemonBattleDamage(player1, player2);
                            a--;
                        }
                    }
                    
                    if (moveOrder.peek() == Poke1)
                    {
                        PokemonBattleDamage(player1, player2);
                        a--;
                    }
                    else if (moveOrder.peek() == Poke2)
                    {
                        PokemonBattleDamage(player2, player1);
                        a--;
                    }
                }
                else
                {
                    break;
                }
            }
            
            //Poison and Burn Checks
            if (!player1.isEmpty() && !player2.isEmpty())
            {
                if (player1.getCurrentPokemon().getStatCondition().equals("Poisoned") || player1.getCurrentPokemon().getStatCondition().equals("Burned"))
                {
                    player1.getCurrentPokemon().subtractHealth((player1.getCurrentPokemon().getBattleHealth()) / 8);
                    System.out.println(player1.getCurrentPokemon().getName() + " is suffering damage from being " + player1.getCurrentPokemon().getStatCondition());
                    
                    //If Player1's Pokemon faints from Poison/Burn
                    if (player1.getCurrentPokemon().getCurrentHealth() <= 0)
                    {
                        System.out.println(player1.getCurrentPokemon().getName() + " | HP: 0 / " + player1.getCurrentPokemon().getBattleHealth());
                        System.out.println(player1.getCurrentPokemon().getName() + " has fainted!");
                        System.out.println();
                        
                        player1.removePokemon(0);
                        
                        if (player1.isEmpty() == false)
                        {
                            /** Switching in for Player 1 **/
                            System.out.println("Who will you switch in?");
                            for (int i = 0; i < player1.getSize(); i++)
                            {
                                System.out.println(player1.getPokemon(i).getName());
                            }
                            System.out.println();
                            String replace = scan.nextLine();
                            
                            boolean correctreplace = false;
                
                            while (correctreplace == false)
                            {
                                for (int i = 0; i < player1.getSize(); i++)
                                {
                                    if (replace.equals(player1.getPokemon(i).getName()))
                                    {
                                        player1.setCurrentPokemon(player1.getPokemon(i));
                                        correctreplace = true;
                                        System.out.println(player1.getCurrentPokemon().getName() + " has been sent out!");
                                        pokemonFainted = true;
                                    }
                                }
                           
                                if (correctreplace == false)
                                {
                                    System.out.println("Invalid entry");
                                    System.out.println("Capitalize the first letter and write the rest lowercase.");
                                    replace = scan.nextLine();
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            p2win = true;
                        }
                    }
                    else
                    {
                        System.out.println(player1.getCurrentPokemon().getName() + " | HP: " + player1.getCurrentPokemon().getCurrentHealth() + " / " + player1.getCurrentPokemon().getBattleHealth());
                    }
                }
                
                if (player2.getCurrentPokemon().getStatCondition().equals("Poisoned") || player2.getCurrentPokemon().getStatCondition().equals("Burned"))
                {
                    player2.getCurrentPokemon().subtractHealth((player2.getCurrentPokemon().getBattleHealth()) / 8);
                    System.out.println(player2.getCurrentPokemon().getName() + " is suffering damage from being " + player2.getCurrentPokemon().getStatCondition());
                     
                     //If Player2's Pokemon faints from Poison/Burn
                    if (player2.getCurrentPokemon().getCurrentHealth() <= 0)
                    {
                        System.out.println(player2.getCurrentPokemon().getName() + " | HP: 0 / " + player2.getCurrentPokemon().getBattleHealth());
                        System.out.println(player2.getCurrentPokemon().getName() + " has fainted!");
                        System.out.println();
                        
                        player2.removePokemon(0);
                        
                        if (player2.isEmpty() == false)
                        {
                            /** Switching in for Player 2 **/
                            System.out.println("Who will you switch in?");
                            for (int i = 0; i < player2.getSize(); i++)
                            {
                                System.out.println(player2.getPokemon(i).getName());
                            }
                            System.out.println();
                            String replace = scan.nextLine();
                            
                            boolean correctreplace = false;
                
                            while (correctreplace == false)
                            {
                                for (int i = 0; i < player2.getSize(); i++)
                                {
                                    if (replace.equals(player2.getPokemon(i).getName()))
                                    {
                                        player2.setCurrentPokemon(player2.getPokemon(i));
                                        correctreplace = true;
                                        System.out.println(player2.getCurrentPokemon().getName() + " has been sent out!");
                                        pokemonFainted = true;
                                    }
                                }
                           
                                if (correctreplace == false)
                                {
                                    System.out.println("Invalid entry");
                                    System.out.println("Capitalize the first letter and write the rest lowercase.");
                                    replace = scan.nextLine();
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            p1win = true;
                        }
                    }
                    else
                    {
                        System.out.println(player2.getCurrentPokemon().getName() + " | HP: " + player2.getCurrentPokemon().getCurrentHealth() + " / " + player2.getCurrentPokemon().getBattleHealth());
                    }
                }
            }
            
            //Restoring boolean variables to original state
            pokemonFainted = false;
            player1.moveMade = false;
            player2.moveMade = false;
            
            while (!moveOrder.isEmpty())
            {
                moveOrder.remove();
            }
            
            if (player1.isEmpty() == true && player2.isEmpty() == true)
            {
                p1win = true;
                p2win = true;
            }
            
            //Checking for wins
            if (p1win == true && p2win == true)
            {
                System.out.println("DRAW");
                break;
            }
            else if (p1win == true)
            {
                System.out.println("PLAYER 1 WINS");
                break;
            }
            else if (p2win == true)
            {
                System.out.println("PLAYER 2 WINS");
                break;
            }
            
            System.out.println("Ready for next turn? (Say Yes)");
            String response = scan.nextLine();
            
            if (response.equals("Yes"))
            {
                System.out.print('\f');
            }
            else
            {
                System.out.print('\f');
                System.out.println("Going anyway");
                System.out.println();
            }
        }
    }
    
    /** PokemonSwitch's parameter is the player**/
    /** Used for Switching Pokemon during battle **/
    public void PokemonSwitch(Trainer player)
    {
        boolean cancelSwitch = false;
        
        while (cancelSwitch == false)
        {
            System.out.println("Player " + player.getPlayerNumber() + ", which Pokemon will you switch in?");
            System.out.println("Type in the name of the same Pokemon in battle to cancel the switch");
                        
            for (int i = 0; i < player.getSize(); i++)
            {
                System.out.println(player.getPokemon(i).getName() + " | HP: " + player.getPokemon(i).getCurrentHealth() + " / " + player.getPokemon(i).getBattleHealth());
            }
            System.out.println();         
           
            String switchResponse = scan.nextLine();
            
            //If Player only has 1 Pokemon left
            if (player.getSize() == 1)
            {
                System.out.println("Going to Battle");
                System.out.println();
                PokemonBattle(player);
            }
            
            //Canceling Switch
            if (player.getPokemon(0).getName().equals(switchResponse))
            {
                cancelSwitch = true;
                
                System.out.println();
                System.out.println("Player " + player.getPlayerNumber() + ", will you Battle or Switch?");
                String response = scan.nextLine();
                System.out.println();
                
                if (response.equals("Battle"))
                {
                    PokemonBattle(player);
                    break;
                }
                else if (response.equals("Switch"))
                {
                    PokemonSwitch(player);
                    break;
                }
                
                System.out.print('\f');
            }
            else
            {
                boolean correctPoke = false;
                        
                while (correctPoke == false)
                {                   
                    for (int i = 1; i < player.getSize(); i++)
                    {
                        if (switchResponse.equals(player.getPokemon(i).getName()))
                        {
                            player.setCurrentPokemon(player.getPokemon(i));
                            correctPoke = true;
                            cancelSwitch = true;
                            
                            break;
                        }
                    }
                    
                    if (correctPoke == false)
                    {
                        System.out.println("Invalid entry");
                        System.out.println("Capitalize the first letter and write the rest lowercase.");
                        switchResponse = scan.nextLine();
                        System.out.println();
                    }
                }
            }
        }
        
        player.moveMade = true;
        System.out.println();
    }
    
    /** PokemonBattle's parameter is the player **/
    /** Used for getting the Battle moves **/
    public void PokemonBattle(Trainer player)
    {
        player1.getCurrentPokemon().assignSpeed();
        player2.getCurrentPokemon().assignSpeed();
        
        //Getting move for Player 1 if chose Battle
        if (player.moveMade == false && player.getPlayerNumber() == 1)
        {
            System.out.println(player.getCurrentPokemon());
            System.out.println("Player 2 uses " + player2.getCurrentPokemon().getName());
            System.out.println();
            
            System.out.println("Type in the name of the move you wish to use: ");
                        
            ArrayList<Move> currentMoves1 = player.getCurrentPokemon().getMoves();
                        
            String chosenMove1 = scan.nextLine();
                        
            boolean correctMove1 = false;
                       
            while (correctMove1 == false)
            {
                for (int i = 0; i < currentMoves1.size(); i++)
                {
                    if (currentMoves1.get(i).getName().equals(chosenMove1))
                    {
                        correctMove1 = true;
                        Poke1 = currentMoves1.get(i);
                        
                        break;
                    }
                }
                
                if (correctMove1 == false)
                {
                    System.out.println("Invalid move. Capitalize the first letter and lowercase the rest.");
                    chosenMove1 = scan.nextLine();
                }
            }
            
            if (player.getCurrentPokemon().getStatCondition().equals("Asleep") || player.getCurrentPokemon().getStatCondition().equals("Frozen"))
            {
                boolean restored1 = player.getCurrentPokemon().incrementCount();
                
                if (restored1 == false)
                {
                    System.out.println(player.getCurrentPokemon().getName() + " is Asleep/Frozen and can't move!");
                    Poke1 = null;
                }
            }
            
            if (player.getCurrentPokemon().getStatCondition().equals("Paralyzed"))
            {
                int ParalyzeTest = (int) (Math.random() * 100 + 1);
                
                if (ParalyzeTest <= 50)
                {
                    System.out.println(player.getCurrentPokemon().getName() + " is Paralyzed and can't move!");
                    Poke1 = null;
                }
            }
            
            player.moveMade = true;
        }
        
        //Getting move for Player 2 if chose Battle
        if (player.moveMade == false && player.getPlayerNumber() == 2)
        {
            System.out.println(player.getCurrentPokemon());
            System.out.println("Type in the name of the move you wish to use: ");
            System.out.println("Player 1 uses " + player1.getCurrentPokemon().getName());
            System.out.println();
                        
            ArrayList<Move> currentMoves2 = player.getCurrentPokemon().getMoves();
                        
            String chosenMove2 = scan.nextLine();
                        
            boolean correctMove2 = false;
                       
            while (correctMove2 == false)
            {
                for (int i = 0; i < currentMoves2.size(); i++)
                {
                    if (currentMoves2.get(i).getName().equals(chosenMove2))
                    {
                        correctMove2 = true;
                        Poke2 = currentMoves2.get(i);
                        
                        break;
                    }
                }
                
                if (correctMove2 == false)
                {
                    System.out.println("Invalid move. Capitalize the first letter and lowercase the rest.");
                    chosenMove2 = scan.nextLine();
                }
            }
            
            if (player.getCurrentPokemon().getStatCondition().equals("Asleep") || player.getCurrentPokemon().getStatCondition().equals("Frozen"))
            {
                boolean restored2 = player.getCurrentPokemon().incrementCount();
                
                if (restored2 == false)
                {
                    System.out.println(player.getCurrentPokemon().getName() + " is Asleep/Frozen and can't move!");
                    Poke2 = null;
                }
            }
            
            if (player.getCurrentPokemon().getStatCondition().equals("Paralyzed"))
            {
                int test = (int)(Math.random() * 100 + 1);
                
                if (test <= 50)
                {
                    System.out.println(player.getCurrentPokemon().getName() + " is Paralyzed and can't move!");
                    Poke2 = null;
                }
            }
            
            player.moveMade = true;
        }
    }
    
    /** PokemonBattleDamage's parameters are the Player and the otherTrainer **/
    /** Used to subtract health of moves **/
    /** Switch's Pokemons if otherTrainer's Pokemon faints **/
    public void PokemonBattleDamage(Trainer player, Trainer otherTrainer)
    {
        int Damage = 0;
        Pokemon thisCurrentPoke = player.getCurrentPokemon();
        Pokemon otherCurrentPoke = otherTrainer.getCurrentPokemon();
        
        //Getting the Move from the PriorityQueue
        Move thisMove = moveOrder.remove();
               
        //Getting the Move's Damage
        Damage = thisCurrentPoke.getMoveDamage(thisMove, otherCurrentPoke);
        
        //Getting Potential Critical Hit
        Damage = critical.critDamage(Damage);
        
        if (thisCurrentPoke.getStatCondition().equals("Asleep") || thisCurrentPoke.getStatCondition().equals("Frozen"))
        {
            System.out.println(thisCurrentPoke.getName() + " is " + thisCurrentPoke.getStatCondition());
            Damage = 0;
        }
        
        //Subracting damage from opposing Pokemon's health
        otherCurrentPoke.subtractHealth(Damage);
        System.out.println(thisMove.getName() + " did " + Damage + " damage");
        
        //Inflicting Status Condition
        otherCurrentPoke.statConditionTest(thisMove);
        if (!otherCurrentPoke.getStatCondition().equals(""))
        {
            System.out.println(otherCurrentPoke.getName() + " is " + otherCurrentPoke.getStatCondition());
        }
        
        //If opposing Pokemon faints
        if (otherCurrentPoke.getCurrentHealth() <= 0)
        {
            System.out.println(otherCurrentPoke.getName() + " | HP: 0 / " + otherCurrentPoke.getBattleHealth());
            System.out.println(otherCurrentPoke.getName() + " has fainted!");
            System.out.println();
            
            otherTrainer.removePokemon(otherCurrentPoke);
                        
            if (otherTrainer.isEmpty() == false)
            {
                /** Switching in for otherTrainer **/
                System.out.println("Who will you switch in?");
                for (int i = 0; i < otherTrainer.getSize(); i++)
                {
                    System.out.println(otherTrainer.getPokemon(i).getName());
                }
                System.out.println();
                String replace = scan.nextLine();
                            
                boolean correctreplace = false;
                
                while (correctreplace == false)
                {
                    for (int i = 0; i < otherTrainer.getSize(); i++)
                    {
                        if (replace.equals(otherTrainer.getPokemon(i).getName()))
                        {
                            otherTrainer.setCurrentPokemon(otherTrainer.getPokemon(i));
                            correctreplace = true;
                            System.out.println(otherTrainer.getCurrentPokemon().getName() + " has been sent out!");
                            pokemonFainted = true;
                        }
                    }
                           
                    if (correctreplace == false)
                    {
                        System.out.println("Invalid entry");
                        System.out.println("Capitalize the first letter and write the rest lowercase.");
                        replace = scan.nextLine();
                        System.out.println();
                    }
                }
            }
            else
            {
                if (player.getPlayerNumber() == 1)
                {
                    pokemonFainted = true;
                    p1win = true;
                }
                else if (player.getPlayerNumber() == 2)
                {
                    pokemonFainted = true;
                    p2win = true;
                }
            }
        }
        //If opposing Pokemon doesn't faint
        else
        {
            System.out.println(otherCurrentPoke.getName() + " | HP: " + otherCurrentPoke.getCurrentHealth() + " / " + otherCurrentPoke.getBattleHealth());
        }
        
        System.out.println();
    }
}
