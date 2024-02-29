import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//author: aayush probably right
public class cookies {
    public static void main(String[] args) throws IOException {
        String[] info2 = "cups, cups, teaspoons, cups, cups, eggs".split(", ");
        String[] info = "flour, butter, baking soda, sugar, royal icing, ".split(", ");
        Scanner in = new Scanner(new File("cookies.dat"));
        while(in.hasNextLine()) {
            String order = in.nextLine();
            String[] data = order.split(" ", 6);
            int orders = Integer.parseInt(data[0]);
            String name = data[5];
            boolean[] isDouble = {false, true, true, false, true, false};
            double[] stuff = {2, 0.75, 1.5, 3, 0.5, 1};
            for(int i = 0; i < stuff.length; i++) {
                stuff[i] = stuff[i] * orders;
            }
            if(isShrank(name)) {
                System.out.println("DO NOT SELL!!!\n");
                continue;
            }
            for(int i = 0; i < 6; i++) {
                String line = "";
                if(isDouble[i]) {
                    line+= String.format("%.2f", stuff[i]);
                }
                else {
                    line+=(int)stuff[i];
                }
                line += " " + info2[i];
                if(stuff[i] == 1) {
                    line= line.substring(0, line.length() - 1);

                }
                if(i != 5) {
                    line += " of " + info[i];
                }
                System.out.println(line);
            }
            System.out.println();
        }

    }


    public static boolean isShrank(String name) {
        String[] firstLast = name.split(" ");
        if(firstLast.length != 2)
            return false;
        int[ ]firstName = {0, 0, 0, 0, 0, 0};
        int[] lastName = new int[5];
        for(int i = 0; i < firstLast[0].length(); i++) {
            String letter = firstLast[0].substring(i, i+1).toLowerCase();
            if(!"shrank".contains(letter))
                return false;
            if(firstName["shrank".indexOf(letter)] ==0)
                firstName["shrank".indexOf(letter)] = 1;
            else return false;
        }

        for(int i = 0; i < firstLast[1].length(); i++) {
            String letter = firstLast[1].substring(i, i+1).toLowerCase();
            if(!"fraeder".contains(letter))
                return false;
            if(lastName["fraeder".indexOf(letter)] ==0)
                lastName["fraeder".indexOf(letter)] = 1;
            else if(lastName["fraeder".indexOf(letter)] == 1 && (letter.equals("r") || letter.equals("e")))
                lastName["fraeder".indexOf(letter)] = 2;
            else
                return false;
        }
        return true;
    }
}
