package baekjoon_2438;

import java.io.*;
// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
// 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                System.out.print("*");
            } // end for
            System.out.println();
        } // end for
    }
}
