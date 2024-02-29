import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ingredients {
    // author: aidan
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Ingredients.dat"));
        int stuff = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < stuff; i++) {
            Set<Integer> has = new HashSet<>();
            Set<Integer> recipe = new HashSet<>();
            int hasN = sc.nextInt();
            int recipeN = sc.nextInt();
            for (int j = 0; j < hasN; j++) {
                has.add(sc.nextInt());
            }
            for (int j = 0; j < recipeN; j++) {
                recipe.add(sc.nextInt());
            }
            if (!has.containsAll(recipe)) {
                System.out.println(":(");
            } else if (has.contains(1)) {
                System.out.println("Time to take a trip to the stratosphere!");
            } else {
                System.out.println("I guess it's time to have a normal brownie...");
            }
        }
    }

}
