//https://codeforces.com/problemset/problem/1914/D

import java.util.*;

public class Main {

    // Pair class to store:
    // val -> number of friends
    // idx -> day index (to ensure distinct days)
    static class Pair {
        int val, idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void solve(Scanner sc) {

        // Number of days
        int n = sc.nextInt();

        // Arrays to store (value, index) for each activity
        Pair[] a = new Pair[n]; // skiing
        Pair[] b = new Pair[n]; // movie
        Pair[] c = new Pair[n]; // board games

        // Read skiing friends with their day index
        for (int i = 0; i < n; i++)
            a[i] = new Pair(sc.nextInt(), i);

        // Read movie friends with their day index
        for (int i = 0; i < n; i++)
            b[i] = new Pair(sc.nextInt(), i);

        // Read board game friends with their day index
        for (int i = 0; i < n; i++)
            c[i] = new Pair(sc.nextInt(), i);

        // Sort each array in descending order of number of friends
        // So best days come first
        Arrays.sort(a, (x, y) -> Long.compare(y.val, x.val));
        Arrays.sort(b, (x, y) -> Long.compare(y.val, x.val));
        Arrays.sort(c, (x, y) -> Long.compare(y.val, x.val));

        // Stores the maximum valid total
        long ans = 0;

        // Try only top 3 elements from each array
        // Reason: if the best conflicts by index,
        // the next best will be within top 3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {

                    // Ensure all three activities are on different days
                    if (a[i].idx != b[j].idx &&
                        a[i].idx != c[k].idx &&
                        b[j].idx != c[k].idx) {

                        // Update maximum sum
                        ans = Math.max(
                            ans,
                            (long) a[i].val + b[j].val + c[k].val
                        );
                    }
                }
            }
        }

        // Print the answer for this test case
        System.out.println(ans);
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
