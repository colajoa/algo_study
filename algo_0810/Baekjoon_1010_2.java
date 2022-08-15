package algo_0810;

import java.util.Scanner;

public class Baekjoon_1010_2 {

    static double comb(double m, double n) {
        double M = 1;
        double N = 1;

        for (double i = m; i > m - n; i--) {
            M *= i;
        }

        for (double i = n; i > 0; i--) {
            N *= i;
        }
        return M / N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            double N = sc.nextDouble();
            double M = sc.nextDouble();

            System.out.printf("%.0f\n", comb(M, N));
        }

    }
}
