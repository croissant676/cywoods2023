import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Word {
    // author: aayush
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("word.dat"));
        int tc = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int y = 0;
            for (int j = 0; j < n; j++) {
                String x = sc.nextLine();
                for (int k = 0; k < x.length() - 8; k++) {
                    if (x.substring(k, k + 9).equalsIgnoreCase("christmas")) {
                        y++;
                    }
                }
            }
            System.out.println(y);
        }
    }
}
