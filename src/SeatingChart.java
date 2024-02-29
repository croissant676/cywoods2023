import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SeatingChart {
    // author: aidan (goat)
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("seating.dat"));
        int l = sc.nextInt();
        sc.nextLine();
        int[] directions = {2, 1, -2, -1};
        List<String> badP = List.of("Nik.S", "Bow.Y", "Hen.F", "Tro.D", "Bra.B", "Jar.A");
        for (int i = 0; i < l; i++) {
            String period = sc.nextLine();
            String[] peoples = sc.nextLine().split(" ");
            List<String> bad = new ArrayList<>();
            List<String> people = new ArrayList<>();
            for (String str : peoples) {
                if (badP.contains(str)) {
                    bad.add(str);
                } else {
                    people.add(str);
                }
            }
            bad.sort(Comparator.comparing(badP::indexOf));
            bad.addAll(people);
            people = bad;
            int n = (int) Math.ceil(Math.sqrt(people.size()));
            String[][] mat = new String[n][n];
            int r = 0, c = 0;
            int dirIn = 0;
            int ring = 1;
            for (int ll = 0; ll < people.size(); ll++) {
                mat[r][c] = people.get(ll);
                if (r == n - ring && dirIn == 1 || c == n - ring && dirIn == 0 || r == ring - 1 && dirIn == 3 || c == ring - 1 && dirIn == 2) {
                    dirIn = (dirIn + 1) % 4;
                    if (dirIn == 3) {
                        ring++;
                    }
                }
                c += directions[dirIn] / 2;
                r += directions[dirIn] % 2;
            }
            List<List<String>> mat2 = new ArrayList<>();
            for (int fj = 0; fj < n; fj++) {
                mat2.add(new ArrayList<>());
            }
            for (int cl = 0; cl < n; cl++) {
                for (int rl = 0; rl < n; rl++) {
                    if (mat[rl][cl] != null) {
                        mat2.get(cl).add(mat[rl][cl]);
                    }
                }
            }
            System.out.println("Period " + period);
            System.out.println("-".repeat(("Period " + period).length()));
            for (int lll = 0; lll < n; lll++) {
                StringJoiner sj = new StringJoiner(" ");
                for(List<String> list : mat2) {
                    if (list.size() > lll) {
                        sj.add(list.get(lll));
                    } else {
                        sj.add("     ");
                    }
                }
                System.out.println(sj);
            }
            System.out.println();
        }
    }

}
