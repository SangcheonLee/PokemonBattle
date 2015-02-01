public class ModifierMessages
{
    public static void printMessage(double modifier)
    {
        if (modifier > 1)
        {
            System.out.println("Super effective!");
        }
        else if (modifier == 0)
        {
            System.out.println("No effect.");
        }
        else if (modifier < 1)
        {
            System.out.println("It's not very effective...");
        }
    }
}
