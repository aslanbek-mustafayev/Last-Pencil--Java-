import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();
        Random random = new Random(A + B);
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += random.nextInt( B - A + 1) + A;
        }

        System.out.println(sum);
    }
}