import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//author: aidan (goat)
public class Donuts {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("donuts.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        int[] dirs = {2, 1, -2, -1};
        for (int i = 0; i < n; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int dirIn = 0;
            sc.nextLine();
            String[] mat = new String[row];
            for (int j = 0; j < row; j++) {
                mat[j] = sc.nextLine();
            }
            int r = 0, c = 0;
            int ring = 1;
            for (int j = 0; j < row * col; j++) {
                System.out.print(mat[r].charAt(c));
                if (r == row - ring && dirIn == 1 || c == col - ring && dirIn == 0 || r == ring - 1 && dirIn == 3 || c == ring - 1 && dirIn == 2) {
                    dirIn = (dirIn + 1) % 4;
                    if (dirIn == 3) {
                        ring++;
                    }
                }
                c += dirs[dirIn] / 2;
                r += dirs[dirIn] % 2;
            }
            System.out.println();
        }
    }

}
