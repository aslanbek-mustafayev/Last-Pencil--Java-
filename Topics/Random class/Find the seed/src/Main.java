import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();
        final int N = scanner.nextInt();
        final int K = scanner.nextInt();
        int minAmongMax = K;
        int max = 0;
        int index = 0;
        int[] arrOfRandoms = new int[(B - A + 1) * N];
        int[] seeds = new int[B - A + 1];
        int seedOutput = A;

        for (int i = 0, j = A; j <= B; i++, j++) {
            seeds[i] = j;
        }

        for (int seed : seeds) {
            Random random = new Random(seed);
            for (int j = 0; j < N; j++, index++) {
                arrOfRandoms[index] = random.nextInt(K);
                max = Math.max(max, arrOfRandoms[index]);
            }

            if (minAmongMax > max) {
                minAmongMax = max;
                seedOutput = seed;
            } else if (minAmongMax == max) {
                seedOutput = Math.min(seedOutput, seed);
            }
            max = 0;
        }

        System.out.println(seedOutput + "\n" + minAmongMax);
    }
}