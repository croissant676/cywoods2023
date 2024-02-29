import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class dryrun {
    public static void main(String[] args) throws FileNotFoundException {
        Stream.of(new Scanner(new File("Dryrun.dat"))).forEach(q -> System.out.println("team81\nKason Gu\nAayush Ishware\nAidan Lai\nSeven Lakes High School\nAdvanced\n" + IntStream.range(0, q.nextInt()).map(i -> q.nextInt()).sum()));
    }
}
