import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BattleTime
{
     public static void main(String[] args)
     {
         /** This part creates the moves that the Pokemon uses **/
         //Attack Moves
         Move Flamethrower = new Move("Flamethrower", 95, 100, new Type("Fire"), "Special", 10, 0);
         Move FireBlast = new Move("FireBlast", 120, 85, new Type("Fire"), "Special", 10, 0);
         Move Thunderbolt = new Move("Thunderbolt", 95, 100, new Type("Electric"), "Special", 10, 0);
         Move Thunder = new Move("Thunder", 120, 70, new Type("Fire"), "Special", 10, 0);
         Move IceBeam = new Move("IceBeam", 95, 100, new Type("Ice"), "Special", 10, 0);
         Move Blizzard = new Move("Blizzard", 120, 70, new Type("Ice"), "Special", 10, 0);
         Move Earthquake = new Move("Earthquake", 100, 100, new Type("Ground"), "Physical", 0, 0);
         Move DarkPulse = new Move("DarkPulse", 80, 100, new Type("Dark"), "Special", 0, 0);
         Move Waterfall = new Move("Waterfall", 80, 100, new Type("Water"), "Physical", 0, 0);
         Move ShadowBall = new Move("ShadowBall", 80, 100, new Type("Ghost"), "Special", 0, 0);
         Move EnergyBall = new Move("EnergyBall", 80, 100, new Type("Grass"), "Special", 0, 0);
         Move DragonClaw = new Move("DragonClaw", 80, 100, new Type("Dragon"), "Physical", 0, 0);
         Move FirePunch = new Move("FirePunch", 75, 100, new Type("Fire"), "Physical", 10, 0); 
         Move ThunderPunch = new Move("ThunderPunch", 75, 100, new Type("Electric"), "Physical", 10, 0);
         Move IcePunch = new Move("IcePunch", 75, 100, new Type("Ice"), "Physical", 10, 0);
         Move Surf = new Move("Surf", 95, 100, new Type("Water"), "Special", 0, 0);
         Move Psychic = new Move("Psychic", 90, 100, new Type("Psychic"), "Special", 0, 0);
         Move StoneEdge = new Move("StoneEdge", 100, 80, new Type("Rock"), "Physical", 0, 0);
         Move DrillPeck = new Move("DrillPeck", 80, 100, new Type("Flying"), "Physical", 0, 0);
         Move BrickBreak = new Move("BrickBreak", 75, 100, new Type("Fighting"), "Physical", 0, 0);
         Move SludgeBomb = new Move("SludgeBomb", 95, 100, new Type("Poison"), "Special", 10, 0);
         Move FocusBlast = new Move("FocusBlast", 120, 70, new Type("Fighting"), "Special", 0, 0);
         Move XScissor = new Move("X-Scissor", 80, 100, new Type("Bug"), "Physical", 0, 0);
         Move Slash = new Move("Slash", 70, 100, new Type("Normal"), "Physical", 0, 0);
         Move QuickAttack = new Move("QuickAttack", 40, 100, new Type("Normal"), "Physical", 0, 1);
         Move ShadowSneak = new Move("ShadowSneak", 40, 100, new Type("Ghost"), "Physical", 0, 1);
         Move MachPunch = new Move("MachPunch", 40, 100, new Type("Fighting"), "Physical", 0, 1);
         Move BulletPunch = new Move("BulletPunch", 40, 100, new Type("Steel"), "Physical", 0, 1);
         //Status Moves
         Move WillOWisp = new Move("Will-o-Wisp", 0, 75, new Type("Fire"), "Status", 100, 0);
         Move Hypnosis = new Move("Hypnosis", 0, 60, new Type("Psychic"), "Status", 100, 0);
         Move ThunderWave = new Move("ThunderWave", 0, 100, new Type("Electric"), "Status", 100, 0);
         Move PoisonPowder = new Move("PoisonPowder", 0, 75, new Type("Poison"), "Status", 100, 0);
         
         ArrayList<Pokemon> check = new ArrayList();
         
         /** This part creates the Pokemon used in the game**/
         //Dusknoir
         ArrayList<Move> PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(FirePunch); PokemonMoves.add(ThunderPunch); PokemonMoves.add(IcePunch); PokemonMoves.add(ShadowSneak);
         Pokemon Dusknoir = new Pokemon("Dusknoir", new Type("Ghost"), new Type("None"), 45, 100, 135, 65, 135, 45, PokemonMoves);
         System.out.println(Dusknoir);
         System.out.println();
         check.add(Dusknoir);
         //Garchomp
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Earthquake); PokemonMoves.add(StoneEdge); PokemonMoves.add(DragonClaw); PokemonMoves.add(BrickBreak);
         Pokemon Garchomp = new Pokemon("Garchomp", new Type("Dragon"), new Type("Ground"), 108, 130, 95, 80, 85, 102, PokemonMoves);
         System.out.println(Garchomp);
         System.out.println();
         check.add(Garchomp);
         //Scizor
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(BulletPunch); PokemonMoves.add(XScissor); PokemonMoves.add(Slash); PokemonMoves.add(DrillPeck);
         Pokemon Scizor = new Pokemon("Scizor", new Type("Bug"), new Type("Steel"), 70, 130, 100, 55, 80, 65, PokemonMoves);
         System.out.println(Scizor);
         System.out.println();
         check.add(Scizor);
         //Infernape
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Flamethrower); PokemonMoves.add(Earthquake); PokemonMoves.add(BrickBreak); PokemonMoves.add(MachPunch);
         Pokemon Infernape = new Pokemon("Infernape", new Type("Fire"), new Type("Fighting"), 76, 104, 71, 104, 71, 108, PokemonMoves);
         System.out.println(Infernape);
         System.out.println();
         check.add(Infernape);
         //Feraligatr
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Waterfall); PokemonMoves.add(Slash); PokemonMoves.add(IcePunch); PokemonMoves.add(FirePunch);
         Pokemon Feraligatr = new Pokemon("Feraligatr", new Type("Water"), new Type("None"), 85, 105, 100, 79, 83, 78, PokemonMoves);
         System.out.println(Feraligatr);
         System.out.println();
         check.add(Feraligatr);
         //Venusaur
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(EnergyBall); PokemonMoves.add(SludgeBomb); PokemonMoves.add(PoisonPowder); PokemonMoves.add(FocusBlast);
         Pokemon Venusaur = new Pokemon("Venusaur", new Type("Grass"), new Type("Poison"), 80, 82, 83, 100, 100, 80, PokemonMoves);
         System.out.println(Venusaur);
         System.out.println();
         check.add(Venusaur);
         //Alakazam
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Psychic); PokemonMoves.add(EnergyBall); PokemonMoves.add(ShadowBall); PokemonMoves.add(FocusBlast);
         Pokemon Alakazam = new Pokemon("Alakazam", new Type("Psychic"), new Type("None"), 55, 50, 45, 135, 85, 120, PokemonMoves);
         System.out.println(Alakazam);
         System.out.println();
         check.add(Alakazam);
         //Kingdra
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Surf); PokemonMoves.add(IceBeam); PokemonMoves.add(DarkPulse); PokemonMoves.add(Flamethrower);
         Pokemon Kingdra = new Pokemon("Kingdra", new Type("Water"), new Type("Dragon"), 75, 95, 95, 95, 95, 85, PokemonMoves);
         System.out.println(Kingdra);
         System.out.println();
         check.add(Kingdra);
         //Rhyperior
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Earthquake); PokemonMoves.add(StoneEdge); PokemonMoves.add(IcePunch); PokemonMoves.add(BulletPunch);
         Pokemon Rhyperior = new Pokemon("Rhyperior", new Type("Ground"), new Type("Rock"), 115, 140, 130, 55, 55, 40, PokemonMoves);
         System.out.println(Rhyperior);
         System.out.println();
         check.add(Rhyperior);
         //Electrode
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Thunderbolt); PokemonMoves.add(ThunderWave); PokemonMoves.add(WillOWisp); PokemonMoves.add(QuickAttack);
         Pokemon Electrode = new Pokemon("Electrode", new Type("Electric"), new Type("None"), 60, 50, 70, 80, 80, 140, PokemonMoves);
         System.out.println(Electrode);
         System.out.println();
         check.add(Electrode);
         //Gengar
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(ShadowBall); PokemonMoves.add(DarkPulse); PokemonMoves.add(SludgeBomb); PokemonMoves.add(Hypnosis);
         Pokemon Gengar = new Pokemon("Gengar", new Type("Ghost"), new Type("Poison"), 60, 65, 60, 130, 75, 110, PokemonMoves);
         System.out.println(Gengar);
         System.out.println();
         check.add(Gengar);
         //Rattata
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(Earthquake); PokemonMoves.add(StoneEdge); PokemonMoves.add(Slash); PokemonMoves.add(Blizzard);
         Pokemon Rattata = new Pokemon("Rattata", new Type("Normal"), new Type("None"), 30, 56, 35, 25, 35, 72, PokemonMoves);
         System.out.println(Rattata);
         System.out.println();
         check.add(Rattata);
         //Togekiss
         PokemonMoves = new ArrayList<Move>();
         PokemonMoves.add(FocusBlast); PokemonMoves.add(Flamethrower); PokemonMoves.add(Psychic); PokemonMoves.add(ShadowBall);
         Pokemon Togekiss = new Pokemon("Togekiss", new Type("Normal"), new Type("Flying"), 85, 50, 95, 120, 115, 80, PokemonMoves);
         System.out.println(Togekiss);
         System.out.println();
         check.add(Togekiss);
         
         ArrayList<Pokemon> p1 = new ArrayList<Pokemon>();
         ArrayList<Pokemon> p2 = new ArrayList<Pokemon>();
         
         System.out.println("Enter the Pokemon names exactly as you see them.");
         System.out.println("You cannot choose a Pokemon already chosen by your opponent");
         System.out.println();
         
         Scanner scan = new Scanner(System.in);
         
         for (int i = 0; i < 3; i++)
         {
             boolean validChoice1 = false;
             boolean validChoice2 = false;
             
             while (validChoice1 == false)
             {
                 System.out.println("Player 1, please enter a Pokemon name.");
                 String choice1 = scan.nextLine();
                 
                 for (int j = 0; j < check.size(); j++)
                 {
                     if (check.get(j).getName().equals(choice1))
                     {
                         p1.add(check.get(j));
                         check.remove(j);
                         validChoice1 = true;
                     }
                 }
                 
                 if (validChoice1 == false)
                 {
                     System.out.println("Invalid choice");
                 }
             }
             
             System.out.println();
             
             while (validChoice2 == false)
             {
                 System.out.println("Player 2, please enter a Pokemon name.");
                 String choice2 = scan.nextLine();
                 
                 for (int k = 0; k < check.size(); k++)
                 {
                     if (check.get(k).getName().equals(choice2))
                     {
                         p2.add(check.get(k));
                         check.remove(k);
                         validChoice2 = true;
                     }
                 }
                 
                 if (validChoice2 == false)
                 {
                     System.out.println("Invalid choice");
                 }
             }
             
             System.out.println();
         }

         Trainer Player1 = new Trainer(p1, 1);
         Trainer Player2 = new Trainer(p2, 2);
         
         System.out.print('\f');
         System.out.println("Trainer 1: " + p1.get(0).getName() + ", " + p1.get(1).getName() + ", " + p1.get(2).getName());
         System.out.println();
         System.out.println("Trainer 2: " + p2.get(0).getName() + ", " + p2.get(1).getName() + ", " + p2.get(2).getName());
         System.out.println();
         
         Battle battle = new Battle(Player1, Player2);
         battle.PokemonStart();
     }
}
