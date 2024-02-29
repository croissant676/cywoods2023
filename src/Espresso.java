import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Espresso {
    // author: aayush
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("espresso.dat"));
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            int max = 0;
            double maxB = 0;
            for (int j = 1; j <= x; j++) {
                double b = ((double) (sc.nextInt())) / sc.nextInt();
                if (b > maxB) {
                    maxB = b;
                    max = j;
                }
            }
            System.out.println(max);
        }
    }
}
