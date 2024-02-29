import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shuffle {
    // author: aidan
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("shuffle.dat"));
        int tc = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tc; i++) {
            String line = sc.nextLine();
            List<String> list = new ArrayList<>(List.of(line.split(" ")));
            int shift = Integer.parseInt(list.remove(list.size() - 1));
            if (shift < 0) {
                int realShift = -(shift % list.size());
                List<String> partsToShift = list.subList(0, realShift);
                List<String> remaining = list.subList(realShift, list.size());
                for (String s : remaining) {
                    System.out.print(s + " ");
                }
                for (String s : partsToShift) {
                    System.out.print(s + " ");
                }
                System.out.println();
            } else if (shift == 0) {
                System.out.println(line);
            } else {
                int realShift = shift % list.size();
                List<String> partsToShift = list.subList(list.size() - realShift, list.size());
                List<String> remaining = list.subList(0, list.size() - realShift);
                for (String s : partsToShift) {
                    System.out.print(s + " ");
                }
                for (String s : remaining) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }
}
