import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class friday {
    // author: kason
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("friday.dat"));
        int testCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCount; i++) {
            int month = sc.nextInt() - 1;
            int day = sc.nextInt();
            int year = sc.nextInt();
            if (day == 13 && new GregorianCalendar(year, month, day).get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                System.out.println("DON'T TEST YOUR LUCK!");
            } else {
                System.out.println("NO WORRIES!");
            }
        }
    }
}
