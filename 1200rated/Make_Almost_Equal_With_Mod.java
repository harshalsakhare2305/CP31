//https://codeforces.com/problemset/problem/1909/B
import java.util.*;

public class Main {

    public static void solve(Scanner sc) {

        // Read number of elements
        int n = sc.nextInt();

        // Array to store the given numbers
        long[] arr = new long[n];

        // Read the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // We try different powers of two (k)
        // k = 2^(i+1) because we use 2L << i
        // i goes up to 60 since values can be large (long range)
        for (int i = 0; i < 60; i++) {

            // Set to store distinct remainders modulo k
            HashSet<Long> set = new HashSet<>();

            // Compute k as a power of two using long shifting
            // Using 2L ensures no integer overflow
            long k = 2L << i;

            // Compute remainder of each element modulo k
            for (int j = 0; j < n; j++) {
                long rem = arr[j] % k;
                set.add(rem);
            }

            // If exactly two distinct remainders exist,
            // then this k satisfies the condition
            if (set.size() == 2) {
                System.out.println(k);
                return;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        // Solve each test case
        while (t-- > 0) {
            solve(sc);
        }
    }
}

