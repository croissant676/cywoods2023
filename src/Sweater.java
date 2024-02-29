import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sweater {
    // author: aidan
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sweater.dat"));

        while (sc.hasNext()) {
            int s = Integer.parseInt(sc.nextLine());
            String s1 = "X".repeat(4 * s + 3);
            String s2 = ("X".repeat(s) + "*").repeat(3) + "X".repeat(s);
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < s; j++) {
                    System.out.println(s1);
                }
                System.out.println(s2);
            }
            for (int i = 0; i < s; i++) {
                System.out.println(s1);
            }
            System.out.println();
        }

    }

}
