import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// author: aidan
public class ChristmasTree {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ChristmasTree.dat"));
        int r = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            int h = sc.nextInt();
            sc.nextLine();
            String[] data = sc.nextLine().split(" ");
            Set<Integer> list = new HashSet<>();
            for (int j = 1; j < data.length; j++) {
                list.add(Integer.parseInt(data[j]));
            }
            int index = 1;
            for (int row = 1; row <= h; row++) {
                System.out.print(" ".repeat(h - row) + "/");
                for (int k = 2; k < 2 * row; k++, index++) {
                    System.out.print(list.remove(index) ? data[0] : "-");
                }
                System.out.println("\\" + " ".repeat(h - row));
            }
            System.out.println(" ".repeat(h - 1) + "||");
            System.out.println();
        }
    }
}
