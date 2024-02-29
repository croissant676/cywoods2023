import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Slow {
    // author: kason
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("slow.dat"));
        int testC = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testC; i++) {
            int c = Arrays.stream(sc.nextLine().split("\\+")).mapToInt(Integer::parseInt).sum();
            System.out.println("1+".repeat(c - 1) + "1 makes " + c + "!");
        }
    }
}
