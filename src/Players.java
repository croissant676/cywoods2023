import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Players {
    // author: aidan (goat)
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("players.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            sc.nextLine();
            List<Chef> chefs = new ArrayList<>();
            for (int j = 0; j < p; j++) {
                String[] data = sc.nextLine().split(" - ");
                String[] stuff = data[1].split(" ");
                if (Integer.parseInt(stuff[4]) < 175) {
                    continue;
                }
                Chef c = new Chef(data[0], Double.parseDouble(stuff[1]), Double.parseDouble(stuff[0]), Integer.parseInt(stuff[2]), Double.parseDouble(stuff[3]), Integer.parseInt(stuff[4]));
                chefs.add(c);
            }
            Collections.sort(chefs);
            for (int f = 0; f < chefs.size(); f++) {
                System.out.println("#" + (f + 1) + ": " + chefs.get(f));
            }
            System.out.println("*".repeat(15));
        }
    }
    static class Chef implements Comparable<Chef>{
        double h;
        int p;
        double j;
        int w;
        String name;
        double s;

        public Chef(String n, double s, double h, int p, double k, int w) {
            name = n;
            this.s = s;
            this.h = h;
            this.p = p;
            this.j = k;
            this.w = w;
        }


        @Override
        public int compareTo(Chef o) {
            double sd = o.s - s;
            if (sd != 0) {
                return (int) (sd * 100000);
            }
            double hd = o.h - h;
            if (hd != 0) {
                return (int) (hd * 100000);
            }
            int pd = p - o.p;
            if (pd != 0) {
                return pd;
            }
            double jd = o.j - j;
            if (jd != 0) {
                return (int) (jd * 100000);
            }
            else return o.w - w;
        }

        @Override
        public String toString() {
            return name + " - " + List.of("point guard", "shooting guard", "small forward", "power forward", "center").get(p - 1);
        }
    }


}

