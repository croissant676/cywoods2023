import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Leftover {
    // author: kason (their judge cases are probably wrong)
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("leftover.dat"));
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            int n = sc.nextInt();
            BigDecimal a = new BigDecimal(sc.nextLine());
            BigDecimal cur = BigDecimal.ZERO;
            for (int j = 0; j < n; j++) {
                String[] str = sc.nextLine().split(" ");
                cur = cur.add(new BigDecimal(str[str.length - 1]));
            }
            if (cur.compareTo(a) > 0) {
                System.out.println("Bowen's crying");
            } else {
                System.out.println("Leftover for Bowen");
            }
        }
    }
}
