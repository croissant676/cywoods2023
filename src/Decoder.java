import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Decoder {
    // author: kason
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("decoder.dat"));
        int testCasesCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCasesCount; i++) {
            String[] parts = sc.nextLine().split("\\+");
            for (String part : parts) {
                String[] tokens = part.strip().split(" ");
                Stack<String> stack = new Stack<>();
                for (String token : tokens) {
                    switch (token) {
                        case "%" -> {
                            String b = stack.pop();
                            String a = stack.pop();
                            stack.add(b);
                            stack.add(a);
                        }
                        case "1" ->  {
                            stack.pop();
                            String a = stack.pop();
                            stack.add(a);
                        }
                        case "2" ->  {
                            String b = stack.pop();
                            stack.pop();
                            stack.add(b);
                        }
                        default -> stack.add(token);
                    }
                }
                StringBuilder s = new StringBuilder();
                for (String token : stack) {
                    s.append(token);
                }
                System.out.print(s.toString().toUpperCase() + " ");
            }
            System.out.println();
        }
    }
}
