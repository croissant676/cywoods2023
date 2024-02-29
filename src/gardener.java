import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// author: kason
public class gardener {

    static class N {
        int num;
        List<Integer> connections = new ArrayList<>();
        boolean v = false;

        public N(int num) {
            this.num = num;
        }

        public boolean visit(N[] n, N par) {
            if (this.v) return false;
            this.v = true;
            boolean a = true;
            for (int connection : this.connections) {
                N node = n[connection];
                if (node != par) {
                    a = a && node.visit(n, this);
                }
            }
            return a;
        }

        @Override
        public String toString() {
            return "N{" +
                    "num=" + num +
                    ", connections=" + connections +
                    ", v=" + v +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("gardener.dat"));
        int tc = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            N[] nodes = new N[N];
            for (int j = 0; j < N; j++) {
                nodes[j] = new N(j);
            }
            for (int j = 0; j < M; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodes[a].connections.add(b);
                nodes[b].connections.add(a);
            }
            if (nodes[0].visit(nodes, new N(-1))) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
